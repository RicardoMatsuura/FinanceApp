import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String name;
    private List<Transaction> transactionList;
    private double balance;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;;
        transactionList = new ArrayList<>();
    }

    public int getId() {
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
        transactionList.add(transaction);
        if(TransactionType.REVENUE.equals(transaction.getTransactionType())) {
            balance += transaction.getValue();
        }
        else if(TransactionType.EXPENSE.equals(transaction.getTransactionType())) {
            balance -= transaction.getValue();
        }
    }

}
