/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedago
 */
public class Controleur extends HttpServlet {

    int essais=0;
    int nombre=-1;
    String playerName;
    Joueur joueur;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        this.playerName = request.getParameter("playerName");
        String guess = request.getParameter("guess");
        
        
        if("Connexion".equals(action) && !playerName.equals(null)){
            request.setAttribute("playerName", this.playerName);
            Random r = new Random();
            int valeur = 0 + r.nextInt(100 - 0);
            this.nombre=valeur;
            request.setAttribute("essais", this.essais);
            
            if(this.joueur!=null){
            request.setAttribute("bestessais", this.joueur.score);
            request.setAttribute("bestjoueur", this.joueur.nom);
            }
            request.getRequestDispatcher("jeu.jsp").forward(request, response);
        }
        else if("Deviner".equals(action)){
            int prop = Integer.valueOf(guess);
            if(prop==this.nombre){
                this.essais+=1;
                if(this.joueur==null || this.joueur.score>=this.essais ){
                    this.joueur= new Joueur(this.playerName,this.essais);
                }
                request.getRequestDispatcher("victoire.jsp").forward(request, response);
            }else{
            this.essais+=1;
            if(this.joueur!=null){
            request.setAttribute("bestessais", this.joueur.score);
            request.setAttribute("bestjoueur", this.joueur.nom);
            }
            request.setAttribute("playerName", this.playerName);
            request.setAttribute("essais", this.essais);
            request.setAttribute("prop", prop);
            request.setAttribute("val", this.nombre);
            request.getRequestDispatcher("jeu.jsp").forward(request, response);
            }
        }
        else if("Déconnexion".equals(action) && !playerName.equals(null)){
            request.getRequestDispatcher("accueil.jsp").forward(request, response);
        }
        else if("Rejouer".equals(action)){
            request.setAttribute("playerName", this.playerName);
            Random r = new Random();
            int valeur = 0 + r.nextInt(100 - 0);
            this.nombre=valeur;
            this.essais=0;
            request.setAttribute("essais", this.essais);
            request.getRequestDispatcher("jeu.jsp").forward(request, response);
        }
        
        else{request.getRequestDispatcher("acceuil.jsp").forward(request, response);
        
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
