package edu.hitsz.GUI;

import edu.hitsz.templatePattern.Game;
import edu.hitsz.application.Main;
import edu.hitsz.application.MusicThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeginMenu {
    private JButton easy;
    private JButton normal;
    private JButton hard;
    private JComboBox OpenOrClose;
    private JLabel sound;
    private JPanel BeginPanel;
    public static String gameDegree;

    public JPanel getBeginPanel(){return new BeginMenu().BeginPanel;}

    public BeginMenu() {

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (Main.MAIN_LOCK) {
                    try{
                        gameDegree = "easy";
                        Game.DIFFICULTY_MODE = 1;
                        Main.MAIN_LOCK.notify();
                        Main.startGame();
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            }
        });
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (Main.MAIN_LOCK) {
                    try{
                        gameDegree = "normal";
                        Game.DIFFICULTY_MODE = 2;
                        Main.MAIN_LOCK.notify();
                        Main.startGame();
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }

            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (Main.MAIN_LOCK) {
                    try{
                        gameDegree = "hard";
                        Game.DIFFICULTY_MODE = 3;
                        Main.MAIN_LOCK.notify();
                        Main.startGame();
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }

            }
        });
        OpenOrClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (Main.MAIN_LOCK) {
                    try{
                        if(OpenOrClose.getSelectedItem().equals("open")){
                            MusicThread.open = true;
                        }
                        else{
                            MusicThread.open = false;
                        }
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }

            }
        });
    }

}
