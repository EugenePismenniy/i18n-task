package ua.home.i18n.goodmsg;

import java.util.Locale;

/**
 * @author it100985pev on 13.01.17 16:36.
 */
public interface WelcomeMessageProvider {
	String getMessage(TimeDay timeDay, Locale locale);
}
