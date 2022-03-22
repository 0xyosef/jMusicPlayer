package com.company;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WavPlayer  extends JFrame {
    JButton btn ;
    JButton btn2;
    URL defaultSound;
    public static Clip clip;
    public static AudioInputStream audioInputStream;
        JFrame frame;
    public WavPlayer()  {
        btn = new JButton("Play Sound");
        btn2= new JButton("Stop ");
        try {
//        btn.setBounds(45, 100, 120, 50);
//        btn.setBounds(45, 100, 120, 50);
            setSize(300, 100);
            setLocation(400, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            JPanel jp = new JPanel();
            defaultSound = new URL("1.wav");
            jp.add(btn);
            jp.add(btn2);
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
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.stop();
            }
        });

    }
}


