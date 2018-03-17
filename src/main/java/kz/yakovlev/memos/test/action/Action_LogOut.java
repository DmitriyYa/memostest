package kz.yakovlev.memos.test.action;

import kz.yakovlev.memos.test.page.PageHome;

public class Action_LogOut {
    public static void logOut(){
        PageHome.btnUser().click();
        PageHome.btn_LogOut().click();
    }
}
