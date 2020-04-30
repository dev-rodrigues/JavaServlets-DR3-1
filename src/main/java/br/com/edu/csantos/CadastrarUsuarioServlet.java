/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edu.csantos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author csantos
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //1- Receber os parâmetros
        Usuario usuario = new Usuario(
                request.getParameter("nome")
            ,   request.getParameter("email")
            ,   request.getParameter("senha"));
        
        
        //2- Validar os parâmetros
        List<String> erros = new ArrayList<String>();
        if (StringUtils.isBlank(usuario.getNome())) {
            erros.add("O campo Nome é obrigatório");
        }

        if (StringUtils.isBlank(usuario.getEmail())) {
            erros.add("O campo Email é obrigatório");
        }

        if (StringUtils.isBlank(usuario.getSenha())) {
            erros.add("O campo Senha é obrigatório");
        }

        //3- Processar
        if(erros.isEmpty()) {
            String partes[] = usuario.getNome().split(" ");
            request.setAttribute("sucesso", "O cadastro do " + partes[0] + " foi </br> realizado com sucesso");
        } else {            
            request.setAttribute("usuario", usuario);
            request.setAttribute("erros", erros);
        }

        //4- Responder
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
