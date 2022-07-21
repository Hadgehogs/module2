package lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Homework {

    public static void main(String[] args) {
        //Дан лист
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5, 8, 8, 9);
        Random random = new Random(1);
        Integer result = integers.stream()
                .filter(integer -> integer > 4)
                .distinct()
                .map(integer -> new User(integer))
                .peek(user -> user.setNumberList(random.ints(user.getNumber(), 0, 10).mapToObj(value -> value).collect(Collectors.toList())))
                .flatMap(user -> user.getNumberList().stream())
                .map(integer -> integer * 10)
                .reduce((integer, integer2) -> integer + integer2)
                .orElse(0);
        System.out.println("Результат первой задачи: " + result);
        System.out.println("---------------------");

        System.out.print("Результат второй задачи: ");
        List<List<Integer>> lists = List.of(List.of(1, 2), List.of(3, 4, 5), List.of());
        lists.stream()
                .sorted((element1, element2) -> element2.size()-element1.size())
                .flatMap(integers1 -> integers1.stream())
                .forEach(integer -> System.out.print(integer+","));
        System.out.println("\n---------------------");


        List<List<Integer>> lists2 = List.of(List.of(1, 2), List.of(3, 4, 5), List.of());
        boolean hasListWithSum12 = lists2.stream()
                .anyMatch(integers1 -> integers1.stream().reduce((integer, integer2) -> integer + integer2).orElse(0) == 12);
        System.out.print("Результат третьей задачи: "+hasListWithSum12);
    }
}
