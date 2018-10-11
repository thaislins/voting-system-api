package domain;

public class Vote {

    private String voterId;
    private String candidateNumber;

    public Vote() {

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
