package kz.yakovlev.memos.test.testcase;

import kz.yakovlev.memos.test.action.Action_LogIn;
import kz.yakovlev.memos.test.action.Action_LogOut;
import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageHome;
import kz.yakovlev.memos.test.page.PageLogIn;
import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/**
 * Краткое описание:
 * Вход и выход из системы под существующим пользователем.
 *
 * Шаги:
 1. Запустить браузер и перейти по ссылке ﻿http://localhost:8080/#!/login
 2. Заполнить поле ﻿User Name данными - User, заполнить поле ﻿Password данными - User. Нажать кнопку Log in
 3. Нажать кнопку (в верхнем правом углу) с именем пользователя User. Появится выподающий список. Нажать конпку LogOut
 */

public class Test_1 {

    @Test
    public void logIn(){
        Action_LogIn.logIn(GlobalProperties.getParameter(GlobalProperties.USER_LOGIN),GlobalProperties.getParameter(GlobalProperties.USER_PASSWORD));
        TimingUtils.waitSeconds(1);
        assertEquals(true, PageHome.btnUser(GlobalProperties.getParameter(GlobalProperties.USER_LOGIN)).isDisplayed());
        Action_LogOut.logOut();
        TimingUtils.waitSeconds(1);
        assertEquals(true, PageLogIn.btn_LogIn().isDisplayed());
    }
}
