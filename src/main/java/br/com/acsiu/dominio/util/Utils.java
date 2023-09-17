package br.com.acsiu.dominio.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Utils {

    public static String getMessage(String idMessage) {
        try {
            return ResourceBundle.getBundle("messages").getString(idMessage);
        } catch (MissingResourceException ex) {
            return idMessage;
        }
    }
}
