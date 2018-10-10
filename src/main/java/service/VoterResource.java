package service;

import java.util.Set;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import persistence.VoteDatabase;

@Stateless
@Path("/voter")
public class VoterResource {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Long> getVoters() {
        return VoteDatabase.VOTERS;
    }
}
