package service;

import java.util.Map;
import domain.Vote;
import exception.RepeatedVoteException;

public interface VoteInterface {

    Map<String, Long> getVotes();
    
    void postVoter(Vote vote) throws RepeatedVoteException;
}
