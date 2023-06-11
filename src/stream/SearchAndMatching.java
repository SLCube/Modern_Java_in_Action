package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchAndMatching {
    public static void main(String[] args) {

        List<Dish> menu = DishFactory.getMenu();

        // anyMatch stream 요소중 적어도 하나
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        // allMatch stream 요소중 모두 다
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("isHealthy = " + isHealthy);

        // noneMatch allMatch와 반대되는 연산, 모두다 일치하지 않음.
        boolean isHealthy2 = menu.stream()
                .noneMatch(dish -> dish.getCalories() > 1000);
        System.out.println("isHealthy2 = " + isHealthy2);

        // anyMatch, allMatch, noneMatch는 Java의 && || 연산을 한다. (쇼트서킷, 남은연산이 있지만 불필요하다 판단될 경우 스킵한다.)

        /**
         * findAny와 findFirst는 병렬실행시에 첫번째 요소를 찾기 어렵기 때문에, 꼭 첫번째 요소가 필요하다면 findFirst를
         * 그게 아니라면 findAny가 병렬 스트림에선 유리하다.
         */
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = numbers.stream()
                .map(number -> number * number)
                .filter(number -> number % 3 == 0)
                .findFirst();

    }
}
