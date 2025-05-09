package web;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.EtudiantDao;
import dao.IEtudiantDao;
import domain.Etudiant;

@WebServlet("/supprimer")
public class SupprimerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IEtudiantDao dao = new EtudiantDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        dao.delete(code);
        List<Etudiant> l = dao.findAll();
        request.setAttribute("all", l);
        request.getRequestDispatcher("etudiants.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
