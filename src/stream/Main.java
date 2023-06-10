package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static stream.Dish.Type.*;

/**
 * Collection vs Stream
 * <p>
 * 컬렉션과 스트림의 차이는 데이터를 언제 계산하느냐 차이다.
 * <p>
 * 컬렉션은 모든 요소들이 추가되기전에 계산이 돼야된다. 쉽게 말하면 자료구조가 포함하는 모든 데이터가 저장된 상태이다.
 * <p>
 * 스트림은 요청할때만 요소를 계산한다. 즉 스트림에는 요소를 추가, 제거를 할 수 없다.
 * <p>
 * 비유하자면 Collection은 DVD로 Stream은 인터넷 스트리밍 영상매체로 비유할 수 있다.
 */
public class Main {
    public static void main(String[] args) {
        List<Dish> menu = DishFactory.getMenu();

        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        Stream<String> limit = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3);

        System.out.println(threeHighCaloricDishNames);

        //==================================================================//
        // filtering

        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        // distinct 중복요소 제거
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .distinct()
                .forEach(System.out::println);


    }
}
