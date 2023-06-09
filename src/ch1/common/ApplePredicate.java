package ch1.common;

import ch1.common.Apple;

/**
 * strategy pattern 이용
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
