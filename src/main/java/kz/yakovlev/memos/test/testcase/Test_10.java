package kz.yakovlev.memos.test.testcase;

import kz.yakovlev.memos.test.action.Action_CreateNewEntry;
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
 * <p>
 * Создание N записей, одним пользователем.
 * Шаги:
 * 1. Запустить браузер и перейти по ссылке ﻿http://localhost:8080/#!/login
 * 2. Заполнить поле ﻿User Name данными - ﻿publisher, заполнить поле ﻿Password данными - ﻿publisher. Нажать кнопку Log in
 * 3. Нажать на значек "+" в верхнем правом углу.
 * 4. Заполнить поле ﻿Memo title данными - SomeTitleN, заполнить поле Description данными - SomeDescriptionN,
 *    для поля Status, из выпадающего списка выбрать actual.
 *    Нажать кнопку Save.
 * 5. Повторить шаги 3 и 4 N раз, с увеличением счетчика N на 1.
 */
public class Test_10 {

    private final String uuid = new GenerateUUID().getUuid();
    private final String title = uuid + ":SomeTitle";
    private final String description = uuid + ":SomeDescription";
    private final String status = GlobalProperties.STATUS_ACTUAL;
    private final int countEntrys = Integer.parseInt(GlobalProperties.getParameter(GlobalProperties.COUNT_ENTRY));

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
        for (int i = 0; i < countEntrys; i++) {
            Action_CreateNewEntry.createNewEntry(title+i, description+i, status);
            TimingUtils.waitSeconds(1);
            if (!PageHome.chBox_Actual().isSelected()) {
                PageHome.chBox_Actual().click();
            }
            assertEquals(GenerateDate.getDateInFormat(), PageHome.getTextEntry(GenerateDate.getDateInFormat()));
            assertEquals(title+i, PageHome.getTextEntry(title+i));
            assertEquals(description+i, PageHome.getTextEntry(description+i));
        }

    }
}
