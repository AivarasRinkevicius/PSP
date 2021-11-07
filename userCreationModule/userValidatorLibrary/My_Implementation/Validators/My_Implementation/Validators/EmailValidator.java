package My_Implementation.Validators;

import java.util.ArrayList;

public class EmailValidator {

    private static final ArrayList<Character> validCharactersForUsername = new ArrayList<Character>();
    private static final ArrayList<Character> validCharactersForDomain = new ArrayList<Character>();
    private static final ArrayList<Character> validCharactersForTopLevelDomain = new ArrayList<Character>();
    public static boolean validateEmail(String email) {
        setValidChars();
        String[] splitIntoUsernameAndDomain = email.split("@");
        if(splitIntoUsernameAndDomain.length != 2){
            return false;
        }
        String usernamePart = splitIntoUsernameAndDomain[0];
        String domainPartFull = splitIntoUsernameAndDomain[1];
        String domainPartBeforeTLD = splitToArrayDomainFirstPart(domainPartFull);

        if(usernamePart.length() > 64 || usernamePart.length() == 0){
            return false;
        }
        if(domainPartFull.length() > 253 || domainPartFull.length() == 0){
            return false;
        }

        int isRepeated = 0;

        if(domainPartBeforeTLD != null){
            char[] splitTLDPart = splitToArrayTLD(domainPartFull);
            if(splitTLDPart != null){
                String topLevelDomainPart = new String(splitTLDPart);
                if(topLevelDomainPart.length() > 63 || topLevelDomainPart.length() < 2){
                    return false;
                }
                if(countDotSymbols(domainPartFull) >= 1){
                    return false;
                }
                if(!checkEmailParts(usernamePart,'.',isRepeated,validCharactersForUsername)){
                    return false;
                }
                if(!checkEmailParts(domainPartBeforeTLD,'-',isRepeated,validCharactersForDomain)){
                    return false;
                }
                if(!checkEmailParts(topLevelDomainPart,'-',isRepeated,validCharactersForTopLevelDomain)){
                    return false;
                }
            }
        }
        else{
            if(!checkEmailParts(usernamePart,'.',isRepeated,validCharactersForUsername)){
                return false;
            }
            if(!checkEmailParts(domainPartFull,'-',isRepeated,validCharactersForDomain)){
                return false;
            }
        }
        return true;
    }

    private static boolean checkEmailParts(String emailPart, char symbol, int isRepeated, ArrayList<Character> invalidCharactersForEmailPart){

        if(isStringInASCII(emailPart)){
            if(!checkUsernameOrDomainAtPositions(symbol, emailPart,isRepeated,invalidCharactersForEmailPart) && !checkForComments(emailPart)){
                return false;
            }
        }
        if(!isStringInASCII(emailPart)){
            addOnlyNonASCII(emailPart, invalidCharactersForEmailPart);
            if(!checkUsernameOrDomainAtPositions(symbol, emailPart,isRepeated,invalidCharactersForEmailPart) && !checkForComments(emailPart)){
                return false;
            }
        }
        return true;
    }

    private static int countDotSymbols(String email) {
        int dots = 0;
        for(int j =0; j < email.length();j++){
            if(email.charAt(j) == '.' && email.charAt(j+1) == '.'){
                dots++;
            }
            else{
                dots = 0;
            }
            if(dots >= 1){
                return dots;
            }
        }
        return dots;
    }
    private static String splitToArrayDomainFirstPart(String email) {
        int positionCounter = 0;
        int theLastDot = 0;
        for(int j =0; j < email.length();j++){
            if(email.charAt(j) == '.'){
                theLastDot = j;
            }
        }
        for(int j =0; j < email.length();j++){
            if(email.charAt(j) == '.' && theLastDot == j){
                char [] domainPart = new char[theLastDot];
                for(int i = 0; i < theLastDot;i++){
                    domainPart[positionCounter] = email.charAt(i);
                    positionCounter++;
                }
                return  new String(domainPart);
            }
        }
        return null;
    }

    private static char[] splitToArrayTLD(String email) {
        int counter = 0;
        int positionCounter = 0;
        int dotPosition = 0;
        for (int j = 0; j < email.length(); j++) {
            if (email.charAt(j) == '.' && email.charAt(j + 1) != '.') {
                dotPosition = j;
            }
        }
        for (int j = 0; j < email.length(); j++) {
            if (email.charAt(j) == '.' && dotPosition == j) {
                char[] domainPart = new char[email.length() - 1 - counter];
                for (int i = counter + 1; i < email.length(); i++) {
                    domainPart[positionCounter] = email.charAt(i);
                    positionCounter++;
                }
                return domainPart;
            }
            counter++;
        }
        return null;
    }

    private static boolean checkUsernameOrDomainAtPositions(char symbol, String emailPart, int isRepeated, ArrayList<Character> specialSymbolsList){
        for(int i = 0; i < emailPart.length(); i++){
            if(emailPart.charAt(i) == symbol)
                isRepeated++;
            else
                isRepeated = 0;

            if(isRepeated > 1){
                return false;
            }
            if((emailPart.charAt(i) == symbol && i == 0)) {
                return false;
            }
            if((emailPart.charAt(i) == symbol && i == emailPart.length()-1)){
                return false;
            }
            if(!specialSymbolsList.contains(emailPart.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private static boolean checkForComments(String emailPart){
        for(int i = 0; i < emailPart.length();i++){
            if(emailPart.charAt(i) == '(' && i == 0){
                if(isCommentInTheBeginning(emailPart)){
                    return true;
                }
            }
            if(emailPart.charAt(i) == '('){
                if(isCommentInTheEnd(emailPart)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCommentInTheBeginning(String emailPart){
        for(int i =0; i < emailPart.length(); i++){
            if(emailPart.charAt(i) == ')'){
                return true;
            }
        }
        return false;
    }
    private static boolean isCommentInTheEnd(String emailPart){
        for(int i =0; i < emailPart.length(); i++){
            if(emailPart.charAt(i) == ')' && i == emailPart.length()-1){
                return true;
            }
        }
        return false;
    }

    private static boolean isStringInASCII(String input) {
        boolean isASCII = true;
        for (int i = 0; i < input.length(); i++) {
            int character = input.charAt(i);
            if (character > 0x7F) {
                isASCII = false;
                break;
            }
        }
        return isASCII;
    }
    private static void addOnlyNonASCII(String emailPart, ArrayList<Character> charactersList) {
        for(int i =0; i < emailPart.length();i++){
            if(!checkIfCharIsASCII(emailPart.charAt(i))){
                charactersList.add(emailPart.charAt(i));
            }
        }
    }

    private static boolean checkIfCharIsASCII(char c ){
        boolean isASCII = true;
        if (c > 0x7F) {
            isASCII = false;
        }
        return isASCII;
    }

    public static void setValidChars() {
        String specialCharactersStringForUsername = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%&'*+-/=?^_`{|}~.";
        String specialCharactersStringForDomain = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.-";
        String specialCharactersStringForTopLevelDomain = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-";
        for(int i = 0; i < specialCharactersStringForUsername.length(); i++){
            validCharactersForUsername.add(specialCharactersStringForUsername.charAt(i));
        }
        for(int i = 0; i < specialCharactersStringForDomain.length(); i++){
            validCharactersForDomain.add(specialCharactersStringForDomain.charAt(i));
        }
        for(int i = 0; i < specialCharactersStringForTopLevelDomain.length(); i++){
            validCharactersForTopLevelDomain.add(specialCharactersStringForTopLevelDomain.charAt(i));
        }
    }
}
