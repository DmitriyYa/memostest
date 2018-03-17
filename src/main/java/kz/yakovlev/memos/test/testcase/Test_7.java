package kz.yakovlev.memos.test.testcase;

import kz.yakovlev.memos.test.action.*;
import kz.yakovlev.memos.test.helpers.GenerateUUID;
import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageHome;
import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

/**
 * Краткое описание:
 * Удаление записи.
 *
 * Шаги:
 1. Запустить браузер и перейти по ссылке ﻿http://localhost:8080/#!/login
 2. Заполнить поле ﻿User Name данными - ﻿publisher,
    заполнить поле ﻿Password данными - ﻿publisher.
    Нажать кнопку Log in
 3. Нажать на значек "+" в верхнем правом углу.
 4. Заполнить поле ﻿Memo title данными - SomeTitle,
    заполнить поле Description данными - SomeDescription,
    для поля Status, из выпадающего списка выбрать actual.
    Нажать кнопку Save.
 5. Нажать на значек в виде мусорного ведра.

 * Проверка:
 * В текущем списке запись удалилась.
 */
public class Test_7 {
    private final String uuid = new GenerateUUID().getUuid();
    private final String title = uuid + ":SomeTitle";
    private final String description = uuid + ":SomeDescription";
    private final String statusActual = GlobalProperties.STATUS_ACTUAL;

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
    public void createNewEntry() throws NoSuchElementException{
        Action_CreateNewEntry.createNewEntry(title, description, statusActual);
        TimingUtils.waitSeconds(1);
        if (!PageHome.chBox_Candidate().isSelected()) {
            PageHome.chBox_Candidate().click();
        }

        Action_DeleteEntry.deleteEntry(title);
        try {
            PageHome.getElementEntry(title);
        }
        catch (NoSuchElementException e){
            e.getMessage();
        }

    }
}
