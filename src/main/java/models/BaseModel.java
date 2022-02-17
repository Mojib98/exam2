package models;

import java.sql.Date;

public abstract class  BaseModel {
    private int id,userid;
    private String userName;
    private Date date;

    public BaseModel(int id, int userid, String userName, Date date) {
        this.id = id;
        this.userid = userid;
        this.userName = userName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id=" + id +
                ", userid=" + userid +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
