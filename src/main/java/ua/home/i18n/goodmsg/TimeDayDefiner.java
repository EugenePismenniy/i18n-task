package ua.home.i18n.goodmsg;

/**
 * Define the time of day
 *
 * @author it100985pev on 13.01.17 16:38.
 */
public interface TimeDayDefiner {
	/**
	 * @param currentTime current time in milliseconds
	 * */
	TimeDay difineTimeDay(long currentTime);
}
