package exception;

/**
 * Class that represents a checked exception for handling a repeated voter's id
 * during a voting session
 */
public class RepeatedVoteException extends Exception {

    /**
     * Constructor with call to its superclass
     *
     * @param message Message defined for the occurrence of a repeated vote
     * exception
     */
    public RepeatedVoteException(String message) {
        super(message);
    }
}
