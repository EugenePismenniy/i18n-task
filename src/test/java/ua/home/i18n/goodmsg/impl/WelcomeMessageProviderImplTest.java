package ua.home.i18n.goodmsg.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.home.i18n.goodmsg.TimeDay;
import ua.home.i18n.goodmsg.WelcomeMessageProvider;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static org.junit.Assert.*;
import static ua.home.i18n.goodmsg.TimeDay.*;

/**
 * @author eugene on 14.01.17.
 */
@RunWith(Parameterized.class)
public class WelcomeMessageProviderImplTest {

    WelcomeMessageProvider messageProvider = new WelcomeMessageProviderImpl("test-welcome-message");

    @Parameterized.Parameter(0)
    public TimeDay timeDay;
    @Parameterized.Parameter(1)
    public Locale locale;
    @Parameterized.Parameter(2)
    public String expectedMessage;


    @Test
    public void testGetMessage() {
        String actualMessage = messageProvider.getMessage(timeDay, locale);

        assertNotNull(actualMessage);
        assertEquals(expectedMessage, actualMessage);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestParams() {

        Locale ru = new Locale("ru");
        Locale en = new Locale("en");

        return Arrays.asList(
                new Object[] {MORNING, ru, "Доброе утро, Мир!"},
                new Object[] {DAY, ru, "Добрый день, Мир!"},
                new Object[] {EVENING, ru, "Добрый вечер, Мир!"},
                new Object[] {NIGHT, ru, "Доброй ночи, Мир!"}
                ,
                new Object[] {MORNING, en, "Good morning, World!"},
                new Object[] {DAY, en, "Good day, World!"},
                new Object[] {EVENING, en, "Good evening, World!"},
                new Object[] {NIGHT, en, "Good night, World!"}
        );
    }

}
