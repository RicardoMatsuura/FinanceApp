import java.util.InputMismatchException;
import java.util.UUID;

public class Transaction {

    private UUID id;
    private String description;
    private double value;
    private TransactionType transactionType;


    public Transaction(String description, double value, TransactionType transactionType) {

        if (value <= 0) {
            throw new InputMismatchException("The value must be higher than 0");
        }
        if (transactionType == null) {
            throw new InputMismatchException("The transaction type cannot be null");
        }

        id = UUID.randomUUID();
        this.description = description;
        this.value = value;
        this.transactionType = transactionType;


    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }


}
