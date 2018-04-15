package com.J8.Jcase;

import java.util.*;
/**
 * 方法引用
 */
public class FunctionRefrenceDemo {
    public static void main(String args[]) {
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );

        cars.forEach( Car::collide );

        cars.forEach( Car::repair );

        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );
    }
}

@FunctionalInterface
interface Supplier<T> {
    T get();
}

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}