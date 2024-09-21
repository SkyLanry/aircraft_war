package edu.hitsz.GUI;

import edu.hitsz.templatePattern.Game;
import edu.hitsz.application.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AscertainBox extends JDialog{
    private JButton buttonNo;
    private JButton buttonYes;
    private JPanel MainPanel;

    public AscertainBox(int idToDelete) {
        setContentPane(MainPanel);
        setModal(true);
        getRootPane().setDefaultButton(buttonYes);
        buttonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.scoreManager.deleteScore(Game.scoreManager.getAllScores(), idToDelete);
                Game.scoreManager.clearFile();
                Main.SCORE_TABLE.refreshTable();

                Game.scoreManager.writeFile();

                dispose();
            }
        });

        MainPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    //public JPanel getOptions(){return new AscertainBox(int idToDelete).MainPanel;}
}
