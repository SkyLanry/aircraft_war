package edu.hitsz.DAO;

import java.util.List;

public interface PlayerScoreDao {
    /**
     * get all stored scores
     * @return
     */
    List<PlayerScore> getAllScores();

    /**
     *Insert a score
     * @param playerScore
     */
    void addScore(PlayerScore playerScore);

    /**
     * delete a score by playername
     * @param playerScores
     * @param playername
     */
    void deleteScore(List<PlayerScore> playerScores, int time);

    /**
     * output all the socres
     */
    void outputAllScores();

    /**
     * find score by its name
     */
    void findScoreByNmae(String playername);

}
