package ch1.before_improvement;

import ch1.common.Apple;
import ch1.common.AppleGreenColorPredicate;
import ch1.common.AppleHeavyWeightPredicate;
import ch1.common.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

import static ch1.common.Color.*;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple greenApple = new Apple(100, GREEN);
        Apple yellowApple = new Apple(150, YELLOW);
        Apple redApple = new Apple(200, RED);

        inventory.add(greenApple);
        inventory.add(yellowApple);
        inventory.add(redApple);

        List<Apple> result = filterApple(inventory, new AppleHeavyWeightPredicate());
        List<Apple> apples = filterApple(inventory, new AppleGreenColorPredicate());
    }


    public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate predicate) {
        /**
         * strategy pattern을 이용해 유연하게 확장할 수 있지만, method의 인자로 객체만 받을 수 있기에
         * 새로운 기능이 추가될때마다 새로운 class를 생성해야된다.
         * class가 많아지면 관리포인트가 늘어난다.
         * strategy pattern의 전형적인 단점이기도 하다.
         *
         * 객체를 정의하지 않고 새로운 기능을 추가할 수 없을까?
         * 그로인해 생기는 장단점은 무엇일까..
         */
        List<Apple> result = new ArrayList<>();

        for (Apple apple : result) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
