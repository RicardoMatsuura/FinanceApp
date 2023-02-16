import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Account> arrayAccount = new ArrayList<>();

        Transaction transaction = new Transaction("First Value", 1000.00, TransactionType.REVENUE);
        Transaction transaction2 = new Transaction("Second Value", 500.00, TransactionType.EXPENSE);

        Account ac = new Account("Ricardo Matsuura");

        verifyUniqueId(ac, arrayAccount);
        arrayAccount.add(ac);

        ac.addTransaction(transaction);
        ac.addTransaction(transaction2);
        System.out.println(ac.getName() + " your balance is: " + ac.getBalance());

        Transaction transaction3 = new Transaction("Third Value", 100, TransactionType.EXPENSE);
        ac.addTransaction(transaction3);
        System.out.println(ac.getName() + " your NEW balance is: " + ac.getBalance());

        List<Transaction> transactionList = ac.getTransactionList();
        transactionList.remove(0);
        System.out.println("Printing cloned Transactions");
        transactionList.forEach(System.out::println);

        System.out.println("Printing original Transactions");
        ac.printTransactions();

        Account ac2 = new Account("Caio Melo");
        verifyUniqueId(ac2, arrayAccount);
        arrayAccount.add(ac2);
    }

    public static void verifyUniqueId(Account ac, List<Account> accounts) {
        for (Account account : accounts) {
            if (ac.getId().equals(account.getId())) {
                throw new InputMismatchException("Account ID: " + ac.getId() + " is not unique");
            }
        }
    }
}