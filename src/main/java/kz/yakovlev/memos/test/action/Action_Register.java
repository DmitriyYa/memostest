package kz.yakovlev.memos.test.action;

import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageHome;
import kz.yakovlev.memos.test.page.PageRegister;


public class Action_Register {

    public static void register(String userName, String userPassword){
        PageHome.MainMenu.btn_Register().click();
        TimingUtils.waitSeconds(1);
        PageRegister.txtBox_UserName().sendKeys(userName);
        PageRegister.txtBox_Password().sendKeys(userPassword);
        PageRegister.btn_Register().click();
    }
}
