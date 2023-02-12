import java.util.List;

public class Main {


    public static void main(String[] args) {

        Transaction transaction = new Transaction(1, "First Value", 1000, TransactionType.REVENUE);
        Transaction transaction2 = new Transaction(2, "Second Value", 500, TransactionType.EXPENSE);

        Account ac = new Account(1, "Ricardo Matsuura");
        ac.addTransaction(transaction);
        ac.addTransaction(transaction2);
        System.out.println(ac.getName() + " your balance is: " + ac.getBalance());

        Transaction transaction3 = new Transaction(3, "Third Value", 200, TransactionType.EXPENSE);
        ac.addTransaction(transaction3);
        System.out.println(ac.getName() + " your NEW balance is: " + ac.getBalance());

        List<Transaction> transactionList = ac.getTransactionList();
        transactionList.remove(0);
        System.out.println("Printing cloned Transactions");
        transactionList.forEach(System.out::println);

        System.out.println("Printing original Transactions");
        ac.printTransactions();
    }
}