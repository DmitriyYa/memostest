package kz.yakovlev.memos.test.action;

import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageCreate;
import kz.yakovlev.memos.test.page.PageHome;

public class Action_CreateNewEntry {

    public static void createNewEntry(String title, String description,String status){
        PageHome.btn_Plus().click();
        TimingUtils.waitSeconds(1);
        PageCreate.txt_Title().sendKeys(title);
        PageCreate.txt_Descrition().sendKeys(description);
        PageCreate.btn_Status().click();
        TimingUtils.waitSeconds(1);
        PageCreate.btn_Status(status).click();
        TimingUtils.waitSeconds(1);
        PageCreate.btn_Save().click();
    }
}
