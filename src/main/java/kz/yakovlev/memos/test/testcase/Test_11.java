package kz.yakovlev.memos.test.testcase;

import kz.yakovlev.memos.test.action.Action_LogIn;
import kz.yakovlev.memos.test.action.Action_LogOut;
import kz.yakovlev.memos.test.action.Action_Register;
import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageHome;
import kz.yakovlev.memos.test.page.PageLogIn;
import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Краткое описание:
 * Создание N пользователей.
 * <p>
 * Шаги:
 * 1. Запустить браузер и перейти по ссылке ﻿http://localhost:8080/#!/login
 * 2.Нажать кнопку Register
 * 3. Заполнить поле ﻿User Name данными - SomeUserN, заполнить поле ﻿Password данными - SomeUserN.
 * Нажать кнопку Register
 * 4. Заполнить поле ﻿User Name данными - SomeUserN, заполнить поле ﻿Password данными - SomeUserN.
 * Нажать кнопку Log in
 * 5. Нажать кнопку (в верхнем правом углу) с именем пользователя SomeUserN.
 * Появится выподающий список.
 * Нажать конпку LogOut
 * 6. Повторить шаги 2,3,4 и 5 N раз, с увеличением счетчика N на 1.
 * <p>
 * Проверка:
 * в приложении созданно 1000 пользователей.
 */
public class Test_11 {
    private final int countUsers = Integer.parseInt(GlobalProperties.getParameter(GlobalProperties.COUNT_USERS));

    @Test
    public void createNewUsers() {
        for (int i = 0; i < countUsers; i++) {
            Action_Register.register("SomeUser" + i, "SomeUser" + i);
            TimingUtils.waitSeconds(1);
            assertEquals(true, PageLogIn.btn_LogIn().isDisplayed());
            Action_LogIn.logIn("SomeUser" + i, "SomeUser" + i);
            assertEquals(true, PageHome.btnUser("SomeUser" + i).isDisplayed());
            Action_LogOut.logOut();
            TimingUtils.waitSeconds(1);
        }
    }
}
