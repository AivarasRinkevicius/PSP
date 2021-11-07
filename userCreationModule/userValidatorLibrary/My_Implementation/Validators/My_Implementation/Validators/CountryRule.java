package My_Implementation.Validators;

public class CountryRule {


    private String countryCode;
    private  int phoneLength;
    private String phoneCode;

    public CountryRule(){

    }
    public CountryRule(String countryCode, int phoneLength, String phoneCode) {
        this.countryCode = countryCode;
        this.phoneLength = phoneLength;
        this.phoneCode = phoneCode;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getPhoneLength() {
        return phoneLength;
    }

    public void setPhoneLength(int phoneLength) {
        this.phoneLength = phoneLength;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}
