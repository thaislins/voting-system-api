package service;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Candidate;
import domain.Vote;
import persistence.VoteDatabase;

@Stateless
@Path("/votes")
public class VoteResource implements VoteInterface {

	public VoteResource() {
		// Default Constructor
	}

	public Candidate findCandidate(Integer number) {
		for (Candidate candidate : VoteDatabase.CANDIDATES) {
			if (number == candidate.getNumber()) {
				return candidate;
			}
		}
		return null;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public void postVote(Vote vote) {
		Integer candidateNumber = null;
		Long voterId = null;
		try {
			candidateNumber = Integer.parseInt(vote.getCandidateNumber());
			voterId = Long.parseLong(vote.getVoterId());
		} catch (NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}
		Long voteCount;

		if (VoteDatabase.VOTERS.contains(voterId)) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		} else {
			if (findCandidate(candidateNumber) == null)
				candidateNumber = null;
			voteCount = VoteDatabase.VOTES.get(candidateNumber);
			synchronized (VoteDatabase.VOTES) {
				VoteDatabase.VOTES.put(candidateNumber, voteCount + 1);
				VoteDatabase.VOTERS.add(voterId);
			}
		}
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Map<String, Long> getVotes() {
		Map<String, Long> votes = new HashMap<>();
		CandidateResource candidateResource = new CandidateResource();
		for (Map.Entry<Integer, Long> candidateVotes : VoteDatabase.VOTES.entrySet()) {
			if (candidateVotes.getKey() != null) {
				Candidate candidate = candidateResource.findCandidate(candidateVotes.getKey());
				if (candidate != null) {
					votes.put(candidate.getName(), candidateVotes.getValue());
				}
			} else {
				votes.put("NULO", candidateVotes.getValue());
			}
		}
		return votes;
	}
}
