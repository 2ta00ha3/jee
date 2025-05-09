package web;

import dao.EtudiantDaoJPA;
import dao.IEtudiantDao;
import domain.Etudiant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Controleur")
public class Controleur extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IEtudiantDao dao = new EtudiantDaoJPA();

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("supprimer".equals(action)) {
            String code = request.getParameter("code");
            dao.delete(code);
            List<Etudiant> listeEtudiants = dao.findAll();
            request.setAttribute("all", listeEtudiants);
            request
                .getRequestDispatcher("etudiants.jsp")
                .forward(request, response);
        } else if ("modifier".equals(action)) {
            String code = request.getParameter("code");
            Etudiant e = dao.findByCode(code);
            request.setAttribute("etud", e);
            List<Etudiant> listeEtudiants = dao.findAll();
            request.setAttribute("all", listeEtudiants);
            request
                .getRequestDispatcher("etudiants.jsp")
                .forward(request, response);
        } else {
            List<Etudiant> listeEtudiants = dao.findAll();
            request.setAttribute("all", listeEtudiants);
            request
                .getRequestDispatcher("etudiants.jsp")
                .forward(request, response);
        }
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String code = request.getParameter("code");
        String nom = request.getParameter("nom");
        String ville = request.getParameter("ville");
        int age = Integer.parseInt(request.getParameter("age"));
        Etudiant e = new Etudiant(code, nom, ville, age);
        dao.add(e);
        List<Etudiant> listeEtudiants = dao.findAll();
        request.setAttribute("all", listeEtudiants);
        request
            .getRequestDispatcher("etudiants.jsp")
            .forward(request, response);
    }
}
