package kz.yakovlev.memos.test.testcase;

import kz.yakovlev.memos.test.action.Action_CreateNewEntry;
import kz.yakovlev.memos.test.action.Action_LogIn;
import kz.yakovlev.memos.test.action.Action_LogOut;
import kz.yakovlev.memos.test.helpers.GenerateDate;
import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageHome;
import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Краткое описание:
 * Создание и отбражение записи с пустыми полями.
 *
 * Шаги:
 1. Запустить браузер и перейти по ссылке ﻿http://localhost:8080/#!/login
 2. Заполнить поле ﻿User Name данными - ﻿publisher, заполнить поле ﻿Password данными - ﻿publisher. Нажать кнопку Log in
 3. Нажать на значек "+" в верхнем правом углу.
 4. Не заполняя ни чего, нажать кнопку Save

 * Проверка:
 * Появляется запись с текущей датой и пустыми полями.
 */
public class Test_5 {

    @Before
    public void logIn() {
        Action_LogIn.logIn(GlobalProperties.getParameter(GlobalProperties.PUBLISHER_LOGIN), GlobalProperties.getParameter(GlobalProperties.PUBLOSHER_PASSWORD));
        TimingUtils.waitSeconds(1);
    }

    @After
    public void logOut() {
        Action_LogOut.logOut();
    }

    @Test
    public void createNewEntry() {
        Action_CreateNewEntry.createNewEntry("", "", "");
        TimingUtils.waitSeconds(1);
        if (!PageHome.chBox_Actual().isSelected()) {
            PageHome.chBox_Actual().click();
        }
        assertEquals(GenerateDate.getDateInFormat(), PageHome.getTextEntry(GenerateDate.getDateInFormat()));
        assertEquals("", PageHome.getTextEntry(""));
        assertEquals("", PageHome.getTextEntry(""));
    }
}
