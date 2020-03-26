package com.Ainur;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputExpression;
        try{
            do{
                System.out.println("Enter expression:");
                inputExpression = scanner.nextLine();
                System.out.print( Calculator.calculate(inputExpression) + "\n");
            } while (true);
        } catch (Exception e){
            System.exit(0);
        }
    }
}

