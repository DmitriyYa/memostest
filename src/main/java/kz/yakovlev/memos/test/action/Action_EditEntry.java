package kz.yakovlev.memos.test.action;

import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageCreate;
import kz.yakovlev.memos.test.page.PageHome;

public class Action_EditEntry {
    public static void editEntry(String oldTitle, String newTitle, String newDescription,String newStatus){
        PageHome.btn_Edit(oldTitle).click();
        TimingUtils.waitSeconds(1);
        PageCreate.txt_Title().clear();
        PageCreate.txt_Title().sendKeys(newTitle);
        PageCreate.txt_Descrition().clear();
        PageCreate.txt_Descrition().sendKeys(newDescription);
        PageCreate.btn_Status().click();
        TimingUtils.waitSeconds(1);
        PageCreate.btn_Status(newStatus).click();
        TimingUtils.waitSeconds(1);
        PageCreate.btn_Save().click();
    }
}
