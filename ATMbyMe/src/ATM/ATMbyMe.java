package ATM;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * This program was programmed by Mohammed Al-jablai
 */
public class ATMbyMe {
  public static void main(String[] args) throws RemoteException {
    ATMImplimante atm = new ATMImplimante();
    
    //  this is the defult link for RMI
    Registry registry = LocateRegistry.createRegistry(1099);
    // whene it calles in client class
    registry.rebind("ATMService", atm);
    System.out.println("ATM Server is ready.");
  }

}
