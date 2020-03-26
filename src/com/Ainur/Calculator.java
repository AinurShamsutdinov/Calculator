package com.Ainur;


import java.util.Arrays;

public class Calculator {
    private static int intNumOne;
    private static int intNumTwo;
    private static char operation;
    private static boolean isRomanNum = false;

    // метод для получения ввода и возврата значения
    public static String calculate(String input) throws Exception {
        int result = 0;
        parse(input);
        if (intNumOne < 1 || intNumTwo > 10 || intNumTwo < 1 || intNumTwo > 10 ){
            throw new Exception();
        }
        switch (operation){
            case '+':
                result = intNumOne + intNumTwo;
                break;
            case '-':
                result = intNumOne - intNumTwo;
                break;
            case '*':
                result = intNumOne * intNumTwo;
                break;
            case '/':
                if (intNumTwo == 0){
                    break;
                } else {
                    result = intNumOne / intNumTwo;
                    break;
                }
            default:
                break;
        }
        if (!isRomanNum){
            return Integer.toString(result);
        } else {
            String roman = intToRoman(result);
            return roman;
        }

    }

    // парсер ввода, разбивает ввод на два числа и операцию между ними,
    // ошибка при вводе римских чисел и арабских чисел одновременно,
    // ошибка при вводе двух знаков операции
    private static void parse(String input) throws Exception {
        input = input.toLowerCase();
        String firstNumber = new String();
        String secondNumber = new String();
        char tempCh;
        int indexOfOper = 0;

        if (input.indexOf('+') > 0){
            indexOfOper = input.indexOf('+');
            operation = '+';
        } else if (input.indexOf('-') > 0){
            indexOfOper = input.indexOf('-');
            operation = '-';
        } else if (input.indexOf('*') > 0){
            indexOfOper = input.indexOf('*');
            operation = '*';
        } else if (input.indexOf('/') > 0){
            indexOfOper = input.indexOf('/');
            operation = '/';
        }

        firstNumber = input.substring(0,indexOfOper);
        secondNumber = input.substring(indexOfOper+1);
        firstNumber = truncString(firstNumber);
        secondNumber = truncString(secondNumber);

        if ( firstNumber.charAt(0) >= '1' && firstNumber.charAt(0) <= '9'){
            try {
                intNumOne =strArabicToInt(firstNumber);
                intNumTwo = strArabicToInt(secondNumber);
            } catch (Exception e){
                throw e;
            }
        } else {
            isRomanNum = true;
            try{
                intNumOne = strRomanToInt(firstNumber);
                intNumTwo = strRomanToInt(secondNumber);
            } catch (Exception e){
                throw e;
            }
        }

    }

    // // конвертация ввода String в форматe римских чисел от I до X в int
    private static int strRomanToInt (String strNum) throws Exception {
        int number = 0;
        switch (strNum){
            case "i":
                number = 1;
                break;
            case "ii":
                number = 2;
                break;
            case "iii":
                number = 3;
                break;
            case "iv":
                number = 4;
                break;
            case "v":
                number = 5;
                break;
            case "vi":
                number = 6;
                break;
            case "vii":
                number = 7;
                break;
            case "viii":
                number = 8;
                break;
            case "ix":
                number = 9;
                break;
            case "x":
                number = 10;
                break;
            default:
                throw new Exception();
        }
        return number;
    }

    // конвертация ввода String в форматe чисел от 1 до 10 в int
    private static int strArabicToInt (String strNum){
        int number;
        try {
            number = Integer. parseInt(strNum);
        }
        catch (NumberFormatException e){
            System.out.println("Exception thrown: " + e);
            throw e;
        }
        return number;
    }

    // конвертация int в римские числа
    private static String intToRoman(int intResult){

        if (intResult == 100){
            return "C";
        }

        if (intResult == 0){
            return "ZERO";
        }

        String romanResult = new String();

        if (intResult < 0){
            romanResult = romanResult.concat("-");
            intResult *= -1;
        }

        int natural = intResult % 10;
        intResult = intResult / 10;
        int decimal = intResult % 10;

        switch (decimal){
            case 1:
                romanResult = romanResult.concat("Х");
                break;
            case 2:
                romanResult = romanResult.concat("XX");
                break;
            case 3:
                romanResult = romanResult.concat("XXX");
                break;
            case 4:
                romanResult = romanResult.concat("XL");
                break;
            case 5:
                romanResult = romanResult.concat("L");
                break;
            case 6:
                romanResult = romanResult.concat("LX");
                break;
            case 7:
                romanResult = romanResult.concat("LXX");
                break;
            case 8:
                romanResult = romanResult.concat("LXXX");
                break;
            case 9:
                romanResult = romanResult.concat("XC");;
                break;
            default:
                break;
        }

        switch (natural){
            case 1:
                romanResult = romanResult.concat("I");
                break;
            case 2:
                romanResult = romanResult.concat("II");
                break;
            case 3:
                romanResult = romanResult.concat("III");
                break;
            case 4:
                romanResult = romanResult.concat("IV");
                break;
            case 5:
                romanResult = romanResult.concat("V");
                break;
            case 6:
                romanResult = romanResult.concat("VI");
                break;
            case 7:
                romanResult = romanResult.concat("VII");
                break;
            case 8:
                romanResult = romanResult.concat("VIII");
                break;
            case 9:
                romanResult = romanResult.concat("IX");;
                break;
            default:
                break;
        }

        return romanResult;
    }

    private static String truncString(String strTrunc){
        String tempStr = new String();

        String [] strArr = strTrunc.split("");

        for(int i = 0; i < strArr.length; i++){
            if (!strArr[i].equals(" ")){
                tempStr = tempStr.concat(strArr[i]);
            }
        }
        return tempStr;
    }
}
