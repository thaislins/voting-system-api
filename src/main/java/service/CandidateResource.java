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

/**
 * Resource class that contains requests based on 
 * candidates
 */
@Stateless
@Path("/candidates")
@Produces(MediaType.APPLICATION_JSON)
public class CandidateResource implements CandidateInterface {

    public CandidateResource() {
        // Default constructor
    }

    /**
     * Method that finds iterates through candidates list 
     * and finds a candidate by his number
     *
     * @param number Value that defines the candidate's number
     * @return Candidate
     */
    public Candidate findCandidate(Integer number) {
        for (Candidate candidate : VoteDatabase.CANDIDATES) {
            if (number.equals(candidate.getNumber())) {
                return candidate;
            }
        }
        return null;
    }
    
    /**
     * Method that makes a GET request to get a candidate by
     * his number (using path parameter)
     *
     * @param number Value that defines the candidate's number
     * @return Candidate
     */
    @GET
    @Path("/{number}")
    @Override
    public Candidate getCandidate(@PathParam("number") Integer number) {
        return findCandidate(number);
    }

    /**
     * Method that makes a GET request to get a all 
     * available candidates
     *
     * @return List of candidates
     */
    @GET
    @Path("/")
    @Override
    public List<Candidate> getCandidates() {
        return VoteDatabase.CANDIDATES;
    }
}
