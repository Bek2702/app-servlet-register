package uz.pdp.controller;

import uz.pdp.Service.DBService;
import uz.pdp.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    DBService dbService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("login.jsp");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        initializeDbService();

        User user = dbService.login(username, password);
        if (user == null) {
            req.setAttribute("errorMessage", "Login or password incorrect");
            req.getRequestDispatcher("login.jsp").include(req, resp);
        } else {
            createSession(req, user);
            resp.sendRedirect("/cabinet");
        }

    }

    private void createSession(HttpServletRequest req, User user) {
        HttpSession session = req.getSession();
        session.setAttribute("id", user);
    }

    private void initializeDbService() {
        if (dbService == null) {
            ServletContext servletContext = getServletContext();
            dbService = new DBService(
                    servletContext.getInitParameter("dbUrl"),
                    servletContext.getInitParameter("dbUsername"),
                    servletContext.getInitParameter("dbPassword")
            );
        }
    }
}
