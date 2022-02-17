package repository;

import models.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepository implements Repository<Comment> {
    PreparedStatement preparedStatement;
    Connection connection = Singleton.getInstance().getConnection();

    public CommentRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Comment comment) throws SQLException {
        String sql ="insert into comment( iduser, username, date1, comment, idtweet, idcomment) values (?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,comment.getUserid());
        preparedStatement.setString(2,comment.getUserName());
        preparedStatement.setDate(3,comment.getDate());
        preparedStatement.setString(4,comment.getTwitte());//its comment
        preparedStatement.setInt(5,comment.getIdTwitte());
        preparedStatement.setInt(6,comment.getIdComment());
        preparedStatement.executeUpdate();

    }

    @Override
    public Comment show(int id) throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void modify(Comment comment) {

    }
    public List<Comment> listComment(int idtweet) throws SQLException {
        Comment comment;
        List<Comment> list = new ArrayList<>();
        String sql = "select * from comment where idtweet=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,idtweet);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            int user =resultSet.getInt(2);
            String username = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            String commentText = resultSet.getString(5);
            int idComment = resultSet.getInt(7);
            comment = new Comment(id,user,username,date,commentText,idtweet,idComment);
            list.add(comment);
        }
        return list;
    }
}
