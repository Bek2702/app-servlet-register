package uz.pdp.controller;

import uz.pdp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cabinet")
public class CabinetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object id = session.getAttribute("id");
        if (id == null) {
            resp.sendRedirect("login.jsp");
        } else {
            User user = (User) id;
            req.setAttribute("user", user);
            req.getRequestDispatcher("cabinet.jsp").include(req, resp);
        }
    }
}
