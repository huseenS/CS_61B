package labSix;


/* BadTranscationException.java */

/**
 *  Implements an exception that should be thrown for nonexistent accounts.
 **/
@SuppressWarnings("serial")
public class BadTransactionException extends Exception {

  public int amount;  // The invalid amount

  /**
   *  Creates an exception object for negative amount
   **/
  public BadTransactionException(int negative) {
    super("Invalid amount " + negative);

    amount = negative;
  }
}
