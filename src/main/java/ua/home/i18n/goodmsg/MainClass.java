package ua.home.i18n.goodmsg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.home.i18n.goodmsg.impl.SimpleTimeDayDefiner;
import ua.home.i18n.goodmsg.impl.WelcomeMessageProviderImpl;

import java.util.Locale;
import java.util.function.Supplier;

/**
 * @author it100985pev on 13.01.17 17:00.
 */
public class MainClass {

	private static final Logger log = LoggerFactory.getLogger(MainClass.class);

	static Supplier<MainClass> supplier = MainClass::new;

	public static void main(String[] args) throws Exception {
		MainClass mainClass = supplier.get();
		String message = mainClass.getMessage();
		System.out.println(message);
	}

	private final TimeDayDefiner timeDayDefiner;
	private final WelcomeMessageProvider welcomeMessageProvider;

	public MainClass() {
		this (new SimpleTimeDayDefiner(), new WelcomeMessageProviderImpl("welcome-message"));
	}

	MainClass(TimeDayDefiner timeDayDefiner, WelcomeMessageProvider welcomeMessageProvider) {
		this.timeDayDefiner = timeDayDefiner;
		this.welcomeMessageProvider = welcomeMessageProvider;
	}

	public String getMessage() throws Exception {
		try {

			TimeDay timeDay = timeDayDefiner.defineTimeDay(System.currentTimeMillis());
			Locale locale = Locale.getDefault();
			String message = welcomeMessageProvider.getMessage(timeDay, locale);

			log.info("Welcome message for the timeDay = '{}' and locale = '{}': '{}'", timeDay, locale, message);

			return message;

		} catch (Exception e) {
			log.error("Error get welcome message!", e);
			throw e;
		}
	}

}
