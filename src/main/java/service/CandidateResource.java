package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Candidate;
import persistence.VoteDatabase;

@Stateless
@Path("/candidates")
@Produces(MediaType.APPLICATION_JSON)
public class CandidateResource implements CandidateInterface {

    public CandidateResource() {
        // Default constructor
    }

    public Candidate findCandidate(Integer number) {
        for (Candidate candidate : VoteDatabase.CANDIDATES) {
            if (number.equals(candidate.getNumber())) {
                return candidate;
            }
        }
        return null;
    }
    
    @GET
    @Path("/{number}")
    @Override
    public Candidate getCandidate(@PathParam("number") Integer number) {
        return findCandidate(number);
    }

    @GET
    @Path("/")
    @Override
    public List<Candidate> getCandidates() {
        return VoteDatabase.CANDIDATES;
    }
}
