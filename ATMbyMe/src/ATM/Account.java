package ATM;

/*
 * This projects Has done By Mohammed Aljablai
 * FileName: is a
*/
public class Account {
  private String useName;
  private int pin;
  private double balance;

  public Account(String useName, int pin, double balance) {
    this.useName = useName;
    this.pin = pin;
    this.balance = balance;
  }
  public String getUseName() {
    return useName;
  }
  public void setUseName(String useName) {
    this.useName = useName;
  }
  public int getPin() {
    return pin;
  }
  public void setPin(int pin) {
    this.pin = pin;
  }
  public double getBalance() {
    return balance;
  }
  public void setBalance(double balance) {
    this.balance = balance;
  }
  
  public void withDraw(double balance){
    this.balance-= balance;
  }  
  public void deposit(double balance){
    this.balance+= balance;
  }  
}

