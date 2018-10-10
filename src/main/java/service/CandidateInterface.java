package service;

import java.util.List;

import domain.Candidate;

public interface CandidateInterface {

    Candidate getCandidate(Integer Number);
    
    List<Candidate> getCandidates();
}
