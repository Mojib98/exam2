package models;

import java.sql.Date;

public class Tweet extends BaseModel{
    private String twitte;
    private int idTwitte;

    public Tweet(int id, int userid, String userName, Date date, String twitte, int idTwitte) {
        super(id, userid, userName, date);
        this.twitte = twitte;
        this.idTwitte = idTwitte;
    }

    public String getTwitte() {
        return twitte;
    }

    public void setTwitte(String twitte) {
        this.twitte = twitte;
    }

    public int getIdTwitte() {
        return idTwitte;
    }

    public void setIdTwitte(int idTwitte) {
        this.idTwitte = idTwitte;
    }
}
