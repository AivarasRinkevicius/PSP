package My_Implementation.Validators;

import java.util.ArrayList;

public class PasswordChecker {

    private static final ArrayList<Character> specialSymbolsList = new ArrayList<Character>();
    private static int minPasswordLength;
    public static void setMinPasswordLength(int passwordLength) {
        minPasswordLength = passwordLength;
    }

    public static void setSpecialSymbolList(ArrayList<Character> specialSymbols) {
        for(int i = 0; i < specialSymbols.size(); i++){
            specialSymbolsList.add(specialSymbols.get(i));
        }
    }
    public static boolean checkPassword(String password) {

        if(password.length() == 0){
            return false;
        }
        if(password.length() < minPasswordLength){
            return false;
        }
        if(!isStringUpperCase(password)){
            return false;
        }
        if(!isSpecialSymbol(password,specialSymbolsList)){
            return false;
        }
        return true;
    }

    private static boolean isSpecialSymbol(String password, ArrayList<Character> specialList){
        for(int i=0; i < specialList.size(); i++){
            if(containsSymbol(password,specialList.get(i)))
                return true;
        }
        return false;
    }
    public static boolean containsSymbol(String password, Character character) {
        char[] charArray = password.toCharArray();
        for(int i = 0; i < password.length();i++){
            if(charArray[i] == character){
                return true;
            }
        }
        return false;
    }

    public static void addSpecialSymbol(char specialSymbol) {
        specialSymbolsList.add(specialSymbol);
    }

    public static void removeSpecialSymbol(char symbol) {
        for(int i =0; i< specialSymbolsList.size(); i++){
            if(specialSymbolsList.get(i) == symbol){
                specialSymbolsList.remove(i);
            }
        }
    }
    public static boolean isStringUpperCase(String password){
        char[] charArray = password.toCharArray();
        for(int i=0; i < charArray.length; i++){
            if(charArray[i] >= 'A' && charArray[i] <= 'Z')
                return true;
        }
        return false;
    }

}
