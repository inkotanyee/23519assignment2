/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Admission;
import model.Signup;

/**
 *
 * @author SARO PC
 */
public interface ApplyInterface extends Remote {
    
    public boolean RegisterAccount(Admission adm) throws RemoteException;
     public boolean Sign(Signup user) throws RemoteException;
     public boolean LoginUser(String email, String password) throws RemoteException;
    
}
