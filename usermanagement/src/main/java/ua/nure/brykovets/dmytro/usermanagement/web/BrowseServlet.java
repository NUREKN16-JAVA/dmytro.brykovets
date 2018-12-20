package ua.nure.brykovets.dmytro.usermanagement.web;

import ua.nure.brykovets.dmytro.usermanagement.User;
import ua.nure.brykovets.dmytro.usermanagement.db.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class BrowseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("addButton") != null) {
            addUser(req, resp);
        } else if (req.getAttribute("editButton") != null) {
            editUser(req, resp);
        } else if (req.getAttribute("deleteButton") != null) {
            deleteUser(req, resp);
        } else if (req.getAttribute("detailsButton") != null) {
            userDetails(req, resp);
        } else {
            browse(req, resp);
        }
    }

    private void browse(HttpServletRequest req, HttpServletResponse resp) {
        Collection<User> users;
        try {
            users = DaoFactory.getInstance().getUserDao().findAll();
            req.getSession().setAttribute("users", users);
            req.getRequestDispatcher("/browse.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void userDetails(HttpServletRequest req, HttpServletResponse resp) {
    }
}
