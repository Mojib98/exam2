import service.AccountService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccountService accountService = new AccountService();
      //  accountService.add();
      //  accountService.setId(30);
    //    accountService.show();
     //   boolean
//        System.out.println(is);
        menu menu = new menu();
        menu.menuStart();
    }
}
