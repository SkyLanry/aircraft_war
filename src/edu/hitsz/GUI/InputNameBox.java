package edu.hitsz.GUI;

import edu.hitsz.DAO.PlayerScore;
import edu.hitsz.templatePattern.Game;
import edu.hitsz.application.Main;

import javax.swing.*;
import java.awt.event.*;

public class InputNameBox extends JDialog{
    private JTextField textField1;
    private JPanel MainPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel Line1;
    private JLabel Line2;

    public InputNameBox() {

        setSize(Main.BOX_WIDTH, Main.BOX_HEIGHT);
        Line1.setText("您的本局得分为: " + Game.score);
        Line2.setText("请输入玩家昵称以记录得分:");
        setContentPane(MainPanel);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerScore playerScore = new PlayerScore(Game.scoreManager.getNextId(), textField1.getText(), Game.score, Game.time );
                Game.scoreManager.addScore(playerScore);
                Game.scoreManager.clearFile();
                Game.scoreManager.writeFile();
                Main.SCORE_TABLE.refreshTable();
                dispose();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        /**textField1.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
            }
        });**/
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        MainPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    public JPanel getInputname(){return new InputNameBox().MainPanel;}
}
