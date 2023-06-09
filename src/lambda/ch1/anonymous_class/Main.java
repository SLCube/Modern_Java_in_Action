package lambda.ch1.anonymous_class;

import lambda.ch1.common.Apple;
import lambda.ch1.common.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        List<Apple> apples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                /**
                 * anonymous class를 이용해 class파일을 만들지 않아도 새로운 기능을 추가 할 수 있게 됐지만,
                 * method의 argument를 전달하는 공간이 너무 비대해졌다.
                 *
                 */
                return false;
            }
        });
    }

    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();

        return result;
    }
}
