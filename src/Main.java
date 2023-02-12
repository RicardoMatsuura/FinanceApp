import java.util.List;

public class Main {


    public static void main(String[] args) {

        Transaction transaction = new Transaction(1, "First Value", 1000, TransactionType.REVENUE);
        Transaction transaction2 = new Transaction(1, "First Value", 150, TransactionType.REVENUE);
        Transaction transaction3 = new Transaction(2, "Second Value", 500, TransactionType.EXPENSE);
        List<Transaction> transactionList = List.of(transaction, transaction2, transaction3);
        balanceOfTransactionList(transactionList);

    }

    public static void balanceOfTransactionList(List<Transaction> transactionList) {
        Double revenue = transactionList.stream().filter(transaction -> TransactionType.REVENUE.equals(transaction.getTransactionType())).mapToDouble(Transaction::getValue).sum();
        Double expense = transactionList.stream().filter(transaction -> TransactionType.EXPENSE.equals(transaction.getTransactionType())).mapToDouble(Transaction::getValue).sum();
        double totalValue = 0;
        for (Transaction transaction : transactionList) {
            if (TransactionType.REVENUE.equals(transaction.getTransactionType())) {
                totalValue += transaction.getValue();
            } else if (TransactionType.EXPENSE.equals(transaction.getTransactionType())) {
                totalValue -= transaction.getValue();
            }
        }
        System.out.println(revenue - expense);
        System.out.println("Total Value " + totalValue);
    }
    /*public static void populateTransactionList(int id, String description, double value, TransactionType transactionType) {
        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setDescription(description);
        transaction.setValue(value);
        transaction.setTransactionType(transactionType);
        transactionList.add(transaction);
    }*/
    /*public static void populateTransactionList(Transaction transaction) {

    }*/
}