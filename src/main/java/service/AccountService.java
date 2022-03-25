package service;

import models.Account;
import repository.AccountRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class AccountService implements Service<Account> {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    AccountRepository accountRepository = new AccountRepository();
    Account account;
    String name;
    int passcode,id;
    java.util.Date date = new java.util.Date();
    String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AccountService() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add() {
        System.out.println("please insert your name");
        name = scanner.next();
        System.out.println("insert your passcode");
        passcode = scanner.nextInt();
         id = random.ints(4, 10, 99).findFirst().getAsInt();
        // LocalDate localDate = new LocaleData();
        long timeMilli = date.getTime();
         Date date1 = new Date(timeMilli);
        account = new Account(id,id,name,date1,passcode);
        try {
            accountRepository.add(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void show() {
        try {
            account = accountRepository.show(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(account);


    }

    @Override
    public void delete() {
        try {
            accountRepository.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("your id is delete");

    }

    @Override
    public void modify(Account account) {

    }
    public boolean isHere(String user,int password) throws SQLException {

        try {
            if (accountRepository.isHere(user, password)){
                userName = user;
                id = getId();
            return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("user not find");

        }
        return false;
    }
    public int getId(){
        try {
         return    id = accountRepository.returnId(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void findUser(){
        int ids=0;
        System.out.println("insert user");
        String user = scanner.next();
        try {
             ids = accountRepository.returnId(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (ids > 0){
            System.out.println("is exists");
        }
        else
            System.out.println("not find");

    }

}