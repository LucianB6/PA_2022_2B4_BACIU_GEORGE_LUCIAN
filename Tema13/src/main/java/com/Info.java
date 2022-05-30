package com;

import details.Message;

import java.text.DateFormatSymbols;
import java.text.DateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {
    private static final Message messageRo = new Message("res/Messages_ro.proprieties");
    private static final Message messageEng = new Message("res/Messages.proprieties");

    public static void info(Locale locale, Message message){
        System.out.println(message.getCountry() + " " + locale.getCountry());
        System.out.println(message.getLanguage() + " " + locale.getLanguage());
        System.out.println(message.getCurrency() + " " + Currency.getInstance(locale));

        var dateFormat = DateFormatSymbols.getInstance(locale);
        System.out.println(message.getWeek() + " ");

        for (int i = 1; i <= 7; i++){
            System.out.println(dateFormat.getWeekdays()[i] + ", ");
        }
        System.out.println(dateFormat.getWeekdays()[7]);
        System.out.println(message.getMonths() + " ");

        for (int i = 0; i <= 11; i++){
            System.out.println(dateFormat.getMonths()[i] + ", ");
        }
        System.out.println(dateFormat.getMonths()[11]);
        System.out.println(message.getToday() + " " + DateFormat.getDateInstance(DateFormat.MEDIUM, locale).format(new Date()));
    }
}
