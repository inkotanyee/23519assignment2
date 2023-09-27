package servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.FilterChain;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Signup;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import servlet.SendEmail;
 
//@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
// Query query = session.createQuery("FROM Signup so WHERE so.email = :email  AND so.password = :password");
    Signup user = (Signup) session.createQuery("FROM Signup so WHERE so.email = :email  AND so.password = :password")
        .setParameter("email", email)
        .setParameter("password", password)
        .uniqueResult();
     System.out.println(user.getEmail()); 
         
   
    if (user != null) {
      HttpSession sess = request.getSession(true);
      sess.setAttribute("userId", Long.valueOf(user.getId()));
      request.getSession().setAttribute("email", email);
      response.sendRedirect("admission.html");
      
               // Create an instance of EmailService with your Gmail username and password
            SendEmail emailService = new SendEmail("webtech24241@gmail.com", "zjzfbdsftincfevd");

            // Send the confirmation email to the user
            String recipientEmail = (email); // The email address of the user who signed up
            String subject = "Confirmation Email";
            String text = "Thank you for filling the admission form! you are most Welcome!"; // The message you want to send in the email
        try {
            emailService.sendEmail(recipientEmail, subject, text);
        } catch (MessagingException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Message Sent"+emailService);
      
      
    } else {
      response.sendRedirect("Login.html?error=Invalid username or password.");
    }
    session.close();
  }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}