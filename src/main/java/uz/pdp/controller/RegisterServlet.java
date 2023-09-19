package uz.pdp.controller;

import uz.pdp.Service.DBService;
import uz.pdp.model.ApiResult;
import uz.pdp.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    DBService dbService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("adasda");
        resp.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String prePassword = req.getParameter("prePassword");
        if (!password.equals(prePassword)) {
            req.setAttribute("errorMessage", "Password not match");
            req.getRequestDispatcher("register.jsp").include(req, resp);
            return;
        }

        User user = User.builder()
                .name(name)
                .username(username)
                .password(password)
                .prePassword(prePassword)
                .build();


        initializeDbService();
        ApiResult apiResult = dbService.register(user);
        if (apiResult.isSuccess()) {
            resp.sendRedirect("cabinet?name=" + name);
        } else {
            req.setAttribute("errorMessage", apiResult.getMessage());
            req.getRequestDispatcher("register.jsp").include(req, resp);
        }
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
