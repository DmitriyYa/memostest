package kz.yakovlev.memos.test.action;

import kz.yakovlev.memos.test.page.PageHome;

public class Action_DeleteEntry {

    public static void deleteEntry(String title){
        PageHome.btn_Bucket(title).click();
    }
}
