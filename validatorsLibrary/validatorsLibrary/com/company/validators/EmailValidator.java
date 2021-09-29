package com.company.validators;

import com.company.interfaces.ValidateEmail;

import java.util.ArrayList;
import java.util.List;

public class EmailValidator implements ValidateEmail {

    private List<String> listOfDomain= new ArrayList<>();

    private List<String> listOfTLD = new ArrayList<>();

    private List<Character> listOfIllegalSymbols = new ArrayList<>();

    public EmailValidator(){
        addDomainAddress("google");
        addDomainAddress("gmail");
        addDomainAddress("yahoo");

        addlistOfTLDAddress(".com");
        addlistOfTLDAddress(".net");
        addlistOfTLDAddress(".org");
        addlistOfTLDAddress(".lt");

        addIllegalSymbol('©');
    }

    private boolean isEmailNotEmpty(String email) {
        return !email.isEmpty();
    }

    private boolean isEmailNotEmptyAndNotNull(String email)
    {
        boolean isNotNull = email != null;
        boolean isNotEmpty = false;
        if(isNotNull)  {
            isNotEmpty = isEmailNotEmpty(email);
        }
        return isNotNull && isNotEmpty;
    }

    public void addDomainAddress(String domainAddress) {
        listOfDomain.add(domainAddress);
    }

    public void addlistOfTLDAddress(String domainAddress) {
        listOfTLD.add(domainAddress);
    }

    public void addIllegalSymbol(char domainAddress) {
        listOfIllegalSymbols.add(domainAddress);
    }

    public List<String> getListOfDomain() {
        return listOfDomain;
    }

    public List<String> getListOfTLD() {
        return listOfTLD;
    }

    public List<Character> getListOfIllegalSymbols() {
        return listOfIllegalSymbols;
    }

    private boolean emailContainsEta(String email)
    {
        return email.contains("@");
    }

    private boolean emailDoNotContainIllegalSymbols(String emailStartBeforeEta) {
        for (char illegalSymbol:
        listOfIllegalSymbols) {
            if(emailStartBeforeEta.contains(Character.toString(illegalSymbol)))
            {
                return false;
            }
        }
        return true;
    }

    private boolean isEmailDomainCorrect(String domain)
    {
        for (String domainFromList:
        listOfDomain) {
            if(domain.equals(domainFromList))
            {
                return true;
            }
        }
        return false;
    }

    private int emailContainsDot(String email)
    {
        return email.indexOf(".");
    }
    private boolean emailContainsCorrectDomain(String email, int etaPsotion, int dotPosition) {
        if(dotPosition==-1)
        {
            return isEmailDomainCorrect(email.substring(etaPsotion+1));
        }
        else{
            return isEmailDomainCorrect(email.substring(etaPsotion+1,dotPosition));
        }
    }


    private boolean correctEmailTLD(String emailTLD) {
        for (String TLD:
            listOfTLD) {
            if(emailTLD.equals(TLD))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validateEmail(String email){
        boolean isNotEmptyAndNotNull = isEmailNotEmptyAndNotNull(email);
        boolean isNotContainingIllegalSymbol = true;
        boolean isDomainCorrect = false;
        boolean isTLDCorrect = false;
        if(isNotEmptyAndNotNull){
            if(emailContainsEta(email)){
                int etaPosition = email.indexOf("@");
                int dotPosition = emailContainsDot(email);
                isNotContainingIllegalSymbol = emailDoNotContainIllegalSymbols(email.substring(0,etaPosition));
                isDomainCorrect = emailContainsCorrectDomain(email, etaPosition, dotPosition);
                if(dotPosition!=-1){
                    isTLDCorrect = correctEmailTLD(email.substring(dotPosition));
                }
            }
        }
        return isNotEmptyAndNotNull && isNotContainingIllegalSymbol && isDomainCorrect && isTLDCorrect;
    }
}
