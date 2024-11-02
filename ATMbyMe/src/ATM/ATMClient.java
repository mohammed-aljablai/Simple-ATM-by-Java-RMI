package ATM;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.Registered;

/*
 * This projects Has done By Mohammed Aljablai
*/
public class ATMClient {
  public static void main(String[] args){
    // connection with server
    try{
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    ATM atm = (ATM) registry.lookup("ATMService");
    
    Scanner in = new Scanner(System.in);
    // enter values
    String name;
    int password;
    System.out.println("Enter Your Name pleas:");
    name = in.nextLine();
    System.out.println("Enter Your Password pleas:");
    password = in.nextInt();
    in.nextLine();
    
    if(atm.login(name, password)){
      System.out.println("Hello "+ name);
      System.out.println("UserName: "+ name);
      System.out.println("password: "+ password);
      System.out.println("Balance: "+ atm.showInfo());
      int chose;
      mainLoop: while (true) {        
        display();
        chose = in.nextInt();
        in.nextLine();
        switch (chose) {
          case 1:
            System.out.println("UserName: "+ name);
            System.out.println("password: "+ password);
            System.out.println("Balance: "+ atm.showInfo());
            break;
          case 2:
            System.out.println("Enter the amount of money to withdraw:");
            boolean done= atm.withdraw(in.nextDouble());
            if(done) System.out.println("Seccuse");
            else System.out.println("not seccuse");
            in.nextLine();
            break;
          case 3:
            System.out.println("Enter the amount of money to deposite:");
            done= atm.deposite(in.nextDouble());
            if(done) System.out.println("Seccuse");
            else System.out.println("not seccuse");
            in.nextLine();
            break;
          case 4:
              break mainLoop;
          default:
            System.err.println("You have enter wrong number.");
        }
      }
    }else{
      System.out.println("Wrong Entery.");
    }
    System.out.println("Goodbuy "+ name);
    }catch(NotBoundException e){
      System.err.println("The NotBoundException error is: "+ e.getMessage());
    } catch (RemoteException ex) {
      System.err.println("The remote error is: "+ ex.getMessage());
    }
  }
  
  public static void display(){
    System.out.println("Enter number please:");
    System.out.println("1- showInfo");
    System.out.println("2- withdraw");
    System.out.println("3- deposite");
    System.out.println("4- Exite");
  }
}
