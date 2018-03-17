package kz.yakovlev.memos.test.action;

import kz.yakovlev.memos.test.page.PageLogIn;

public class Action_LogIn {

    public static void logIn(String user, String password) {
        PageLogIn.txtBox_UserName().sendKeys(user);
        PageLogIn.txtBox_Password().sendKeys(password);
        PageLogIn.btn_LogIn().click();
    }
}
