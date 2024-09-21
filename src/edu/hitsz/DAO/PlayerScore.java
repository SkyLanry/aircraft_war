package edu.hitsz.DAO;

public class PlayerScore {
    private String playername;
    private int score;
    private int time;
    private int ranking;
    public PlayerScore(int ranking, String playername, int score, int time){
        this.ranking = ranking;
        this.playername = playername;
        this.score = score;
        this.time = time;
    }
    public String getPlayername(){return playername;}
    public int getScore(){return score;}
    public int getTime(){return time;}
    public int getRanking(){return ranking;}


}
