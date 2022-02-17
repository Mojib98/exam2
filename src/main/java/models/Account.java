package models;

import java.sql.Date;

public class Account extends BaseModel{
    private int passcode;
    public Account(int id, int userid, String userName, Date date,int passcode) {
        super(id, userid, userName, date);
        this.passcode = passcode;
    }

    public int getPasscode() {
        return passcode;
    }

    public void setPasscode(int passcode) {
        this.passcode = passcode;
    }


}
