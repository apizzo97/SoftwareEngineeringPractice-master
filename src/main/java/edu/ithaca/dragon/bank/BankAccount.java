package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }

    /**
     * The if statement is checking if the @ symbol is present within the string
     */
    public static boolean isEmailValid(String email){
        if ((email.indexOf('@') == -1 || (email.indexOf('@') == 0) || (email.indexOf('.') == -1))) {
            return false;
        }
        else if ((email.indexOf('@') == email.length() - 1) || (email.indexOf('@') == email.length() - 2) || email.indexOf('@') == email.length() - 3) {
            return false;
        }
        else if ((email.indexOf('.') == 0) || (email.indexOf('.') == email.length() - 1) || (email.indexOf('.') == email.length() - 2)) {
            return false;
        }
        else if ((email.indexOf('@')) + 1 == (email.indexOf('.'))) {
            return false;
        }
        else {
            String emailSub = email.substring(email.indexOf('@') + 1, email.length() - 1);
            if ((emailSub.indexOf('@') == -1)) {
                return true;
            }
            else {
                return false;
        }

        }
    }
}
