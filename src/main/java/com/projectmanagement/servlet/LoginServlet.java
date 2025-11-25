package com.projectmanagement.servlet;

import com.projectmanagement.dao.UserDAO;
import com.projectmanagement.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User u = userDAO.findByEmailAndPassword(email, password);

        if (u == null) {
            req.setAttribute("error", "Invalid credentials");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", u);

        switch (u.getRole()) {
            case "admin":
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard.jsp");
                break;

            case "pm":
                resp.sendRedirect(req.getContextPath() + "/pm/dashboard.jsp");
                break;

            default:
                resp.sendRedirect(req.getContextPath() + "/member/dashboard.jsp");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
