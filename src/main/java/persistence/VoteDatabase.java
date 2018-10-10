package persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.Candidate;

/**
 * Class that represents the database of the program
 */
public class VoteDatabase {

    /**
     * Constant that stores the set of voters
     */
    public static final Set<Long> VOTERS = new HashSet<>();

    /**
     * Constant that stores the list of candidates
     */
    public static final List<Candidate> CANDIDATES;

    /**
     * Constant that stores a map of votes
     */
    public static final Map<Integer, Long> VOTES = new HashMap<>();

    static {
		CANDIDATES = new ArrayList<Candidate>(Arrays.asList(new Candidate(13, "Haddad", "PT", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/fernando-haddad.jpg"),
				new Candidate(17, "Jair Bolsonaro", "PSL", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/jair-bolsonaro.jpg"), 
				new Candidate(45, "Geraldo Alckmin", "PSDB", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/geraldo-alckmin.jpg"),
				new Candidate(18, "Marina Silva", "Rede", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/marina-silva.jpg"), 
				new Candidate(12, "Ciro Gomes", "PDT", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/ciro-gomes.jpg"), 
				new Candidate(19, "Álvaro Dias", "Podemos", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/alvaro-dias.jpg"), 
				new Candidate(30, "João Amoêdo", "Novo", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/joao-amoedo.jpg"),
				new Candidate(50, "Guilherme Boulos", "PSOL", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/guilherme-boulos.jpg"), 
				new Candidate(15, "Henrique Meirelles", "MDB", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/henrique-meirelles.jpg"), 
				new Candidate(16, "Vera Lúcia", "PSTU", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/vera.jpg"),
				new Candidate(54, "João Vicente Goulart", "PPL", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/joao-goulart-filho.jpg"),
				new Candidate(27, "Eymael", "DC", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/eymael.jpg"), 
				new Candidate(51, "Cabo Daciolo", "Patriota", "https://s3.amazonaws.com/gp-info-eleicoes/fotos/brasil/presidente/cabo-daciolo.jpg"),
				new Candidate(null, "NULO", "", ""),
				new Candidate(-1, "BRANCO", "", "")));
		
        for (Candidate candidate : CANDIDATES) {
            VOTES.put(candidate.getNumber(), 0L);
        }
    }
}
