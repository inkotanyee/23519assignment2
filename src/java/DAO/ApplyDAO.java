
package DAO;

import model.Admission;
import model.Signup;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApplyDAO {
    
    public boolean RegisterAccount(Admission adm){
       
        Session session = hibernate.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(adm);
        tx.commit();
        session.close();
        return true;
    }
    

   public boolean Sign(Signup user){
        Session session = hibernate.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
        return true;
    }
    
   public boolean LoginUser(String email, String password){
        Session session = hibernate.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Signup so WHERE so.email = :email  AND so.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        Signup stu = (Signup)query.uniqueResult();
        session.getTransaction().commit();
        return stu != null;
}

}



