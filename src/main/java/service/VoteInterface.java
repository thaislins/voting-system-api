package service;

import java.util.Map;

import javax.ws.rs.core.Response;

import domain.Vote;

public interface VoteInterface {

    Map<Integer, Long> getVotes();
    
    void postVote(Vote vote);
}
