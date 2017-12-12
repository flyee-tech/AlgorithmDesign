package com.peierlong.coursera.algorithms.week2;

/**
 *
 * 实现Comparable接口的示例，该错误示例违反了传递性
 * @author elong
 * @version V1.0
 * @date 2017/12/12
 */
public class Temperature implements Comparable<Temperature>{

    private final double degrees;

    public Temperature(double degrees) {
        if (Double.isNaN(degrees)) {
            throw new IllegalArgumentException();
        }
        this.degrees = degrees;
    }

    @Override
    public int compareTo(Temperature that) {
        double epsilon = 0.1;
        if (this.degrees < that.degrees - epsilon) {
            return -1;
        }
        if (this.degrees > that.degrees + epsilon) {
            return +1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Temperature a = new Temperature(10.16);
        Temperature b = new Temperature(10.08);
        Temperature c = new Temperature(10.00);

        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(c));
        System.out.println(a.compareTo(c));



    }
}
