package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        //TDD -> red -> green -> refactor

        // MS -> functions/stuff
        //Endpoint func -> User name check if it's a palindrome

        List<String> testList = List.of("1","2","3");
        System.out.println("LENGTH ABC: " + "abc".length());
        System.out.println("SIZE LIST: " + List.of("1","2","3").size());
        String abcd = "1234";

        String[] stringArray = {"hello", "lol", "lolol"};
        int[] intArray = {1,2,23};
        System.out.println("LENGT: " + intArray.length);

        for (int i = abcd.length() -1; i >= 0; i--) {
            System.out.println("iteration:" + i + " charAt: " + abcd.charAt(i));
        }

        for (int i = abcd.length() -1; i >= 0; i--) {
            System.out.println("iteration:" + i + " charAt: " + abcd.charAt(i));
        }

        isPalindrome("Ana");
        isPalindrome("aaAAa");
        System.out.println(isPalindrome("aaAAa"));
        isPalindrome("abcdefg");
        System.out.println("abcdefg".substring(2));
        isPalindrome2("abcdefg");


        StringBuilder vertical = new StringBuilder();
        StringBuilder horizontal = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            if ( i % 3 == 0) {
                vertical.append("\n*");
            }
            if (i % 5 == 0) {
                horizontal.append(" * ");
            }
        }
        System.out.println(vertical);
        System.out.println(horizontal);

        iteratingBackWtf();

        System.out.println("DIAGONAL: " + diagonalDifference());
        reverseOther();
    }


    public static boolean isPalindrome(String userName) {


        StringBuilder result = new StringBuilder();

        for (int i = userName.length() -1; i >= 0; i--) {
           result.append(userName.charAt(i));
        }
        System.out.println("RESULT: " + result);
        return userName.toLowerCase().contentEquals(result.toString().toLowerCase());
    }

    //TODO: here

//    Java challange. Have the function MathChallange(int num) take the input, which will be an integer ranging from 1 to 250,
//    and return an integer output that will specify the least number of coins, that when added, equal the input integer.
//    Coins are based on a system as follows: there are coins representing the integers: 1,5,7,9 and 11. So for example: if num is 16,
//    then the output should be 2 with the coins 9 ans 7. if num is 25,
//    then the output should be 3 because you can achieve 25 with either 11,9 and 5 coins or with 9,9 and 7 coins.
//    examples: Input: 6 Output: 2 or Input: 16 Output: 2
    public static int MathChallange(int num) {
        int[] coins = {1, 5, 7, 9, 11};
        int[] dp = new int[num+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i-coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[num];
    }

//    Java code challange Have a function: Take the array of strings stored in strArr,
//    which will only contain two strings of equal length but other different length string as well.
//    Return the number of charaters at each position that are different between them.
    public static int getDifferentCharCount(String[] strArr) {
        String str1 = strArr[0];
        String str2 = strArr[1];
        int diffCount = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount;
    }

    public static boolean isPalindrome2(String userName) {

        char ch;
        String palindrom = "";

        for (int i = 0; i < userName.length(); i++) {
            ch = userName.charAt(i);
            palindrom = ch + palindrom;
        }
        System.out.println("RESULT PALI 2: " + palindrom);
        return userName.toLowerCase().contentEquals(palindrom.toLowerCase());
    }

    public static void reverse() {

        String str= "Geeks";
        String nstr= "";
        char ch;

        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i); //extracts each character
            nstr= ch+nstr; //adds each character in front of the existing string
        }
        System.out.println("Reversed word: "+ nstr);
    }

    public static void iteratingBackWtf() {

        var list = List.of(1,2,3,4,5);

        for (int i = list.size(); i-- > 0; ) {
            System.out.println(list.get(i));
        }
    }

    public static int diagonalDifference() {

        //TODO: 4x4 5x5 lista tömb, a hosszából mindig kivonni egyet iterácionként

        List<List<Integer>> arr = List.of(List.of(11,2,4), List.of(4,5,6), List.of(10,8,-12));

        var inputSize = arr.size();

        int leftToRight = 0;
        int rightToLeft = 0;

        for (int i = 0; i < arr.size(); i++) {
            leftToRight += arr.get(i).get(i);
            rightToLeft += arr.get(i).get(inputSize -1);
            inputSize--;
        }

//        int leftToRight = arr.get(0).get(0) + arr.get(1).get(1) + arr.get(2).get(2);
//        int rightToLeft = arr.get(0).get(2) + arr.get(1).get(1) + arr.get(2).get(0);
        return leftToRight > rightToLeft ? leftToRight - rightToLeft : rightToLeft - leftToRight;

    }

    public static void reverseOther() {

        List<String> arrr = List.of("a","b","c","d");

        var inputSize = arrr.size();
        var sum = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arrr.size(); i++) {
            builder.append(arrr.get(inputSize -1));
            inputSize--;
        }
        System.out.println("REVERSE OTHER: " + builder);
    }

    public String ticTacToeAdvanced(List<List<String>> input) {

        List<List<String>> input2 = List.of(List.of("O", "X", "O"), List.of("X", "X", "O"), List.of("X", "O", "O"));


        StringBuilder resultHorizontal = new StringBuilder();
        StringBuilder resultVertical = new StringBuilder();
        StringBuilder leftToRight = new StringBuilder();
        StringBuilder rightToLeft = new StringBuilder();
        int rightToLeftCounter = input.size();


        for (int i = 0; i < input.size(); i++) {
            resultHorizontal.append(" ");
            resultVertical.append(" ");
            leftToRight.append(input.get(i).get(i));
            rightToLeft.append(input.get(i).get(rightToLeftCounter -1));

            for (int j = 0; j < input.get(i).size(); j++) {
                resultHorizontal.append(input.get(i).get(j));
                resultVertical.append(input.get(j).get(i));
            }
            rightToLeftCounter--;
        }
        System.out.println("resultHorizontal: " + resultHorizontal);
        System.out.println("resultVertical: " + resultVertical);
        System.out.println("leftToRight: " + leftToRight);
        System.out.println("rightToLeft: " + rightToLeft);

        if (resultHorizontal.toString().contains("XXX") || resultVertical.toString().contains("XXX")
            || leftToRight.toString().contains("XXX") || rightToLeft.toString().contains("XXX")) {
            return "X win";
        }
        return "O win";
    }
}