
package service;

import DAO.ApplyDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.Admission;
import model.Signup;


public class ApplyService extends UnicastRemoteObject implements ApplyInterface{
    
  public ApplyService() throws RemoteException {
    }

    @Override
    public boolean RegisterAccount(Admission adm) throws RemoteException {
         ApplyDAO dao = new ApplyDAO();
        dao.RegisterAccount(adm);
        return true;
    }

    @Override
    public boolean Sign(Signup user) throws RemoteException {
         ApplyDAO dao = new ApplyDAO();
        dao.Sign(user);
        return true;
    }

    @Override
    public boolean LoginUser(String email, String password) throws RemoteException {
        ApplyDAO dao = new ApplyDAO();
        boolean result = dao.LoginUser(email, password);
        return result;
    }
 
    
    
    
    
    
}
