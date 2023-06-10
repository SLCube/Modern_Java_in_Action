package stream;

import java.util.Arrays;
import java.util.List;

import static stream.Dish.Type.*;
import static stream.Dish.Type.FISH;

public class DishFactory {
    private final static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, MEAT),
            new Dish("beef", false, 700, MEAT),
            new Dish("chicken", false, 400, MEAT),
            new Dish("french fries", true, 530, OTHER),
            new Dish("rice", true, 350, OTHER),
            new Dish("pizza", true, 550, OTHER),
            new Dish("prawns", false, 300, FISH),
            new Dish("salmon", false, 450, FISH)
    );

    private final static List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, OTHER),
            new Dish("prawns", false, 300, FISH),
            new Dish("rice", true, 350, OTHER),
            new Dish("chicken", false, 400, MEAT),
            new Dish("french fries", true, 530, OTHER)
    );

    private DishFactory() {

    }

    public static List<Dish> getMenu() {
        return menu;
    }

    public static List<Dish> getSpecialMenu() {
        return specialMenu;
    }
}
