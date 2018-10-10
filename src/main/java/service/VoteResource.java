package service;

import java.util.Map;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
        Integer candidateId = Integer.parseInt(vote.getCandidateId());
        Long voterId = Long.parseLong(vote.getVoterId());
        Long voteCount;

        if (VoteDatabase.VOTERS.contains(voterId)) {
            System.out.println("User already voted");
        } else if (findCandidate(candidateId) == null) {
            voteCount = VoteDatabase.VOTES.get(null);
            VoteDatabase.VOTES.put(null, voteCount + 1);
        } else {
            voteCount = VoteDatabase.VOTES.get(candidateId);
            VoteDatabase.VOTES.put(candidateId, voteCount + 1);
        }
        
        VoteDatabase.VOTERS.add(voterId);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Map<Integer, Long> getVotes() {
        return VoteDatabase.VOTES;
    }
}
