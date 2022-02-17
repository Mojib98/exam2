package models;

import java.sql.Date;

public class TweetandCommnet extends Tweet {
    private String commnet;
    private String userIdComment;

    public TweetandCommnet(int id, int userid, String userName, Date date, String twitte, int idTwitte, String commnet, String userIdComment) {
        super(id, userid, userName, date, twitte, idTwitte);
        this.commnet = commnet;
        this.userIdComment = userIdComment;
    }

    @Override
    public String toString() {
        return "TweetandCommnet{" +
                "commnet='" + commnet + '\'' +
                ", userIdComment='" + userIdComment + '\'' +
                "} " + super.toString();
    }
}
