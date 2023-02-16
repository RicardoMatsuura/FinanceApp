import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UUID;

public class Account {

    private UUID id;
    private String name;
    private List<Transaction> transactionList;
    private double balance;

    public Account(String name) {

        id = UUID.randomUUID();
        this.name = name;
        transactionList = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //exemplo de encapsulamento e imutalibidade para não dar acesso ao original
    public List<Transaction> getTransactionList() {
        return new ArrayList<>(transactionList);
    }

    public void printTransactions() {
        transactionList.forEach(System.out::println);
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {

        verifyUniqueId(transaction);

        transactionList.add(transaction);
        if (TransactionType.REVENUE.equals(transaction.getTransactionType())) {
            balance += transaction.getValue();
        } else if (TransactionType.EXPENSE.equals(transaction.getTransactionType())) {
            balance -= transaction.getValue();
        }

    }

    public void verifyUniqueId(Transaction transaction) {
        for (Transaction transactionAux : transactionList) {
            if (transaction.getId().equals(transactionAux.getId())) {
                throw new InputMismatchException("Transaction ID: " + transaction.getId() + " is not unique");
            }
        }
    }

}
