package org.example;

public class Main4 {

    public static void main(String[] args) {

        String input = "123456789";

        StringBuilder builder = new StringBuilder();
        String firstLetter;
        String secondLetter;

        for (int i = 0; i < input.length() -1; i+= 2) {

            firstLetter = String.valueOf(input.charAt(i));
            secondLetter = String.valueOf(input.charAt(i + 1));

            builder.append(secondLetter).append(firstLetter);
        }
        if(input.length() % 2 == 1) {
            builder.append(input.charAt(input.length() -1));
        }
        System.out.println("RESULT: " + builder);
    }


}
