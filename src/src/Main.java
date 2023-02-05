import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            ints.add(i);
        };

        Stream<Integer> intStream = ints.stream();
        Comparator<Integer> order = (Integer::compareTo);
        BiConsumer<Integer, Integer> minMaxConsumer = (min, max) -> System.out.println("min " + min + "; max " + max);

        findMinMax(intStream, order, minMaxConsumer);
        evenIntsNumber(ints);
    }

    public static <T> void findMinMax (Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer)
    {
        T maxInt = null;
        T minInt = null;
        List<T> list = stream.sorted(order).distinct().collect(Collectors.toList());
        if (!list.isEmpty()){
            minInt = list.get(0);
            maxInt = list.get(list.size() - 1);
        }
        minMaxConsumer.accept(minInt, maxInt);
    }

    public static void evenIntsNumber (List<Integer> integerList){
        System.out.println("Total even ints in array: " + integerList.stream().filter(i -> i % 2 == 0).count() + ", as follows : " + integerList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));
    }
}