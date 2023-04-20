package com.javarefresher.week04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;



class TransactionValueComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction firstTransaction,Transaction secondTransaction) {
       return firstTransaction.getValue().compareTo(secondTransaction.getValue());
    }
}



public class StreamsDemoUsingTraderTransaction {

    public static <T> Consumer<T> print(){
        Consumer<T> printStatement = new Consumer<T>() {
            @Override
            public void accept(T object){
                System.out.println(object);
            }
        };    
        return printStatement;   
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        Predicate<Transaction> hasYear2011 = new Predicate<Transaction>() {
            @Override
            public boolean test(Transaction t)
            {
                return t.getYear() ==2011;
            }
        };

        Function<Transaction, Trader> getTrader = new Function<Transaction,Trader>() {
            @Override
            public Trader apply(Transaction transaction){
                return transaction.getTrader();
            }
        }; 
        Function<Transaction, Trader> getTraderLambda = (transaction) -> transaction.getTrader();
        // Comparator<Transaction>

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );




        /*

        1. Find all transactions in the year 2011 and sort them by value (small to high).
        2. What are all the unique cities where the traders work?
        3. Find all traders from Cambridge and sort them by name.
        4. Return a string of all traders’ names sorted alphabetically.
        6. Print all transactions’ values from the traders living in Cambridge.
        7. What’s the highest value of all the transactions?
        8. Find the transaction with the smallest value

        */

        // 1. Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println("-----------Transactions in 2011-----------");
        transactions
        .stream()
        .filter(hasYear2011)
        .sorted(new TransactionValueComparator())
        .forEach(StreamsDemoUsingTraderTransaction.<Transaction>print());

        // 2. What are all the unique cities where the traders work?

        System.out.println("-----------Unique Cities-----------");
        transactions
        .stream()
        .map(getTrader).collect(Collectors.toSet())
        .stream().map(trader -> trader.getCity()).collect(Collectors.toSet()).forEach(StreamsDemoUsingTraderTransaction.<String>print());
        

        // .collect(Collectors.toSet()).forEach(System.out::println);

        // 3. Find all traders from Cambridge and sort them by name.
        System.out.println("-----------Traders from Cambridge-----------");
        transactions
        .stream()
        .filter((transaction) -> transaction.getTrader().getCity().equals("Cambridge"))
        .map(getTraderLambda)
        .collect(Collectors.toSet())
        .stream()
        .sorted((i1, i2) -> i1.getName().compareTo(i2.getName()))
        .forEach(StreamsDemoUsingTraderTransaction.<Trader>print());

        // 4. Return a string of all traders’ names sorted alphabetically.
        System.out.println("-----------All Trader names -----------");
        String allTraders = transactions
        .stream()
        .map(transaction -> transaction.getTrader().getName())
        .collect(Collectors.toSet())
        .stream()
        .sorted((i1, i2) -> i1.compareTo(i2))
        .collect(Collectors.toList()).toString();
        System.out.println(allTraders);

        // 5. Are any traders based in Milan?
        
        boolean isAnyTraderFromMilan = transactions
        .stream()
        .anyMatch((transaction) -> transaction.getTrader().getCity().equals("Milan"));
        if(isAnyTraderFromMilan == true){
            System.out.println("There are traders form Milan");
        }else{
            System.out.println("There are no traders form Milan");
        }

        // 6. Print all transactions’ values from the traders living in Cambridge.
        System.out.println("----------- All Transaction Values from Cambridge -----------");
        transactions
        .stream()
        .filter((transaction) -> transaction.getTrader().getCity().equals("Cambridge"))
        .map((transaction) -> transaction.getValue())
        .forEach(print());

        // 7. What’s the highest value of all the transactions?
        System.out.println("-----------Maximum Transaction Value -----------");
        Optional<Integer> maxTransactionValue = transactions
        .stream()
        .map((transaction) -> transaction.getValue())
        .reduce(Math::max);
        System.out.println(maxTransactionValue.isPresent()? maxTransactionValue.get():"List is Empty");

        // 8. Find the transaction with the smallest value
        System.out.println("-----------Minimum Transaction Value -----------");
        Optional<Integer> minTransactionValue = transactions
        .stream()
        .map((transaction) -> transaction.getValue())
        .reduce(Math::min);
        System.out.println(minTransactionValue.get());
    }
}


class Transaction {
    private final Trader trader;
    private final int year;
    private final Integer value;
    public Transaction(Trader trader, int year, Integer value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public Integer getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}

class Trader{
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}