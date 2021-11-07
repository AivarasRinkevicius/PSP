package My_Implementation.Validators;

import java.util.ArrayList;

public class PhoneValidator {
    private static final ArrayList<CountryRule> countryRules = new ArrayList<CountryRule>();

    public static String validatePhoneNumber(String countryCode, String phoneNumber) {
        if(phoneNumber.length() == 0){
            return null;
        }
        char firstSymbol = phoneNumber.charAt(0);
        if(firstSymbol == '8' && countryCode.equals("LT")){
            String lithuanianCodeStart = "+370";
            return getPhoneNumberWithoutFirstSymbol(phoneNumber,lithuanianCodeStart);
        }

        if(!onlyDigits(phoneNumber)){
            return null;
        }

        char[] phoneCodeCharArray = getCountryCodeFromNumber(phoneNumber).toCharArray();
        char[] countryCodeCharArray = countryCode.toCharArray();


        int counter = 0;

        System.out.println(countryRules.size());
        for(int i = 0; i< countryRules.size();i++){
            if(comparingStrings(phoneCodeCharArray,counter, countryRules.get(i).getPhoneCode()) &&
                    comparingStrings(countryCodeCharArray,counter,countryRules.get(i).getCountryCode())
                    && phoneNumber.length() == countryRules.get(i).getPhoneLength()
            ){

                return phoneNumber;
            }
        }
        return null;
    }

    private static boolean comparingStrings(char[] charArray, int counter, String phonePart) {
        char [] phonePartArray = phonePart.toCharArray();
        for(int j = 0; j < charArray.length; j++){
            if(charArray[j] == phonePartArray[j]) {
                counter++;
            }
            if(counter == charArray.length){
                return true;
            }
        }
        return false;
    }

    public static void addNewCountryRule(CountryRule countryRule) {
        countryRules.add(countryRule);
    }

    public static String getCountryCodeFromNumber(String phoneNumber){
        String code = "";
        for(int i = 0; i < 4 ; i ++){
            code += phoneNumber.charAt(i);
        }
        return code;
    }

    public static String getPhoneNumberWithoutFirstSymbol(String phoneNumber, String lithuanianCodeStart){
        for(int i = 0; i < phoneNumber.length(); i++)
        {
            char phoneSymbol = phoneNumber.charAt(i);
            if(i > 0){
                lithuanianCodeStart+= phoneSymbol;
            }
        }
        return lithuanianCodeStart;
    }

    public static boolean onlyDigits(String phoneNumber)
    {
        int counter = 0;
        String withoutPlusSymbol= "";
        char firstSymbol = phoneNumber.charAt(0);
        if(firstSymbol == '+'){
            for(int j = 1; j < phoneNumber.length(); j ++){
                withoutPlusSymbol += phoneNumber.charAt(j);
            }
        }
        for (int i = 0; i < withoutPlusSymbol.length(); i++) {
            if (withoutPlusSymbol.charAt(i) >= '0' && withoutPlusSymbol.charAt(i) <= '9') {
                counter++;
            }
            else {
                return false;
            }
        }
        if(counter == withoutPlusSymbol.length()){
            return true;
        }
        else{
            return false;
        }

    }
}

