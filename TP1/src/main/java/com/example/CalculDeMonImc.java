package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculDeMonImc")
public class CalculDeMonImc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");

        double poids = Double.parseDouble(poidsStr);
        double taille = Double.parseDouble(tailleStr);

        Imc imc = new Imc(taille, poids);
        double result = imc.calcul();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        	out.println("<h1>Votre IMC est " + String.format("%.2f", result) + "</h1>");
        out.println("</body></html>");
    }
}