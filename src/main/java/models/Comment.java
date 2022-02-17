package models;

import java.sql.Date;

public class Comment extends Tweet {
    public int idComment;

    public Comment(int id, int userid, String userName, Date date, String twitte, int idTwitte, int idComment) {
        super(id, userid, userName, date, twitte, idTwitte);
        this.idComment = idComment;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                "} " + super.toString();
    }
}
