package kz.yakovlev.memos.test.testcase;

import kz.yakovlev.memos.test.action.Action_CreateNewEntry;
import kz.yakovlev.memos.test.action.Action_EditEntry;
import kz.yakovlev.memos.test.action.Action_LogIn;
import kz.yakovlev.memos.test.action.Action_LogOut;
import kz.yakovlev.memos.test.helpers.GenerateDate;
import kz.yakovlev.memos.test.helpers.GenerateUUID;
import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageHome;
import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Краткое описание:
 * Редактирование созданной записи.

 * Шаги:
 1. Запустить браузер и перейти по ссылке ﻿http://localhost:8080/#!/login
 2. Заполнить поле ﻿User Name данными - ﻿publisher, заполнить поле ﻿Password данными - ﻿publisher. Нажать кнопку Log in
 3. Нажать на значек "+" в верхнем правом углу.
 4. Заполнить поле ﻿Memo title данными - SomeTitle, заполнить поле Description данными - SomeDescription,
    для поля Status, из выпадающего списка выбрать actual.
    Нажать кнопку Save.
 5. Нажать на значек в виде карандаша.
 6. Изменить поле ﻿Memo title данными - AnyTitle, заполнить поле Description данными - AnyDescription,
    для поля Status, из выпадающего списка выбрать actual.
    Нажать кнопку Save.

 * Проверка:
 * при выбранном чек боксе actual на странице Memos, запись отобразится с новыми данными.
 */
public class Test_6
{
    private final String uuid = new GenerateUUID().getUuid();
    private final String title = uuid + ":SomeTitle";
    private final String description = uuid + ":SomeDescription";
    private final String statusActual = GlobalProperties.STATUS_ACTUAL;
    private final String statusCandidate = GlobalProperties.STATUS_CANDIDATE;

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
        Action_CreateNewEntry.createNewEntry(title, description, statusActual);
        TimingUtils.waitSeconds(1);
        if (!PageHome.chBox_Candidate().isSelected()) {
            PageHome.chBox_Candidate().click();
        }

        Action_EditEntry.editEntry(title,"AnyTitle", "AnyDescription",statusCandidate);
        assertEquals(GenerateDate.getDateInFormat(), PageHome.getTextEntry(GenerateDate.getDateInFormat()));
        assertEquals("AnyTitle", PageHome.getTextEntry("AnyTitle"));
        assertEquals("AnyDescription", PageHome.getTextEntry("AnyDescription"));
    }
}
