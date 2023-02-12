public class Transaction {
    private int id;
    private String description;
    private double value;
    private TransactionType transactionType;

    public Transaction(int id, String description, double value, TransactionType transactionType) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.transactionType = transactionType;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }


}
