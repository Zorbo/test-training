package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main2 {

    public static void main(String[] args) {

        var list = List.of("ONE", "TWO", "THREE", "FOUR","FIVE");
        var inputString = "abcdefghij";

        //System.out.println("RESULT: " + transformString(inputString, list));
       // System.out.println("RESULT: " + transformString2(inputString, list));
       // System.out.println("RESULT: " + transformString3(inputString, list));
        System.out.println("RESULT: " + transformString4(inputString, list, 2));

        Set<String> lo = new HashSet<>();
        Set<String> lo2 = new TreeSet<>();
        //Set<String> lo3 = new SortedSet<>();
        Map<UserDto, String> lololo = new HashMap<>();
        UserDto dto = new UserDto();

        lololo.put(dto, "bo");
        System.out.println(lololo);
        lololo.put(dto, "bo");
        System.out.println(lololo);

        System.out.println(5 > 4);

    }

    public static String transformString(String inputString, List<String> inputList) {

        int listIndex = 0;
        StringBuilder result = new StringBuilder();
        String input = inputString;
        List<String> resultList = new ArrayList<>();

        //TODO: elég lesz az append, mindig az elejéről építjük fel a stringet, mindig levágjuk
        //TODO: string 2|2|2|2|2
        for (int i = 0; i < inputString.length(); i++) {
            resultList.add(inputString.substring(i + 2));

            if (i % 2 == 0) {
                if (i == 0) {
                    result.append(inputList.get(listIndex));
                } else {
                    result.append(input, 0, i).append(inputList.get(listIndex));
                    input = input.substring(2);
                }

                //                if (i == 0) {
                //                    result.insert(i, inputList.get(listIndex));
                //                } else {
                //                    String firstHalf = result.substring(0, i + inputList.get(listIndex).length());
                //
                //                    result.insert(firstHalf.length(), inputList.get(listIndex));
                //                }

                //                String firstHalf = input.substring(0, i);
                //
                //                result.append(firstHalf).append(inputList.get(listIndex));
                //                input = input.substring(i, input.length() - 1);
                listIndex++;
            }
        }
        return result.toString();
    }

    public static String transformString2(String inputString, List<String> inputList) {

        int listIndex = 0;
        int subIndex = 0;
        List<String> result = new ArrayList<>();
        String subString = inputString;

        //TODO: use while? index in input!

        for (int i = 0; i < inputString.length(); i++) {

            if (i % 2 == 0) {
                result.add(inputString.substring(subIndex, i));
                if (i != 0) {
                    subIndex = subIndex + 2;
                }
                if (i < inputList.size()) {
                    result.add(inputList.get(listIndex));
                }
                listIndex++;
            }


        }
        return "null";
    }

    public static String transformString3(String inputString, List<String> inputList) {

        String input = inputString;
        List<String> resultList = new ArrayList<>();

        //TODO: elég lesz az append, mindig az elejéről építjük fel a stringet, mindig levágjuk
        //TODO: string 2|2|2|2|2
        for (int i = 0; i < inputString.length(); i++) {

            //Vizsgálni kell hogy a lista mérete nagyobb legyen mint az index különben outOfBond exception
            if (i < inputList.size()) {
                resultList.add(inputList.get(i));
            }
            //Itt végezzük el a kettővel oszthatóságot, ha kisebb az input mint kettő akkor outofbond lehet
            if (input.length() != 1) {
                resultList.add(input.substring(0 , 2));
                input = input.substring(2);
            }

        }
        // Az utolsó karaktert is hozzá kell adni ha páratlan
        if (input.length() == 1) {
            resultList.add(String.valueOf(input.charAt(0)));
        }

        return String.join("", resultList);
    }

    public static String transformString4(String inputString, List<String> inputList, int number) {

        int listIndex = 0;
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder(inputString);

        try {
            while (listIndex != inputList.size()) {
                stringBuilder.insert(index, inputList.get(listIndex));
                index = inputList.get(listIndex).length() + index + number;
                listIndex++;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Input inputString length is to short: " + inputString.length());
        }

        return stringBuilder.toString();
    }
}
