package kz.yakovlev.memos.test.testcase;

import kz.yakovlev.memos.test.action.Action_LogIn;
import kz.yakovlev.memos.test.action.Action_LogOut;
import kz.yakovlev.memos.test.action.Action_Register;
import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageHome;
import kz.yakovlev.memos.test.page.PageLogIn;
import org.junit.After;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Краткое описание:
 * Регистрация нового пользователя.
 * <p>
 * Шаги:
 * 1. Запустить браузер и перейти по ссылке ﻿http://localhost:8080/#!/login
 * 2. Нажать кнопку Register
 * 3. Заполнить поле ﻿User Name данными - SomeUser, заполнить поле ﻿Password данными - SomeUser. Нажать кнопку Register
 * 4. Заполнить поле ﻿User Name данными - SomeUser, заполнить поле ﻿Password данными - SomeUser. Нажать кнопку Log in
 */
public class Test_2 {
    @Test
    public void registerUser() {
        Action_Register.register("SomeUser", "SomeUser");
        TimingUtils.waitSeconds(1);
        assertEquals(true, PageLogIn.btn_LogIn().isDisplayed());
        Action_LogIn.logIn("SomeUser", "SomeUser");
        assertEquals(true, PageHome.btnUser("SomeUser").isDisplayed());
    }
    @After
    public void logOut(){
        Action_LogOut.logOut();
        TimingUtils.waitSeconds(1);
    }
}