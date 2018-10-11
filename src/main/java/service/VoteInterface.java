package service;

import java.util.Map;

import domain.Vote;

public interface VoteInterface {

	Map<String, Long> getVotes();

	void postVote(Vote vote);
}
