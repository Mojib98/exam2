package service;

import models.Tweet;
import models.TweetandCommnet;
import repository.TweetRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TweetService implements Service<Tweet> {
    String username;
    Tweet tweet;
    int id;
    java.util.Date date = new java.util.Date();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    TweetRepository tweetRepository = new TweetRepository();

    public TweetService() throws SQLException, ClassNotFoundException {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void add() {
        int idT = random.ints(4, 10000, 99999).findFirst().getAsInt();
        // LocalDate localDate = new LocaleData();
        System.out.println("insert tweet");
        String tweets = scanner.next().trim();
        long timeMilli = date.getTime();
       Date date = new Date(timeMilli);
        tweet = new Tweet(id,id,username,date,tweets,idT);
        try {
            tweetRepository.add(tweet);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void show() {
        try {
            List<Tweet> list = tweetRepository.showUserTweet(id);
            for (Tweet t:list
                 ) {
                System.out.println(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {

    }

    @Override
    public void modify(Tweet tweet) {

    }
    public void findIdByUser(){

    }
    public void showAll(){
        List<Tweet> list =null;
        try {
             list= tweetRepository.showAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tweet t:list
             ) {
            System.out.println(t);
        }

    }
    public void ShowTweetAndCommnet(){
        List<TweetandCommnet> list=null;
        try {
            list=tweetRepository.showTweetAndComment();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (TweetandCommnet t:list
             ) {
            System.out.println(t);

        }
    }
}
