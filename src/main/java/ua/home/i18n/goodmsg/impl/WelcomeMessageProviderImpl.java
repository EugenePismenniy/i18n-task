package ua.home.i18n.goodmsg.impl;

import ua.home.i18n.goodmsg.TimeDay;
import ua.home.i18n.goodmsg.WelcomeMessageProvider;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author eugene on 14.01.17.
 */
public class WelcomeMessageProviderImpl implements WelcomeMessageProvider {

    private final String resourcePrefixName;

    public WelcomeMessageProviderImpl(String resourcePrefixName) {
        this.resourcePrefixName = resourcePrefixName;
    }

    @Override
    public String getMessage(TimeDay timeDay, Locale locale) {
        ResourceBundle resource = ResourceBundle.getBundle(this.resourcePrefixName, locale);
        String message = resource.getString(timeDay.name());
        return convertMessage(message);
    }

    private String convertMessage(String sourceMessage) {
        try {
            byte[] bytes = sourceMessage.getBytes("ISO-8859-1");
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error convert the welcome message from 'ISO-8859-1' to 'UTF-8'.", e);
        }
    }
}
