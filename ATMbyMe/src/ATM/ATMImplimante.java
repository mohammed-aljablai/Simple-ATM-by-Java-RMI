package ATM;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * This projects Has done By Mohammed Aljablai
 * FileName: is a
*/
public class ATMImplimante extends UnicastRemoteObject implements ATM{
  HashMap<String, Account> account;
  Account cuurentaccount;
  
  public ATMImplimante() throws RemoteException{
    account= new HashMap<>();
    account.put("user", new Account("user", 1234, 5000));
    account.put("user", new Account("user2", 1234, 5000));
    account.put("user", new Account("user3", 1234, 5000));
  }

  /*
   * @param name
   * @param pin
   * @return
   * @throws RemoteException
   */
  @Override
  public boolean login(String name, int pin) throws RemoteException{
    boolean is=false;
    Account temp = account.get(name);
    if(temp!=null && temp.getPin()==pin){
      cuurentaccount=account.get(name);
      return !is;
    }
    return is;
  }
  @Override
  public double showInfo() throws RemoteException{
    System.out.println("UserName is: "+ cuurentaccount.getUseName());
    System.out.println("balance is: "+ cuurentaccount.getBalance());
    System.out.println("paswoard is: "+ cuurentaccount.getPin());
    return cuurentaccount.getBalance();
  }
  
  @Override
  public boolean withdraw(double balnce) throws RemoteException{
    cuurentaccount.setBalance(cuurentaccount.getBalance()-balnce);
    return true;
  }
  
  @Override
  public boolean deposite(double balnce) throws RemoteException{
    cuurentaccount.setBalance(cuurentaccount.getBalance()+balnce);
    return true;
  }
  
}
