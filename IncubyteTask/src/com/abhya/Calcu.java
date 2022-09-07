package com.abhya;

public class Calcu {

    public static int add(String text){
        if(text.equals("")){
            return 0;
        }
        else{
            String del = ",";
            if(text.matches("//(.*)\n(.*)")){
                del = Character.toString(text.charAt(2));
                text = text.substring(4);
            }

            String numList[] = CreateArray(text, del + "|\n");
            return calculate(numList);
        }
    }

    private static int toIntValue(String number){
        if(number.charAt(0)-'a'>=0 && number.charAt(0)-'a'<=25){

            return number.charAt(0)-'a'+1;
        }
        return Integer.parseInt(number);
    }

    private static String[] CreateArray(String numbers, String splitter){
        return numbers.split(splitter);
    }

    private static int calculate(String[] numbers){
        int total = 0;
        String neg = "";

        for(String number : numbers){
            if(toIntValue(number) < 0){
                if(neg.equals(""))
                    neg = number;
                else
                    neg += ("," + number);
            }
            if(toIntValue(number) < 1000)
                total += toIntValue(number);
        }

        if(!neg.equals("")){
            throw new IllegalArgumentException("Negatives not allowed: " + neg);
        }

        return total;
    }
}