package ua.nure.brykovets.dmytro.usermanagement.web;

import ua.nure.brykovets.dmytro.usermanagement.User;
import ua.nure.brykovets.dmytro.usermanagement.db.DaoFactory;
import ua.nure.brykovets.dmytro.usermanagement.db.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

abstract class UserServlet extends HttpServlet {

    private String jspTemplatePath;

    public UserServlet() {
        super();
        jspTemplatePath = getJspTemplatePath();
    }

    abstract String getJspTemplatePath();

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        if (req.getParameter("okButton") != null) {
            doOk(req, res);
        } else if (req.getParameter("cancelButton") != null) {
            doCancel(req, res);
        } else {
            showPage(req, res);
        }
    }

    void showPage(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher(jspTemplatePath).forward(req, res);
    }

    void doOk(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            User user = getUser(req);
            DaoFactory.getInstance().getUserDao().update(user);
            req.getRequestDispatcher("/browse.jsp").forward(req, res);
        } catch (ValidationException e) {
            req.setAttribute("error", e.getMessage());
            showPage(req, res);
        } catch (DatabaseException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    void doCancel(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/browse.jsp").forward(req, res);
    }

    User getUser(ServletRequest req) throws ValidationException {

        String firstName = req.getParameter("firstName");
        if (firstName == null) {
            throw new ValidationException("Invalid First name.");
        }
        String lastName = req.getParameter("lastName");
        if (lastName == null) {
            throw new ValidationException("Invalid Last name.");
        }

        String dateOfBirthString = req.getParameter("dateOfBirth");
        if (dateOfBirthString == null) {
            throw new ValidationException("Invalid Date of birth.");
        }

        try {
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);

            return new User(firstName, lastName, dateOfBirth);
        } catch (DateTimeParseException e) {
            throw new ValidationException("Invalid Date of birth.");
        }
    }

}
