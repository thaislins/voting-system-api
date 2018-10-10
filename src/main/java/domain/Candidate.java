package domain;

public class Candidate {

    private Integer number;
    private String name;
    private String politicalParty;
    private String urlImg;

    public Candidate(Integer number, String name, String politicalParty, String url) {
        super();
        this.number = number;
        this.name = name;
        this.politicalParty = politicalParty;
        this.urlImg = url;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Candidate) {
            result = this.name == ((Candidate) obj).name;
        }
        return result;
    }
}
