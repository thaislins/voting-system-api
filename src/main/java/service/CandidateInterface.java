package service;

import java.util.List;
import domain.Candidate;

/**
 * Interface that contains method signatures of candidate resource
 */
public interface CandidateInterface {

    /**
     * Method that makes a GET request to get a candidate by
     * his number (using path parameter)
     *
     * @param number Value that defines the candidate's number
     * @return Candidate
     */
    Candidate getCandidate(Integer number);

    
    /**
     * Method that makes a GET request to get a all 
     * available candidates
     *
     * @return List of candidates
     */
    List<Candidate> getCandidates();
}
