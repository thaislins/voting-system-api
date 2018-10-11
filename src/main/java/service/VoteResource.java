package service;

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

/**
 * Resource class that contains requests based on votes
 */
@Stateless
@Path("/votes")
public class VoteResource implements VoteInterface {

    public VoteResource() {
        // Default Constructor
    }

    /**
     * Method that finds iterates through candidates list and finds a candidate by
     * his number
     *
     * @param number Value that defines the candidate's number
     * @return Candidate
     */
    public Candidate findCandidate(Integer number) {
        for (Candidate candidate : VoteDatabase.CANDIDATES) {
            if (number == candidate.getNumber()) {
                return candidate;
            }
        }
        return null;
    }

    /**
     * Method that makes a POST request to vote for a specific candidate based on
     * the voter's id
     *
     * @param vote Object that contains voter id and candidate's number
     */
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

    /**
     * Method that makes a GET request to get the votes for each candidate
     *
     * @return Map of votes
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Map<Integer, Long> getVotes() {
        return VoteDatabase.VOTES;
    }
}
