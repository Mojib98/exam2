package repository;

import models.Tweet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TweetRepository implements Repository<Tweet> {
    PreparedStatement preparedStatement;
    Connection connection = Singleton.getInstance().getConnection();
    ResultSet resultSet;

    public TweetRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Tweet tweet) throws SQLException {
        String sql = "insert into tweet ( userid, datet, tweet, idtweet) values (?,?,?,?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,tweet.getUserid());
        preparedStatement.setDate(2,tweet.getDate());
        preparedStatement.setString(3,tweet.getTwitte());
        preparedStatement.setInt(4,tweet.getIdTwitte());
        preparedStatement.executeUpdate();

    }

    @Override
    public Tweet show(int id) throws SQLException {

        return null;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from tweet where idtweet=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void modify(Tweet tweet) {
    }



    public List<Tweet> showUserTweet(int iduser) throws SQLException {
        Tweet tweet;
        List<Tweet> list = new ArrayList<>();
        String sql = "select  * from tweet where userid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,iduser);
        resultSet = preparedStatement.getResultSet();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            //int iduser = resultSet.getInt(2);
            Date date = resultSet.getDate(4);
            String tweets = resultSet.getString(5);
            int idT=resultSet.getInt(6);
            tweet = new Tweet(id,iduser," ",date,tweets,idT);
           list.add(tweet);
        }
        return list;
    }
    public List<Tweet> showAll() throws SQLException {
        Tweet tweet;
        List<Tweet> list = new ArrayList<>();
        String sql = "select  * from tweet";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.getResultSet();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String userName = resultSet.getString(2);
            int iduser = resultSet.getInt(3);
            Date date = resultSet.getDate(4);
            String tweets = resultSet.getString(5);
            int idT=resultSet.getInt(6);
            tweet = new Tweet(id,iduser,userName,date,tweets,idT);
            list.add(tweet);
        }
        return list;
    }
    public List<Tweet> showTweetWithComment(){
        return null;
    }


}
