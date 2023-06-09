package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static stream.Dish.Type.*;

public class Main {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, MEAT),
                new Dish("beef", false, 700, MEAT),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, OTHER),
                new Dish("rice", true, 350, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH)
        );

        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        System.out.println(threeHighCaloricDishNames);
    }
}
