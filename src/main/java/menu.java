import models.Account;
import models.Comment;
import service.AccountService;
import service.CommentService;
import service.TweetService;

import java.sql.SQLException;
import java.util.Scanner;

public class menu {
    Scanner scanner = new Scanner(System.in);
    String user;
    AccountService accountService = new AccountService();
    CommentService commentService;


    public menu() throws SQLException, ClassNotFoundException {
        commentService = new CommentService();
    }

    public void menuStart() throws SQLException, ClassNotFoundException {
        while (true){
            System.out.println("for sing up inset 1 " +
                    "for sing in insert 2");
            int select = scanner.nextInt();
            if (select == 1){
                singUp();
            }
            if (select == 2){
                if (isHere()){
                    account();
                }
            }
        }
    }
    private void account() throws SQLException, ClassNotFoundException {
        boolean isrun=true;
        TweetService tweetService =new TweetService();
        tweetService.setUsername(user);
      //  accountService.getUserName();
        int id = accountService.getId();
        tweetService.setId(id);
        commentService.setIdUser(id);
        commentService.setUserName(user);
        while (isrun){
            System.out.println("for tweet insert 1 \n" +
                    "for add comment insert 2 and select comment \n" +
                    "for see all tweet insert 3 \n" +
                    "for search user insert  \n" +
                    "for see your tweet insert 6\n" +
                    "for see menu of account insert 5 \n" +
                    " for exit insert 7\n");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    tweetService.add();
                    break;
                case 2:
                    tweetService.showAll();
                    commentService.add();
                    break;
                case 3:
                    tweetService.showAll();
                    break;
                case 4:
                    tweetService.ShowTweetAndCommnet();
                    break;
                case 5:
                    accountService.findUser();
                case 6:
                    tweetService.show();
                    break;
                case 7:
                    isrun = false;
                    break;
                default:
                    continue;
            }
        }



    }



    private boolean isHere(){
        try {
        System.out.println("plese insert your user name");
        this.user = scanner.next();
        System.out.println("please insert your passcode");
        int passcode = scanner.nextInt();

           return accountService.isHere(user,passcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return false;

    }
    private void singUp(){
        accountService.add();
    }
}
