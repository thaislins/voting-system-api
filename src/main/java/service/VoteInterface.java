package service;

import java.util.Map;
import domain.Vote;

/**
 * Interface that contains method signatures of vote resource
 */
public interface VoteInterface {

    /**
     * Method that makes a POST request to vote for a specific candidate based on
     * the voter's id
     *
     * @param vote Object that contains voter id and candidate's number
     */
    void postVote(Vote vote);

    /**
     * Method that makes a GET request to get the votes for each candidate
     *
     * @return Map of votes
     */
    Map<Integer, Long> getVotes();
}
