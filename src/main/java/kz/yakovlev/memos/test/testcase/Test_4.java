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
 * Отображение записей согластно их статуса.
 * <p>
 * Шаги:
 * <p>
 * 1. Запустить браузер и перейти по ссылке ﻿http://localhost:8080/#!/login
 * 2. Заполнить поле ﻿User Name данными - ﻿publisher, заполнить поле ﻿Password данными - ﻿publisher. Нажать кнопку Log in
 * 3. Нажать на значек "+" в верхнем правом углу.
 * 4. Заполнить поле ﻿Memo title данными - ArhivedTitle, заполнить поле Description данными - ArhivedDescription, для поля Status, из выпадающего списка выбрать Arhived Нажать кнопку Save.
 * 5. Нажать на значек "+" в верхнем правом углу.
 * 6. Заполнить поле ﻿Memo title данными - ActualTitle, заполнить поле Description данными - ActualDescription, для поля Status, из выпадающего списка выбрать Actual Нажать кнопку Save.
 * 7. Нажать на значек "+" в верхнем правом углу.
 * 8. Заполнить поле ﻿Memo title данными - CandidateTitle, заполнить поле Description данными - CandidateDescription, для поля Status, из выпадающего списка выбрать Candidatel Нажать кнопку Save.
 * <p>
 * Проверка:
 * при выбранном чек боксе Arhived на странице Memos, появилась запись с текущей датой и заполненными полями.
 * при выбранном чек боксе Actual на странице Memos, появилась запись с текущей датой и заполненными полями.
 * при выбранном чек боксе Candidate на странице Memos, появилась запись с текущей датой и заполненными полями.
 */
public class Test_4 {

    private final String statusActual = GlobalProperties.STATUS_ACTUAL;
    private final String statusArchived = GlobalProperties.STATUS_ARCHIVED;
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
    public void checkStatusActual() {
        final String uuid = new GenerateUUID().getUuid();
        final String title = uuid + ":SomeTitle";
        final String description = uuid + ":SomeDescription";
        Action_CreateNewEntry.createNewEntry(title, description, statusActual);
        TimingUtils.waitSeconds(1);
        if (!PageHome.chBox_Actual().isSelected()) {
            PageHome.chBox_Actual().click();
        }
        assertEquals(GenerateDate.getDateInFormat(), PageHome.getTextEntry(GenerateDate.getDateInFormat()));
        assertEquals(title, PageHome.getTextEntry(title));
        assertEquals(description, PageHome.getTextEntry(description));
        assertEquals("Status is ACTUAL",PageHome.getTextEntry("Status is ACTUAL"));
    }

    @Test
    public void checkStatusArchived() {
        final String uuid = new GenerateUUID().getUuid();
        final String title = uuid + ":SomeTitle";
        final String description = uuid + ":SomeDescription";
        Action_CreateNewEntry.createNewEntry(title, description, statusArchived);
        TimingUtils.waitSeconds(1);
        if (!PageHome.chBox_Archived().isSelected()) {
            PageHome.chBox_Archived().click();
        }
        assertEquals(GenerateDate.getDateInFormat(), PageHome.getTextEntry(GenerateDate.getDateInFormat()));
        assertEquals(title, PageHome.getTextEntry(title));
        assertEquals(description, PageHome.getTextEntry(description));
        assertEquals("Status is ARCHIVED",PageHome.getTextEntry("Status is ARCHIVED"));
    }

    @Test
    public void checkStatusCandidate() {
        final String uuid = new GenerateUUID().getUuid();
        final String title = uuid + ":SomeTitle";
        final String description = uuid + ":SomeDescription";
        Action_CreateNewEntry.createNewEntry(title, description, statusCandidate);
        TimingUtils.waitSeconds(1);
        if (!PageHome.chBox_Candidate().isSelected()) {
            PageHome.chBox_Candidate().click();
        }
        assertEquals(GenerateDate.getDateInFormat(), PageHome.getTextEntry(GenerateDate.getDateInFormat()));
        assertEquals(title, PageHome.getTextEntry(title));
        assertEquals(description, PageHome.getTextEntry(description));
        assertEquals("Status is CANDIDATE",PageHome.getTextEntry("Status is CANDIDATE"));
    }

}
