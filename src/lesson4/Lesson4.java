package lesson4;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.sin;

public class Lesson4 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Stream<Integer> generate1 = Stream.generate(() -> atomicInteger.incrementAndGet())
                .limit(100_000_000);
        Stream<Integer> generate2 = Stream.generate(() -> atomicInteger.incrementAndGet())
                .limit(100_000_000);

        long start1 = System.currentTimeMillis();
        Double collect = generate1
                .parallel()
                .map(e -> sin(e))
                .reduce((e, k) -> e + k).orElse(0.0);
        long stop1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        Double collect2 = generate2
                .map(e -> sin(e))
                .reduce((e, k) -> e + k).orElse(0.0);
        long stop2 = System.currentTimeMillis();
        System.out.println("Параллельная обработка: "+Long.toString(stop1 - start1));
        System.out.println("Последовательная обработка: "+Long.toString(stop2 - start2));
    }
}
