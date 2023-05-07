package org.example;

import java.util.Set;

public class Main3 {

    public static void main(String[] args) {

        String inputString = "Kovacs Laszlo nyugdijjas telefonszam: 12345678910 email cime: "
            + "laszlokovacs@gmail.com karomkodasok: buzi kenyer kurva tulipan fasz basszataska";

        System.out.println("RESULT: " + maskString(inputString));

    }

    public static String maskString(String input) {

        String maskEmailRegexp = "[a-zA-Z0-9_]*@[a-zA-Z0-9_]*\\.[a-zA-Z0-9_]*";
        String maskEmailRegexpReplacement = "<email address>";

        String maskPhoneRegexp = "(\\+?[\\d]{1,3}([-]{0,2}|[\\s]+)?)?\\(?(\\d{3})\\)?([-]{0,2}|[\\s])?(\\d{3})([-]{0,2}|[\\s])?(\\d{4})(\\s?(([E|e]xt[:|.|]?)|x|X)(\\s?\\d+))?";
        String maskPhoneRegexpReplacement = "<phone number>";

//        String maskNameRegexp = "^[a-zA-Z\\s]+";
//        String maskNameRegexpReplacement = "<name>";

        Set<String> swearRepository = Set.of("basszataska", "buzi", "kurva", "fasz", "fuck");

        input = input.replaceAll(maskPhoneRegexp, maskPhoneRegexpReplacement);
        input = input.replaceAll(maskEmailRegexp, maskEmailRegexpReplacement);
       // input = input.replaceAll(maskNameRegexp, maskNameRegexpReplacement);

        for (String s : swearRepository) {
            StringBuilder censoredSwear = new StringBuilder();
            int stringLength = s.length();
            censoredSwear.append("*".repeat(stringLength));
            input = input.replace(s, censoredSwear);
        }
        return input;
    }

}

