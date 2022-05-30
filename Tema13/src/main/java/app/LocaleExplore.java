package app;

import details.Message;

import java.util.Locale;
import java.util.Scanner;

import static com.DisplayLocales.displayLocales;
import static com.Info.info;
import static com.SetLocale.setLocale;

public class LocaleExplore {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Message messageRo = new Message("res/Messages_ro.proprieties");
        Message messageEng = new Message("res/Messages.proprieties");
        while(!"exit".equals(input)){
            if(Locale.getDefault() == Locale.forLanguageTag("ro-RO")) {
                System.out.print(messageRo.getPrompt());
            } else{
                System.out.print(messageEng.getPrompt());
            }
            input = scanner.nextLine();

            if(input.startsWith("info")){
                Message message = null;
                if(Locale.getDefault() == Locale.forLanguageTag("ro-RO")){
                    System.out.print(messageRo.getInfo());
                    message = messageRo;
                } else {
                    System.out.print(messageEng.getInfo());
                    message = messageEng;
                }
                if (input.length() > 4){
                    String locale = input.split(" ")[1];
                    System.out.println(Locale.forLanguageTag(locale));
                    try {
                        info(Locale.forLanguageTag(locale), message);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                } else {
                    try {
                        System.out.println(Locale.getDefault());
                        info(Locale.getDefault(),message);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (input.startsWith("set locale")) {
                String locale = input.split(" ")[2];
                setLocale(locale);
                if(Locale.getDefault() == Locale.forLanguageTag("ro-RO")){
                    System.out.print(messageRo.getLocale());
                } else {
                    System.out.print(messageEng.getLocale());
                }
                    setLocale(locale);
            } else if("display locales".equals(input)){
                if(Locale.getDefault() == Locale.forLanguageTag("ro-RO")){
                    System.out.println(messageRo.getLocales());
                }
                else {
                    System.out.println(messageEng.getLocales());
                }
                displayLocales();
            } else {
                if(Locale.getDefault() == Locale.forLanguageTag("ro-RO")){
                    System.out.println(messageRo.getInvalid());
                } else{
                    System.out.println(messageEng.getInvalid());
                }
                if(Locale.getDefault() == Locale.forLanguageTag("ro-RO")) {
                    System.out.println("Salut");
                }
                else {
                    System.out.println("Bye");
                }
            }
        }
    }
}
