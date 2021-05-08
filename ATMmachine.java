/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmmachine;

import java.util.Scanner;

/** Written by: William Fletcher
 * I am releasing this program as open source, so do whatever you want with it :)
 * 
 */
public class ATMmachine {
    
    static boolean VerifyCardandPin(String card, String pin){
    // in a real use case, this method could connect to a banks server to
    // actually verify a valid card/pin combo and retrieve current balance etc.
    if(card.length() == 16 && (pin.length() == 4 || pin.length() == 6)){
        return true;
        }
    else{
        return true;
                }
    }
    
    static void printer(double amount, double prebalance, double postbalance, int useraction){
        //deposit
        if(useraction == 0){
        System.out.println("Your balance before deposit: $" + prebalance);
        System.out.println("Amount Deposited: " + amount);
        System.out.println("Your balance after deposit: $" + postbalance);
    }
        //withdraw
        else if(useraction == 1){
        System.out.println("Your balance before withdraw: $" + prebalance);
        System.out.println("Amount Withdrawn: $" + amount);
        System.out.println("Your balance after withdraw: $" + postbalance);
        }
        else if(useraction == 2){
        System.out.println("Your current balance is: $"+ prebalance);
        } 
    }
    static String Cardreader(){
    Scanner s = new Scanner(System.in);
    String cardnumber;
    System.out.println("Enter your card number without spaces: ");
    cardnumber = s.next();
    return cardnumber;
    }
    
    static String PinInput(){
    Scanner s1 = new Scanner(System.in);
    String pin;
    System.out.println("Enter your Pin Number:");
    pin = s1.next();
    return pin;
    }
    
    static void Deposit(){
        double balance = Math.random() * 10000;
        System.out.println("Your balance is: $" + balance + ", how much would you like to deposit?");
      double amount;
      Scanner s = new Scanner(System.in);
      amount = s.nextDouble();

          System.out.println("Deposit of $"+ amount+ " was successful.");
          printer(amount, balance, balance + amount, 0);

      }
    static void withdraw(){
     double balance = Math.random() * 10000;
      double amount;
      Scanner s = new Scanner(System.in);
      System.out.println("Your balance is: $" + balance + ", how much would you like to withdraw?");
      amount = s.nextDouble();
      if(balance < amount){
        System.out.println("insufficient balance, please enter a number between 0-"+balance);
        amount = s.nextDouble();
        if(amount > balance)
            amount = balance;
        printer(amount, balance, balance - amount, 1);
      }
      else{
          System.out.println("Withdraw successful");
          printer(amount, balance, balance - amount, 1);
              }
    }
    
    static void checkbalance(){
    double balance = Math.random() * 10000;
    printer(0, balance, balance, 2);
    }
    
    public static void main(String[] args) {
      System.out.println("Starting ATM protocol...");
     boolean temp = true;
      while(temp){
      String cardnumber = Cardreader(); 
     String pin = PinInput();
     boolean cardisvalid = VerifyCardandPin(cardnumber, pin);
     if(cardisvalid == false){
         System.out.println("Card and Pin are Invalid.");
         continue;
     }
     else{
        System.out.println("Card and Pin are valid");
         temp = false;
     }
         }
      System.out.println("Do you wish to deposit[0], withdraw[1], or checkbalance[2]");
      int useraction;
      Scanner s = new Scanner(System.in);
     useraction = s.nextInt();
     switch(useraction){
         case 0:
             Deposit();
             break;
         case 1:
             withdraw();
             break;
         case 2:
             checkbalance();
             break;
         }
     System.out.println("Program restarting, have a nice day! :]");
    }
    
}
