package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static stream.DishFactory.getMenu;

public class Mapping {
    public static void main(String[] args) {

        // map은 stream의 결과를 새로운 형태로 새로 매핑된다.
        List<Dish> menu = getMenu();

        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());

        // stream 평면화
        List<String> helloWorld = Arrays.asList("Hello", "World");

        // 잘못된 예시
        // 우리는 HelloWorld라는 문자열에서 중복된 요소를 제거하고 싶은건데,
        // stream에서 String 하나하나 즉, 'Hello' 'World'를 각각의 요소로 처리한다.
        // 이러한 문제를 해결하기 위해선 flatMap이 필요하다.
        List<String[]> result = helloWorld.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        for (String[] strings : result) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

        List<String> uniqueCharacters = helloWorld.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        for (String uniqueCharacter : uniqueCharacters) {
            System.out.print(uniqueCharacter + " ");
        }


    }
}
