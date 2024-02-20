/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAL.DAO;
import Model.Human;
import Model.HumanType;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author admin
 */
public class updateHuman extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateHuman</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateHuman at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);

        String id = request.getParameter("id");
        
        DAO dao = new DAO();
            
        try {
            int idParse = Integer.parseInt(id);
            Human humanInList = dao.getHumanById(idParse);
            List<HumanType> listHumanType = dao.getListHumanType();

            request.setAttribute("humanInList", humanInList);
            request.setAttribute("humanTypeInList", listHumanType);
//            response.sendRedirect("listHuman");
            request.getRequestDispatcher("Views/UpdateHuman.jsp").forward(request, response);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);

        DAO dao = new DAO();
        List<Human> list = dao.getHuman();
        String id = request.getParameter("getId");
        String humanName = request.getParameter("getName");
        String DOB = request.getParameter("getDOB");
        String gender = request.getParameter("getGender");
        String typeID = request.getParameter("getTypeId");
        boolean check = true;
        if(gender.equals("female")){
            check = false;
        }
        
        
        
        
        
        
        try {      
            int idParse = Integer.parseInt(id);
            int typeIdParse =  Integer.parseInt(typeID);
            for (Human human : list) {
//            if(human.getID() == idParse){
//                String err = "ID existed, ADD FALSE!!!!";
//                request.setAttribute("err", err);
//                request.getRequestDispatcher("Views/AddHuman.jsp").forward(request, response);
//            }
        }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(DOB);
            java.sql.Date newDate = new java.sql.Date(date.getTime());
            
            HumanType humanType = dao.getTypeNameById(typeIdParse);
                        
            Human newHuman = new Human(idParse, humanName,newDate, check, humanType);
            dao.updateHuman(newHuman);
            response.sendRedirect("listHuman");
        } catch (Exception e) {
//            request.getRequestDispatcher("Views/AddHuman.jsp").forward(request, response);
            System.out.println(e);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
