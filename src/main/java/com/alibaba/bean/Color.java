package com.alibaba.bean;

/**
 * Color
 *
 * @author keying
 * @date 2021/6/28
 */
public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
            "car=" + car +
            '}';
    }
}
