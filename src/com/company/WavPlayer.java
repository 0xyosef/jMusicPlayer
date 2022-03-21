package com.company;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WavPlayer  extends JFrame {
    JButton btn = new JButton("Play Sound");
    File wavFile;
    URL defaultSound;
    public static Clip clip;
    public static AudioInputStream audioInputStream;

    public WavPlayer(String url) {
        try {
            setSize(300, 100);
            setLocation(400, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            JPanel jp = new JPanel();
            defaultSound = new URL(url);

            jp.add(btn);

            getContentPane().add(jp);
            pack();
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    play();
                }
            });
        } catch (MalformedURLException ex) {
            Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void play() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(defaultSound);

            try {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop(20000);
                clip.start();

            } catch (LineUnavailableException e) {
            }

        } catch (UnsupportedAudioFileException | IOException e) {

        }
    }
    public void stop() {
        clip.stop();
    }


}

