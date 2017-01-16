package ua.home.i18n.goodmsg;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.home.i18n.goodmsg.impl.WelcomeMessageProviderImpl;
import ua.home.i18n.goodmsg.impl.WelcomeMessageProviderImplTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * @author it100985pev on 16.01.17 11:43.
 */
@RunWith(Parameterized.class)
public class MainClassTest {


	static PrintStream defaultOut;
	static Locale defaultLocale;

	@BeforeClass
	public static void saveDefault() {
		defaultOut = System.out;
		defaultLocale = Locale.getDefault();
	}

	@Parameterized.Parameter(0)
	public TimeDay timeDay;
	@Parameterized.Parameter(1)
	public Locale locale;
	@Parameterized.Parameter(2)
	public String expectedMessage;


	@Test
	public void testMain() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));

		Locale.setDefault(locale);

		MainClass.supplier = () -> new MainClass(currentTime -> timeDay, new WelcomeMessageProviderImpl("test-welcome-message"));

		MainClass.main(new String[]{});

		String actualMessage = byteArrayOutputStream.toString();
		assertEquals(expectedMessage + '\n', actualMessage);
	}


	@AfterClass
	public static void restoreDefault() {
		System.setOut(defaultOut);
		Locale.setDefault(defaultLocale);
	}

	@Parameterized.Parameters
	public static Collection<Object[]> getTestParams() {
		return WelcomeMessageProviderImplTest.getTestParams();
	}
}
