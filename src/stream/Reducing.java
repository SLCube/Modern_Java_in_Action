package stream;

import java.util.Arrays;
import java.util.List;

/**
 * reducing이란?
 * <p>
 * 스트림요소에서 조금 더 복잡한 질의를 표현하는 방법이다.
 * <p>
 * 예를들면 메뉴에서 칼로리가 가장 높은 요리는? 혹은 모든 메뉴의 칼로리 합을 구하시오 등등이다.
 */
public class Reducing {
    public static void main(String[] args) {

        // 기초적인 for-each를 이용한 summation이다.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        // reduce를 이용한 summation이다.
        Integer reduceSum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("sum = " + sum);
        System.out.println("reduceSum = " + reduceSum);

        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b).intValue();

        System.out.println("product = " + product);

        // Quiz 5-3
        List<Dish> menu = DishFactory.getMenu();
        Integer menuCount = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println("menuCount = " + menuCount);

        int summationOfCalories = menu.stream()
                .map(dish -> dish.getCalories())
                .reduce(Integer::sum)
                .get().intValue();
        System.out.println("summationOfCalories = " + summationOfCalories);


    }
}
