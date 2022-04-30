package boj;

import java.util.stream.*;

public class stream {
    public static void main(String[] args) {
        int numbers[] = {3, 30, 34, 5, 9};

        String answer = IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2)-> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining());

        if(answer.startsWith("0")) System.out.println("0");
        System.out.println("answer = " + answer);

//    Stream.of(numbers).map(String::valueOf).toArray(String::new);
    }

}
