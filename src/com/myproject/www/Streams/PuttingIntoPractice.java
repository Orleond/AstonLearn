package com.myproject.www.Streams;
/*
 * Выполнено:
 * 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
 * 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
        Stream.of(raoul.getCity(), mario.getCity(), alan.getCity(), brian.getCity())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}
