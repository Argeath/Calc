/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

/**
 *
 * @author amino_000
 */
public class Expression {
    String expr = "";
    double ret = 0;
    
    Expression(String s)
    {
        expr = s.replace(" ", "");
    }
    
    
    // Calc
    // Return:
    // True - if expression is number
    private boolean calc()
    {
        if(expr.contains("+") || expr.contains("-") || expr.contains("*") || expr.contains("/") || expr.contains("^") || expr.contains("(") || expr.contains(")"))
        {
            String x = expr;
            if(x.charAt(0) == '-')
                x = 0 + x;
            while(x.contains("("))
            {
                String[] parts = x.split("\\(", 2);
                String[] p = parts[1].split("\\)", 2);
                Expression xpr = new Expression(p[0]);
                x = parts[0] + xpr.getResult();
                if(p.length > 1)
                    x += p[1];
            }
            
            while(x.contains("+"))
            {
                String[] p = x.split("\\+");
                for(String xpr : p)
                {
                    Expression expression = new Expression(xpr);
                    double result = expression.getResult();
                    ret += result;
                }
                return true;
            }
            
            while(x.contains("-"))
            {
                String[] p = x.split("-");
                int index = 0;
                for(String xpr : p)
                {
                    index++;
                    Expression expression = new Expression(xpr);
                    double result = expression.getResult();
                    if(index == 1)
                        ret = result;
                    else
                        ret -= result;
                }
                return true;
            }
            
            while(x.contains("*"))
            {
                String[] p = x.split("\\*");
                int index = 0;
                for(String xpr : p)
                {
                    index++;
                    Expression expression = new Expression(xpr);
                    double result = expression.getResult();
                    if(index == 1)
                        ret = result;
                    else
                        ret *= result;
                }
                return true;
            }
            
            while(x.contains("/"))
            {
                String[] p = x.split("\\/");
                int index = 0;
                for(String xpr : p)
                {
                    index++;
                    Expression expression = new Expression(xpr);
                    double result = expression.getResult();
                    if(index == 1)
                        ret = result;
                    else
                        ret /= result;
                }
                return true;
            }
            
            while(x.contains("^"))
            {
                String[] p = x.split("\\^");
                int index = 0;
                double number = 0;
                double base = 1;
                for(String xpr : p)
                {
                    index++;
                    Expression expression = new Expression(xpr);
                    double result = expression.getResult();
                    if(index == 1)
                        number = result;
                    else
                        base = result;
                }
                ret = Math.pow(number, base);
                return true;
            }
            
        } else {
            ret = Double.parseDouble(expr);
            return true;
        }
        return false;
    }
    
    
    
    public double getResult()
    {
        this.calc();
        return ret;
    }
    
    @Override 
    public String toString() {
        return expr;
    }
}