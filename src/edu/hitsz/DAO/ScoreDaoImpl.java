package edu.hitsz.DAO;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ScoreDaoImpl implements PlayerScoreDao{
    private List<PlayerScore> playerScores = new ArrayList<>();
    File file = new File("src/data/score");

    @Override
    public List<PlayerScore> getAllScores(){
        return playerScores;
    }
    @Override
    public void addScore(PlayerScore playerScore){
        playerScores.add(playerScore);
        resortArrayList();
    }
    @Override
    public void deleteScore(List<PlayerScore> playerScores, int time){
        for(PlayerScore playerScore:playerScores){
            if(playerScore.getTime() == time){
                playerScores.remove(playerScore);
                return;
            }
        }
    }
    @Override
    public void outputAllScores(){
        System.out.println("Ranking List:");
        System.out.println("**********************************************************");
        for(PlayerScore playerScore : playerScores){
            System.out.println("Score Info: playername: " + playerScore.getPlayername() + ", score: " + playerScore.getScore() + ", time: " + playerScore.getTime() + ", ranking: "
                    + playerScore.getRanking());
        }
        System.out.println("**********************************************************");
    }
    @Override
    public void findScoreByNmae(String playername){
        for(PlayerScore playerScore:playerScores){
            if(playerScore.getPlayername() == playername){
                System.out.println("Score Info: playername: " + playerScore.getPlayername() + ", score: " + playerScore.getScore() + "time:" + playerScore.getTime() + ", ranking: "
                        + playerScore.getRanking());
                return;
            }
        }
        System.out.println("Cannot find record");
    }

    public void resortArrayList(){
        for(int i=0; i<playerScores.size()-1; i++){
            for(int j=i+1; j<playerScores.size(); j++){
                if(playerScores.get(i).getScore() < playerScores.get(j).getScore()){
                    Collections.swap(playerScores, i, j);

                }
            }
        }
    }

    public void readFile(){
        //playerScores = new ArrayList<PlayerScore>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while((str = br.readLine()) != null){
                String[] strSave = str.split("\\|");
                PlayerScore playerScore = new PlayerScore(parseInt(strSave[0]), strSave[1], parseInt(strSave[2]), parseInt(strSave[3]));
                playerScores.add(playerScore);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void clearFile(){
        try{
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void writeFile(){
        try{
            FileWriter f = new FileWriter(file, true);

            for(PlayerScore playerScore:playerScores){

                String strout = Integer.toString(playerScore.getRanking()) + "|" + playerScore.getPlayername() + "|" + Integer.toString(playerScore.getScore())
                        + "|" + Integer.toString(playerScore.getTime());

                f.write(strout + "\r\n");
            }
            f.flush();
            f.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public int getSize(){
        return playerScores.size();
    }

    public int getNextId(){
        int maxId = 0;
        for(PlayerScore playerScore : playerScores){
            if(maxId < playerScore.getRanking()){
                maxId = playerScore.getRanking();
            }
        }
        return maxId + 1;
    }
}
