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
     * Check to ensure that the amount is not negative
     * Confirm that the amount being withdrawn is less then the current balance
     * Subtract the amount from the current balance
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }

    /**
     * The function checks the email address to ensure that both an @ and . are present.
     * Checks to make sure that both the @ and . are not the first or last chars in the string
     * Checks that both the @ and . are not directly next to each other
     * Ensures that the @ and . are not in the last 3 chars of the string
     * Checks to make sure multiple @ symbols are not entered
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
