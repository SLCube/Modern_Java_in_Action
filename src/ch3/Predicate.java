package ch3;

/**
 * Functional Interface Annotation이 명시되지 않아도 하나의 method가 인터페이스에 선언되있으면 함수형 인터페이스,
 * 즉 람다식을 사용할 수 있는 상태가 된다.
 * <p>
 * Functional Interface Annotation을 사용하게 된다면, 인터페이스가 함수형 인터페이스라는걸 명시적으로 선언하고,
 * 동료가 실수로 함수형 인터페이스에 새로운 method를 정의하더라도 해당 interface 파일에서 컴파일러가 오류를 잡아준다.
 * <p>
 * Functional Interface Annotation을 사용하지 않은 상태에서 함수형 인터페이스에 새로운 method를 정의하면 사용하는 코드에서
 * 컴파일 에러를 나타낸다.
 * <p>
 * 한가지 예외가 있는데 default method는 정의를 해도 된다.
 * abstract method(즉 interface만 정의하는것이 아니기 때문에, 함수형 인터페이스의 정의를 벗어나지 않는다.)
 */
@FunctionalInterface // 함수형 인터페이스엔 FunctionalInterface를 명시적으로 적어주자
public interface Predicate<T> {
    boolean test(T t);

    default void operation() {
        System.out.println("This is Default operation in Functional Interface.");
    }
}
