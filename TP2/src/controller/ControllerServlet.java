package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.ContactFacade;

public class ControllerServlet extends HttpServlet {

    private ContactFacade contactFacade;

    public ControllerServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("*** initializing controller servlet.");
        super.init(config);
        contactFacade = new ContactFacade();
    }

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String do_this = request.getParameter("do_this");
        ServletContext sc = getServletContext();
        RequestDispatcher rd;

        if (do_this == null) {
            request.setAttribute("listContacts", contactFacade.findAll());
            rd = sc.getRequestDispatcher("/accueil.jsp");
            rd.forward(request, response);
        } else {
            switch (do_this) {
                case "create":
                    String lastName = request.getParameter("lastName");
                    if (lastName == null) {
                        response.sendRedirect("addContact.jsp");
                    } else {
                        contactFacade.createContact(
                            request.getParameter("firstName"),
                            lastName,
                            request.getParameter("email"),
                            request.getParameter("phone"),
                            request.getParameter("address")
                        );
                        response.sendRedirect("ControllerServlet");
                    }
                    break;
                case "delete":
                    String id = request.getParameter("contact_id");
                    if (id == null) {
                        response.sendRedirect("removeContact.jsp");
                    } else {
                        contactFacade.deleteContact(id);
                        response.sendRedirect("ControllerServlet");
                    }
                    break;
                case "update":
                    String updateId = request.getParameter("contact_id");
                    if (updateId == null) {
                        response.sendRedirect("updateContact.jsp");
                    } else if (request.getParameter("firstName") == null) {
                        request.setAttribute(
                            "contact",
                            contactFacade.findById(updateId)
                        );
                        rd = sc.getRequestDispatcher("/updateContact.jsp");
                        rd.forward(request, response);
                    } else {
                        contactFacade.updateContact(
                            Long.parseLong(updateId),
                            request.getParameter("firstName"),
                            request.getParameter("lastName"),
                            request.getParameter("email"),
                            request.getParameter("phone"),
                            request.getParameter("address")
                        );
                        response.sendRedirect("ControllerServlet");
                    }
                    break;
                case "search":
                    String searchId = request.getParameter("contact_id");
                    if (searchId == null) {
                        response.sendRedirect("searchContact.jsp");
                    } else {
                        request.setAttribute(
                            "contact",
                            contactFacade.findById(searchId)
                        );
                        rd = sc.getRequestDispatcher("/searchContact.jsp");
                        rd.forward(request, response);
                    }
                    break;
            }
        }
    }
}
