package lambda.ch1.lambda;

import lambda.ch1.common.Apple;
import lambda.ch1.common.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

import static lambda.ch1.common.Color.RED;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();

        return result;
    }
}
