package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class  BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);
        bankAccount.withdraw(-100);
        bankAccount.withdraw(300);

        assertEquals(100, bankAccount.getBalance());

    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid("a@b.com"));
        assertFalse(BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("@ab.com"));
        assertFalse(BankAccount.isEmailValid("ab.com@"));
        assertFalse(BankAccount.isEmailValid(".ab@com"));
        assertTrue(BankAccount.isEmailValid("a.b@b.com"));
        assertFalse(BankAccount.isEmailValid("a@@b.com"));
        assertFalse(BankAccount.isEmailValid("a@b."));
        assertFalse(BankAccount.isEmailValid("a@b.c"));
        assertTrue(BankAccount.isEmailValid("a@b.cc"));

    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

    @Test
    void isAmountValidTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertFalse(bankAccount.isAmountValid(-100));
        assertFalse(bankAccount.isAmountValid(100.234));
        assertTrue(bankAccount.isAmountValid(300.26));
        assertTrue(bankAccount.isAmountValid(300));

    }

}