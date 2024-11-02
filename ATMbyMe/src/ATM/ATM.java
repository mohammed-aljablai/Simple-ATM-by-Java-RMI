/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ATM;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Administrator
 */
public interface ATM extends Remote{
  double showInfo() throws RemoteException;
  boolean withdraw(double balnce) throws RemoteException;
  boolean deposite(double balnce) throws RemoteException;
  boolean login(String name, int pin) throws RemoteException;
}
