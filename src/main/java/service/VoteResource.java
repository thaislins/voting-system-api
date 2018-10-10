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
import exception.RepeatedVoteException;
import persistence.VoteDatabase;

@Stateless
@Path("/votes")
public class VoteResource implements VoteInterface {

    public VoteResource() {
        // Default Constructor
    }

    public Candidate findCandidate(String number) {
        for (Candidate candidate : VoteDatabase.CANDIDATES) {
            if (Integer.parseInt(number) == candidate.getNumber()) {
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
    public void postVoter(Vote vote) throws RepeatedVoteException {
        String candidateId =  vote.getCandidateId();
        Candidate candidate = findCandidate(candidateId);

        if (VoteDatabase.VOTERS.contains(vote)) {
            System.out.println("User already voted");
        } else {
            Long voteCount = VoteDatabase.VOTES.get(candidate.getName());
            VoteDatabase.VOTES.put(candidate.getName(), voteCount + 1);
            VoteDatabase.VOTES.put(candidate.getName(), voteCount + 1);
        }
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Map<String, Long> getVotes() {
        return VoteDatabase.VOTES;
    }
}
