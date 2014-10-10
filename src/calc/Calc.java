/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.util.Scanner;

/**
 *
 * @author amino_000
 */
public class Calc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj działanie: ");
        String str;
        str = sc.nextLine();
        Expression expr = new Expression(str);
        double result = expr.getResult();
        System.out.println(expr + " = " + result);
    }
    
}
