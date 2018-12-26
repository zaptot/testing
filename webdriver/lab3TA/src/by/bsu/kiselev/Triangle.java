package by.bsu.kiselev;


public class Triangle {

    public static boolean exists(int a, int b, int c) {

        return a > Math.abs(b - c) && b > Math.abs(a - c) && c > Math.abs(a - b);
    }
}
