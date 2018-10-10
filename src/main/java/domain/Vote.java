package domain;

public class Vote {
    
    private String voterId;
    private String candidateId;
   
    public Vote(String voterId, String candidateId) {
        super();
        this.voterId = voterId;
        this.candidateId = candidateId;
    }
    
    public String getVoterId() {
        return voterId;
    }
    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }
    public String getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }
}
