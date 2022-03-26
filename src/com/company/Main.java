package com.company;

import javax.swing.*;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new SwingAudioPlayer().setVisible(true);
            }
        });
    }
}
