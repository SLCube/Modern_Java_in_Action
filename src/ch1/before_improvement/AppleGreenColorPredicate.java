package ch1.before_improvement;

import static ch1.before_improvement.Color.*;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
