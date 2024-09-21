package edu.hitsz.GUI;

import edu.hitsz.DAO.PlayerScore;
import edu.hitsz.templatePattern.Game;
import edu.hitsz.application.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ScoreTable {
    private JPanel MainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JScrollPane tableScrollPane;
    private JTable scoreTable;
    private JLabel headerLabel;
    private JButton deleteButton;
    private JLabel gradeLabel;

    public JPanel getScoreTable(){return new ScoreTable().MainPanel;}
    public ScoreTable(){
        gradeLabel.setText("难度:" + BeginMenu.gameDegree);

        String[] columnName = {"Rank", "Player Name", "Score", "time"};
        List<PlayerScore> scoreList = Game.scoreManager.getAllScores();
        //System.out.println("error");
        //System.out.println(scoreList.size());
        String[][] tableData = new String[scoreList.size()][4];

        for (int i = 0; i < scoreList.size(); i++) {
            tableData[i][0] = "" + (i+1);
            tableData[i][1] = "" + scoreList.get(i).getPlayername();
            tableData[i][2] = "" + scoreList.get(i).getScore();
            tableData[i][3] = "" + scoreList.get(i).getTime();
        }
        //表格模型
        DefaultTableModel model = new DefaultTableModel(tableData, columnName){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        //从表格模型那里获取数据
        scoreTable.setModel(model);
        tableScrollPane.setViewportView(scoreTable);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = scoreTable.getSelectedRow();
                if(selectedRow != -1){
                    int idToDelete = Game.scoreManager.getAllScores().get(selectedRow).getTime();
                    Main.removeAscertain(idToDelete);

                }
                else {
                    System.out.println("Index Not Valid");
                }
            }
        });
    }

    public void refreshTable(){
        String[] columnName = {"Rank", "Player Name", "Score", "time"};
        List<PlayerScore> scoreList = Game.scoreManager.getAllScores();
        String[][] tableData = new String[scoreList.size()][4];
        /**for(PlayerScore playerScore : scoreList){
            System.out.println("Score Info: playername: " + playerScore.getPlayername() + ", score: " + playerScore.getScore() + ", time: " + playerScore.getTime() + ", ranking: "
                    + playerScore.getRanking());
        }**/
        for (int i = 0; i < scoreList.size(); i++) {
            //System.out.println(scoreList.get(i).getPlayername());
            tableData[i][0] = "" + (i+1);
            tableData[i][1] = "" + scoreList.get(i).getPlayername();
            tableData[i][2] = "" + scoreList.get(i).getScore();
            tableData[i][3] = "" + scoreList.get(i).getTime();
        }

        DefaultTableModel tableModel = new DefaultTableModel(tableData, columnName) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Main.displayScore();
        scoreTable.setModel(tableModel);
        tableScrollPane.setViewportView(scoreTable);

    }

}
