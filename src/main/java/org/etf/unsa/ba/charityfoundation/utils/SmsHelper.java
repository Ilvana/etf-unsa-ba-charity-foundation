package org.etf.unsa.ba.charityfoundation.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsHelper {
    public static final String ACCOUNT_SID = "ACfa5520e29c1528ef1d462675bf4ac65f";
    public static final String AUTH_TOKEN = "79d714ca1ae2a8f26a858d39d22e9d26";
    public static final String SOURCE_NUMBER = "+12052094778";

    public static void sendSms(String destinationNumber, String text) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber("+" + destinationNumber),
                new PhoneNumber(SOURCE_NUMBER),
                text).create();
    }
}
