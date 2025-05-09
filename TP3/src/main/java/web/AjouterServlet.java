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

@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IEtudiantDao dao = new EtudiantDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String nom = request.getParameter("nom");
        String ville = request.getParameter("ville");
        int age = Integer.parseInt(request.getParameter("age"));
        Etudiant e = new Etudiant(code, nom, ville, age);
        dao.add(e);
        List<Etudiant> l = dao.findAll();
        request.setAttribute("all", l);
        request.getRequestDispatcher("etudiants.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
