
package com.gamespace.views;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Ronish Prajapati
 * LMU ID: 23048584
 * 
 */
public class CustomMessageJOptionPane {
    public static void showCustomMessage(String message, String title, int messageType) {
        UIManager.put("OptionPane.background", new Color(145, 49, 117));
        UIManager.put("Panel.background", new Color(145, 49, 117));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("Button.background", new Color(32,38,46));
        UIManager.put("Button.foreground", Color.WHITE);
        
        JOptionPane.showMessageDialog(null, message, title, messageType);

        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);
        UIManager.put("OptionPane.messageForeground", null);
    }
}
