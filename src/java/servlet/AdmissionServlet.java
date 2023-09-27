/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import model.Admission;
import model.Admission;
import service.ApplyInterface;
import service.ApplyService;


@MultipartConfig
public class AdmissionServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException{
        response.setContentType("text/html;charset=UTF-8");
        DateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
        try (PrintWriter out = response.getWriter()) {

            
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String faculty = request.getParameter("faculty");
            String major = request.getParameter("major");
            String date = request.getParameter("dob");
            byte[] pic;
            byte[] pdf;
            javax.servlet.http.Part picpart = request.getPart("image");
            javax.servlet.http.Part pdfpart = request.getPart("pdf");
            
            InputStream pictureContent = picpart.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[2046];
            int x = 0;
            while((pictureContent.read(buf))!= -1){
            output.write(buf);
            }
            pic = output.toByteArray();
            
            InputStream pdfContent = pdfpart.getInputStream();
            ByteArrayOutputStream outi = new ByteArrayOutputStream();
            byte[] buff = new byte[2046];
            int y = 0;
            while((pdfContent.read(buf))!= -1){
            outi.write(buff);
            }
            pdf = outi.toByteArray();

//            String pic = request.getParameter("image");
//            String pdf = request.getParameter("pdf");
            
//            Date dob = null;
            Date dob = formatter.parse(date);
            //System.out.println(dob);
            String gender = request.getParameter("gender");
            String phoneNumber = request.getParameter("phone");
            String password = request.getParameter("password");
            
            
            Admission student = new Admission(fname,lname,email,faculty,major,dob,gender,phoneNumber,password,pdf,pic);
            ApplyInterface stuInt = new ApplyService();
            boolean result = stuInt.RegisterAccount(student);
            
            
            out.println("Registered Successfully!!!");
            //System.out.println("NDAHAGERA");



        } catch (ParseException ex) {
           System.out.println("waever ");
        }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(AdmissionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(AdmissionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}

//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AdmissionServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AdmissionServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
