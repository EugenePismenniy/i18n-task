package ua.home.i18n.goodmsg.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.home.i18n.goodmsg.TimeDay;
import ua.home.i18n.goodmsg.TimeDayDefiner;

import java.util.Calendar;

import static ua.home.i18n.goodmsg.TimeDay.*;

/**
 * @author eugene on 14.01.17.
 */
public class SimpleTimeDayDefiner implements TimeDayDefiner {

	private static final Logger log = LoggerFactory.getLogger(SimpleTimeDayDefiner.class);

    @Override
    public TimeDay defineTimeDay(long currentTime) {

        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(currentTime);

        int hour = date.get(Calendar.HOUR_OF_DAY);

		log.debug("currentTime = {}, hour = {}", currentTime, hour);

        if (hour >= 6 && hour < 9) {
            return MORNING;
        }

        if (hour >= 9 && hour < 19) {
            return DAY;
        }

        if (hour >= 19 && hour < 23) {
            return EVENING;
        }

        return NIGHT;
    }
}
