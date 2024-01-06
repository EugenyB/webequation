package org.example.webequation.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.example.webequation.logic.Calculator;

import java.io.Serializable;

@Named
@SessionScoped
@Getter @Setter
public class FormulaBean implements Serializable {
    private String formula = "";
    private double a;
    private double b;

    private String result = "";

    public String calculate() {
        Expression e = new ExpressionBuilder(formula).variable("x").build();
        Calculator calculator = new Calculator(x -> e.setVariable("x", x).evaluate());
        if (calculator.hasProbablyRoot(a,b)) {
            double x = calculator.calcRoot(a,b);
            result = String.format("x = %11.9f\n", x);
        } else {
            result = "It's probably no root";
        }
        return "result";
    }
}
