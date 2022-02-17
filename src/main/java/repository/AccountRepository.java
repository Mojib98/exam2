package repository;

import models.Account;

import java.sql.*;

public class AccountRepository implements Repository<Account> {
    Connection connection = Singleton.getInstance().getConnection();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public AccountRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Account account) throws SQLException {
        String sql = "insert into account( userid, username, passcode, datea) values (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,account.getUserid());
        preparedStatement.setString(2,account.getUserName());
        preparedStatement.setInt(3,account.getPasscode());
        preparedStatement.setDate(4,account.getDate());
        preparedStatement.execute();
    }

    @Override
    public Account show(int userId) throws SQLException {

        String sql = "select * from account where userid = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,userId);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt(1);
        String name=resultSet.getString(3);
        int passcode = resultSet.getInt(4);
        Date date = resultSet.getDate(5);
        return new Account(id,userId,name,date,passcode);
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from account where userid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }

    @Override
    public void modify(Account account) {

    }
    public boolean isHere(String userName,int password) throws SQLException {
        String sql="SELECT  COUNT(*) FROM account WHERE " +
                "username=? AND passcode = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        preparedStatement.setInt(2,password);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getInt(1));
        if(resultSet.getInt(1)==1)
            return true;
        else
            return false;
    }
    public int returnId(String username) throws SQLException {
        String sql = "select userid from account where username=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        resultSet = preparedStatement.executeQuery();
        return resultSet.getInt(1);
    }
}

