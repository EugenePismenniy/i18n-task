package ua.home.i18n.goodmsg.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.home.i18n.goodmsg.TimeDay;
import ua.home.i18n.goodmsg.TimeDayDefiner;

import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author it100985pev on 13.01.17 18:05.
 */
@RunWith(Parameterized.class)
public class SimpleTimeDayDefinerTest {

	TimeDayDefiner timeDayDefiner;

	@Parameterized.Parameter(0)
	public TimeDay expectedTimeDay;

	@Parameterized.Parameter(1)
	public Long currentTime;

	@Test
	public void testDefineTimeDay() {
		TimeDay actualTimeDay = timeDayDefiner.defineTimeDay(currentTime);
		assertNotNull(actualTimeDay);
		assertEquals(expectedTimeDay, actualTimeDay);
	}

	@Parameterized.Parameters
	public static Collection<Object[]> getTestParams(){
		return Arrays.asList(
				new Object[] {TimeDay.NIGHT, new GregorianCalendar(2016, 0, 1, 0, 0).getTimeInMillis()},
				new Object[] {TimeDay.NIGHT, new GregorianCalendar(2016, 0, 1, 1, 0).getTimeInMillis()},
				new Object[] {TimeDay.NIGHT, new GregorianCalendar(2016, 0, 1, 2, 0).getTimeInMillis()},
				new Object[] {TimeDay.NIGHT, new GregorianCalendar(2016, 0, 1, 3, 0).getTimeInMillis()},
				new Object[] {TimeDay.NIGHT, new GregorianCalendar(2016, 0, 1, 4, 0).getTimeInMillis()},
				new Object[] {TimeDay.NIGHT, new GregorianCalendar(2016, 0, 1, 5, 59).getTimeInMillis()},
				new Object[] {TimeDay.MORNING, new GregorianCalendar(2016, 0, 1, 6, 0).getTimeInMillis()},
				new Object[] {TimeDay.MORNING, new GregorianCalendar(2016, 0, 1, 7, 0).getTimeInMillis()},
				new Object[] {TimeDay.MORNING, new GregorianCalendar(2016, 0, 1, 8, 59).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 9, 0).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 10, 0).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 11, 0).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 12, 0).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 13, 0).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 14, 0).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 15, 0).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 16, 0).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 17, 0).getTimeInMillis()},
				new Object[] {TimeDay.DAY, new GregorianCalendar(2016, 0, 1, 18, 59).getTimeInMillis()},
				new Object[] {TimeDay.EVENING, new GregorianCalendar(2016, 0, 1, 19, 0).getTimeInMillis()},
				new Object[] {TimeDay.EVENING, new GregorianCalendar(2016, 0, 1, 20, 0).getTimeInMillis()},
				new Object[] {TimeDay.EVENING, new GregorianCalendar(2016, 0, 1, 21, 0).getTimeInMillis()},
				new Object[] {TimeDay.EVENING, new GregorianCalendar(2016, 0, 1, 22, 59).getTimeInMillis()},
				new Object[] {TimeDay.NIGHT, new GregorianCalendar(2016, 0, 1, 23, 0).getTimeInMillis()}
		);
	}

}