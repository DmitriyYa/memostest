package kz.yakovlev.memos.test.testcase;

import kz.yakovlev.memos.test.action.Action_CreateNewEntry;
import kz.yakovlev.memos.test.action.Action_LogIn;
import kz.yakovlev.memos.test.action.Action_LogOut;
import kz.yakovlev.memos.test.helpers.TimingUtils;
import kz.yakovlev.memos.test.page.PageCreate;
import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Краткое описание:
 * Создание и отображение записи с большим текстом в описании.
 *
 * Шаги:
 * 1. Запустить браузер и перейти по ссылке ﻿http://localhost:8080/#!/login
 2. Заполнить поле ﻿User Name данными - ﻿publisher, заполнить поле ﻿Password данными - ﻿publisher. Нажать кнопку Log in
 3. Нажать на значек "+" в верхнем правом углу.
 4. Заполнить поле ﻿Memo title данными - ﻿ArhivedTitle,
    заполнить поле Description данными -
    ArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescription
    ArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescription
    ArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescription
    ArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescription
    ArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescription
    ArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescription
    ArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescription
    ArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescription
    для поля Status, из выпадающего списка выбрать Arhived Нажать кнопку Save.

 Проверка:
 Запись не создастся. Отобразится сообщение "﻿User with the same name is already exist"
 */
public class Test_9 {
    private final String title="ArhivedTitle";
    private final String description="ArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescriptionArhivedDescription";
    private final String status= GlobalProperties.STATUS_ARCHIVED;
    private final String error="User with the same name is already exist";

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
        Action_CreateNewEntry.createNewEntry(title, description,status);
        TimingUtils.waitSeconds(1);
        assertEquals(error, PageCreate.getTextError());
    }
}
