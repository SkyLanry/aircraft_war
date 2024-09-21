package edu.hitsz.application;

import edu.hitsz.GUI.AscertainBox;
import edu.hitsz.GUI.BeginMenu;
import edu.hitsz.GUI.InputNameBox;
import edu.hitsz.GUI.ScoreTable;
import edu.hitsz.templatePattern.EasyGame;
import edu.hitsz.templatePattern.Game;
import edu.hitsz.templatePattern.HardGame;
import edu.hitsz.templatePattern.NormalGame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * 程序入口
 * @author hitsz
 */
public class Main {

    public static final int WINDOW_WIDTH = 512;
    public static final int WINDOW_HEIGHT = 768;
    public static final int BOX_WIDTH = 250;
    public static final int BOX_HEIGHT = 300;
    public static final CardLayout CARD_LAYOUT = new CardLayout(0, 0);
    public static final JPanel CARD_PANEL = new JPanel(CARD_LAYOUT);
    public static final JFrame FRAME = new JFrame("Aircraft War");
    public static final Object MAIN_LOCK = new Object();
    public static String degree;
    public static ScoreTable SCORE_TABLE;
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) throws IOException {

        System.out.println("Hello Aircraft War");

        // 获得屏幕的分辨率，初始化 Frame
        FRAME.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        FRAME.setResizable(false);
        //设置窗口的大小和位置,居中放置
        FRAME.setBounds(((int) SCREEN_SIZE.getWidth() - WINDOW_WIDTH) / 2, ((int) SCREEN_SIZE.getHeight() - WINDOW_HEIGHT)/2,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 开始界面线程
        BeginMenu beginMenu = new BeginMenu();
        CARD_PANEL.add(beginMenu.getBeginPanel());
        CARD_LAYOUT.next(CARD_PANEL);
        FRAME.add(CARD_PANEL);
        FRAME.setVisible(true);

        /**synchronized (Main.MAIN_LOCK){
            try{
                Main.MAIN_LOCK.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        synchronized (Main.MAIN_LOCK){
            try{
                new MusicThread("src/videos/bgm.wav").start();
                Main.MAIN_LOCK.wait();
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }**/
        //MusicThread.bossBgm = false;
        //MusicThread.bgm = false;

        //FRAME.remove(game);
        //FRAME.dispose();

    }

    public static void startGame(){
        if(Game.DIFFICULTY_MODE == 1){
            Game easyGame = new EasyGame();
            CARD_PANEL.add(easyGame);
            CARD_LAYOUT.next(CARD_PANEL);
            easyGame.action();
        } else if (Game.DIFFICULTY_MODE == 2) {
            Game normalGame = new NormalGame();
            CARD_PANEL.add(normalGame);
            CARD_LAYOUT.next(CARD_PANEL);
            normalGame.action();
        }else {
            Game hardGame = new HardGame();
            CARD_PANEL.add(hardGame);
            CARD_LAYOUT.next(CARD_PANEL);
            hardGame.action();
        }
    }

    public static void displayScore(){

        SCORE_TABLE = new ScoreTable();

        Main.CARD_PANEL.add(SCORE_TABLE.getScoreTable());
        Main.CARD_LAYOUT.next(Main.CARD_PANEL);
        Main.FRAME.add(Main.CARD_PANEL);
        Main.FRAME.setVisible(true);
    }

    public static void InputName(){
        InputNameBox inputNameBox = new InputNameBox();
        inputNameBox.setTitle("Score Check");
        inputNameBox.setBounds(((int) SCREEN_SIZE.getWidth() - BOX_WIDTH) / 2, ((int) SCREEN_SIZE.getHeight() - BOX_HEIGHT)/2,
                BOX_WIDTH, BOX_HEIGHT);
        inputNameBox.setResizable(false);
        inputNameBox.pack();
        inputNameBox.setVisible(true);
    }

    public static void removeAscertain(int idToDelete){
        AscertainBox ascertainBox = new AscertainBox(idToDelete);
        ascertainBox.setTitle("Ascertain");
        ascertainBox.setBounds(((int) SCREEN_SIZE.getWidth() - BOX_WIDTH) / 2, ((int) SCREEN_SIZE.getHeight() - BOX_HEIGHT)/2,
                BOX_WIDTH, BOX_HEIGHT);
        ascertainBox.setResizable(false);
        ascertainBox.pack();
        ascertainBox.setVisible(true);
    }

}
