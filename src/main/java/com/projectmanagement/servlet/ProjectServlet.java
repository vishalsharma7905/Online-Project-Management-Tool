package com.projectmanagement.servlet;

import com.projectmanagement.dao.ProjectDAO;
import com.projectmanagement.model.Project;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ProjectServlet extends HttpServlet {

    private ProjectDAO projectDAO = new ProjectDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        // ========== RENAME PROJECT ==========
        if ("rename".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");

            projectDAO.updateTitle(id, title);
            resp.sendRedirect(req.getContextPath() + "/admin/dashboard.jsp");
            return;
        }

        // ========== CREATE PROJECT ==========
        if ("create".equals(action)) {
            Project p = new Project();

            p.setTitle(req.getParameter("title"));
            p.setDescription(req.getParameter("description"));

            try {
                String sd = req.getParameter("start_date");
                String ed = req.getParameter("end_date");

                if (sd != null && !sd.isEmpty()) {
                    p.setStartDate(java.sql.Date.valueOf(sd));
                }
                if (ed != null && !ed.isEmpty()) {
                    p.setEndDate(java.sql.Date.valueOf(ed));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String managerId = req.getParameter("manager_id");
            if (managerId != null && !managerId.isEmpty()) {
                p.setManagerId(Integer.parseInt(managerId));
            }

            projectDAO.create(p);
            resp.sendRedirect(req.getContextPath() + "/admin/dashboard.jsp");
            return;
        }

        resp.sendError(400, "Invalid ProjectServlet action");
    }
}
