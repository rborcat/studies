package com.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rborcat on 6/4/2017.
 */
public final class Exercises {

    public static void stringJoin() {
        chapter("8.1");
        String joinExample = String.join("/", "usr", "local", "bin");
        System.out.println(joinExample);

        List<String> anyCollection = Stream.of("ONE", "TWO", "THREE", "FOUR")
                .collect(Collectors.toList());
        System.out.println(anyCollection + " represented as: " + String.join(" + ", anyCollection));
    }

    public static void numberClasses() {
        chapter("8.2");
        Integer anyInteger = 42;
        Double anyDouble = 42.0d;
        Short anyShort = 42;

        System.out.println("(Integer) Hashcode: " + anyInteger.hashCode() +
                " - Bytes: " + anyInteger.BYTES +
                " - Size: " + anyInteger.SIZE
        );

        System.out.println("(Float) Hashcode: " + anyDouble.hashCode() +
                " - Bytes: " + anyDouble.BYTES +
                " - Size: " + anyDouble.SIZE
        );

        System.out.println("(Short) Hashcode: " + anyShort.hashCode() +
                " - Bytes: " + anyShort.BYTES +
                " - Size: " + anyShort.SIZE
        );

        lineBreaker();

        List<Integer> integerList = Stream.of(1, 1, 2, 3, 5)
                .collect(Collectors.toList());
        System.out.println("Operations with the list " + integerList + ":");
        System.out.println("Sum: " + integerList.stream().mapToInt(Integer::intValue).sum() +
                " - Max: " + integerList.stream().mapToInt(Integer::intValue).max().getAsInt() +
                " - Min: " + integerList.stream().mapToInt(Integer::intValue).min().getAsInt());

        lineBreaker();

        System.out.println("Logical and: true && false = " + Boolean.logicalAnd(true, false));
        System.out.println("Logical or: true && false = " + Boolean.logicalOr(true, false));
        System.out.println("Logical xor: true && true = " + Boolean.logicalXor(true, true));

        lineBreaker();

        int anyInt = -234;
        System.out.println("Regular int type: " + anyInt + " -> to UnsignedLong: " + Integer.toUnsignedLong(anyInt));

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE + 1;
        System.out.println("overflow: " + (x + y));
        System.out.println("x compared to y: " + Integer.compare(x, y));
        System.out.println("x compared to y: " + Integer.compareUnsigned(x, y));
        System.out.println("y divided by x: " + y / x);
        System.out.println("y divided by x: " + Integer.divideUnsigned(y, x));
        System.out.println("x+y: " + Integer.toString(x + y));
        System.out.println("x+y: " + Integer.toUnsignedString(x + y));
        System.out.println("parse(\"2147483647\"): " + Integer.parseUnsignedInt("2147483647"));
        System.out.println("parse(\"2147483648\"): " + Integer.parseUnsignedInt("2147483648"));
        //System.out.println("parse(\"-2147483648\"): " + Integer.parseUnsignedInt("-2147483648"));
    }

    public static void newMathematicalFunctions() {
        chapter("8.3");

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        Object z = x * y;

        System.out.println("Max_Value * Max_Value = " + z);

        try {
            Math.multiplyExact(x, y);
        } catch (ArithmeticException e) {
            System.out.println("BOOOM! Exception: " + e.getMessage()); //Java 8 throws integer overflow

            z = Math.multiplyExact((long) x, (long) y);
            System.out.println("Max_Value * Max_Value = " + z);
        }

        lineBreaker();

        System.out.println("10 mod 2 = " + Math.floorMod(10 , 2) );
        System.out.println("11 mod 2 = " + Math.floorMod(11 , 2) );
        System.out.println("-15 mod 2 = " + Math.floorMod(-15 , 2) );
        System.out.println("-16 mod 2 = " + Math.floorMod(-16 , 2) );
        System.out.println("-15 mod -2 = " + Math.floorMod(-15 , -2) );
    }

    public static void collections() {
        chapter("8.4");

        List<Integer> fibonacciList = Stream.of(1, 1, 2, 3, 5)
                .collect(Collectors.toList());

        for (Integer i : fibonacciList) {
            System.out.println(i*2);
        }
        fibonacciList.forEach(i -> System.out.println(i*2));

        lineBreaker();

        List<String> javaDevelopers = Stream.of("Joao", "Lutiano", "CGomes", "Alexandre", "Denis", "Rodrigo")
                .collect(Collectors.toList());
        Predicate<String> jsDevelopers = p -> p.startsWith("CG");
        javaDevelopers.removeIf(jsDevelopers);
        System.out.println(javaDevelopers);

        Comparator<String> sortComparator = (o1, o2) -> o1.compareTo(o2);
        javaDevelopers.sort(sortComparator);
        System.out.println(javaDevelopers);

        //UnaryOperator<String> masterMode = p -> "Master Javeiro " + p;
        //javaDevelopers.replaceAll(masterMode);
        //System.out.println(javaDevelopers);

    }

    public static void workingWithFiles() {
        chapter("8.5");
    }

    public static void annotations() {
        chapter("8.6");
    }

    public static void minorChanges() {
        chapter("8.7");
    }

    private static void lineBreaker() {
        System.out.println("--");
    }

    private static void chapter(String number) {
        System.out.println("\nExercises " + number + ": ");
    }
}