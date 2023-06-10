package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static stream.DishFactory.getMenu;
import static stream.DishFactory.getSpecialMenu;

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
public class StreamSlicing {
    public static void main(String[] args) {
        List<Dish> menu = getMenu();

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

        List<Dish> specialMenu = getSpecialMenu();

        // 320 calories 이하의 음식 일반적인 필터링
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());

        // special menu는 이미 칼로리순으로 정렬이 되있다.
        // takeWhile은 순차적으로 collection을 탐색하면서 해당 조건인 요소들을 취함.
        // 해당조건이 false가 되는순간 stream은 종료됨. 정렬이 중요함.
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println("slicedMenu1 = " + slicedMenu1);

        // dropWhile은 takeWhile과 반대로 순차적으로 collection을 탐색하면서 해당 조건인 요소들을 버림.
        // 이 또한 정렬이 중요함.
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println("slicedMenu2 = " + slicedMenu2);

        // 정리하자면 takeWhile과 dropWhile은 특정기준에 의해 정렬된 collection에 사용하면 적절하다.
        // 정렬되지 않은 collection에 적용하면 예상치 않은 동작을 하게 될 수 있다.

        //==================================================================//
        // limit은 sql에서의 limit과 동일한 기능을 제공한다.
        // skip은 처음 n개의 요소를 건너뛴 stream을 제공한다.
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());

        List<Dish> skipDished = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());


    }
}
