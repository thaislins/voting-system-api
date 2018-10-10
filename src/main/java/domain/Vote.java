package domain;

import java.io.Serializable;

public class Vote implements Serializable {

    private String voterId;
    private String candidateId;
    
    public Vote() {
        
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((voterId == null) ? 0 : voterId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Vote) {
            result = this.voterId == ((Vote) obj).voterId;
        }
        return result;
    }
}
