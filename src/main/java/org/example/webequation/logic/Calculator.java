package org.example.webequation.logic;

public class Calculator {

    private final double EPS = 1e-9;

    private MyFunction f;

    public Calculator(MyFunction f) {
        this.f = f;
    }

    public void setF(MyFunction f) {
        this.f = f;
    }

    public boolean hasProbablyRoot(double a, double b) {
        return f.f(a) * f.f(b) < 0;
    }

    public double calcRoot(double a, double b) {
        while (Math.abs(a-b)>EPS) {
            double c = (a+b)/2;
            if (f.f(a)*f.f(c)>0) {
                a = c;
            } else {
                b = c;
            }
        }
        return a;
    }
}
