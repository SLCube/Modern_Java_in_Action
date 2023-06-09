package lambda.ch3;

import lambda.ch1.common.Apple;

import java.util.ArrayList;
import java.util.List;

import static lambda.ch1.common.Color.GREEN;

public class Main {
    public static void main(String[] args) {
        filter(new ArrayList<>(), (Apple apple) -> GREEN.equals(apple.getColor()));
    }

    public static List<Apple> filter(List<Apple> apples, Predicate<Apple> predicate) {
        return null;
    }
}
