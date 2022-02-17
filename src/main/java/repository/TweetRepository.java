package repository;

import models.Tweet;
import models.TweetandCommnet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TweetRepository implements Repository<Tweet> {
    PreparedStatement preparedStatement;
    Connection connection = Singleton.getInstance().getConnection();


    public TweetRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Tweet tweet) throws SQLException {
        String sql = "insert into tweet ( userid, datet, tweet, idtweet,username) values (?,?,?,?,?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,tweet.getUserid());
        preparedStatement.setDate(2,tweet.getDate());
        preparedStatement.setString(3,tweet.getTwitte());
        preparedStatement.setInt(4,tweet.getIdTwitte());
        preparedStatement.setString(5,tweet.getUserName());
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
     ResultSet   resultSet = preparedStatement.executeQuery();
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
       ResultSet resultSet = preparedStatement.executeQuery();
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
    public List<TweetandCommnet> showTweetAndComment() throws SQLException {
        TweetandCommnet tweetandCommnet;
        List<TweetandCommnet> list = new ArrayList<>();
        String sql = "select tweet.username ,tweet.datet,tweet.tweet, " +
                "c.comment,c.username,c.date1" +
                " from tweet inner join comment c on tweet.idtweet = c.idtweet";
        preparedStatement = connection.prepareStatement(sql);
        //preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String user=resultSet.getString(1);
            Date datet=resultSet.getDate(2);
            String tweet = resultSet.getString(3);
            String comment=resultSet.getString(4);
            String userc=resultSet.getString(5);
            Date datec=resultSet.getDate(6);
            tweetandCommnet = new TweetandCommnet(0,0,user,datet,tweet,0,comment,userc);
            list.add(tweetandCommnet);

        }
        return list;
    }


}
