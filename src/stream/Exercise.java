package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static stream.TransactionFactory.getTransactions;

public class Exercise {
    public static void main(String[] args) {
        List<Transaction> transactions = getTransactions();

        // Quiz 1
        List<Transaction> collect = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .toList();

        System.out.println("collect = " + collect);

        // Quiz 2
        List<String> cities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .toList();
        System.out.println("cities = " + cities);

        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();

        // Quiz 3
        List<Trader> names = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .toList();

        System.out.println("names = " + names);

        // Quiz 4
        List<String> names2 = transactions.stream()
                .map(Transaction::getTrader)
                .sorted(comparing(Trader::getName))
                .map(Trader::getName)
                .distinct()
                .toList();

        System.out.println("names2 = " + names2);

        // Quiz 5
        List<Trader> milanTraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Milan".equals(trader.getCity()))
                .distinct()
                .toList();

        System.out.println("milanTraders = " + milanTraders);

        // Quiz 6
        List<Integer> cambridgeTransactions = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .toList();

        System.out.println("cambridgeTransactions = " + cambridgeTransactions);

        // Quiz 7
        Optional<Integer> maxTransactionValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Math::max);

        System.out.println("maxTransactionValue.get() = " + maxTransactionValue.get());

        // Quiz 8
        Optional<Integer> minTransactionValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Math::min);

        System.out.println("minTransactionValue.get() = " + minTransactionValue.get());
    }
}

class TransactionFactory {
    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("Mario", "Milan");
    private static Trader alan = new Trader("Alan", "Cambridge");
    private static Trader brian = new Trader("Brian", "Cambridge");

    private TransactionFactory() {
    }

    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static List<Transaction> getTransactions() {
        return transactions;
    }
}
