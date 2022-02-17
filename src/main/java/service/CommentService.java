package service;

import models.Comment;
import repository.CommentRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class CommentService implements Service<Comment> {
    int idTweet;
    int idUser;
    String userName;
    Comment comment;
    java.util.Date date = new java.util.Date();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    CommentRepository  commentRepository = new CommentRepository();

    public CommentService() throws SQLException, ClassNotFoundException {
    }

    public void setIdTweet(int idTweet) {
        this.idTweet = idTweet;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void add() {
      int  idComment = random.ints(4, 20000, 30000).findFirst().getAsInt();
        // LocalDate localDate = new LocaleData();
        System.out.println("please insert id tweet");
        int tweetId = scanner.nextInt();
        System.out.println("Insert comment");
        String commnetT=scanner.next().trim();
        long timeMilli = date.getTime();
        Date date1 = new Date(timeMilli);
        comment = new Comment(idComment,idUser,userName,date1,commnetT,tweetId,idComment);
        try {
            commentRepository.add(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void show() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void modify(Comment comment) {

    }
}
