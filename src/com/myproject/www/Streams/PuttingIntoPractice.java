package com.myproject.www.Streams;
/*
 * Выполнено:
 * 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
 * 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
 * 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
 * 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
 * 5. Выяснить, существует ли хоть один трейдер из Милана.
 * 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
 * 7. Какова максимальная сумма среди всех транзакций?
 * 8. Найти транзакцию с минимальной суммой.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("Отсортированный по возрастающей сумме список транзакций за 2011 год: ");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);


        System.out.println("\nСписок неповторяющихся городов, в которых работают трейдеры:");
        transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("\nОтсортированный по именам список трейдеров из Кэмбриджа");
        Stream.of(raoul, mario, alan, brian)
                .filter(o -> o.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("\nВернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке");
        String s = transactions.stream()
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(s);

        System.out.println("\nВыяснить, существует ли хоть один трейдер из Милана.");
        boolean b = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .anyMatch(x -> x.equals("Milan"));
        System.out.println(b ? "Есть" : "Нет");

        System.out.println("Вывод суммы всех транзакций трейдеров из Кембриджа:");
        Optional<Integer> sum = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println("\n" + sum.get());

        System.out.println("\nМаксимальная сумма среди всех транзакций:");
        Optional<Integer> maximum = transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.naturalOrder());
        System.out.println(maximum.get());

        System.out.println("Вывод транзакции с минимальной суммой.");
        Optional<Integer> minimum = transactions.stream()
                .map(Transaction::getValue)
                .min(Comparator.naturalOrder());
        System.out.println(minimum.get());
    }
}
