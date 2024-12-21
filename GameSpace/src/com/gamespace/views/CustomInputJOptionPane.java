
package com.gamespace.views;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Ronish Prajapati
 * Lmu Id: 23048584
 */
public class CustomInputJOptionPane {
    public static String showCustomInputDialog(String message, String title) {
        
        UIManager.put("OptionPane.background", new Color(145, 49, 117));
        UIManager.put("Panel.background", new Color(145, 49, 117));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("TextField.background", new Color(255, 255, 255));
        UIManager.put("TextField.foreground", new Color(32, 38, 46));
        UIManager.put("Button.background", new Color(32,38,46));
        UIManager.put("Button.foreground", Color.WHITE);

        String input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);

        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);
        UIManager.put("OptionPane.messageForeground", null);
        UIManager.put("TextField.background", null);
        UIManager.put("TextField.foreground", null);

        return input;
    }
}
