package domain;

/**
 * Class that represents a vote data transfer object (DTO)
 */
public class Vote {

    private String voterId;
    private String candidateNumber;

    public Vote() {
        // Default Contructor
    }

    public Vote(String voterId, String candidateNumber) {
        super();
        this.voterId = voterId;
        this.candidateNumber = candidateNumber;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(String candidateNumber) {
        this.candidateNumber = candidateNumber;
    }
}
