import My_Implementation.Validators.CountryRule;

public class PhoneValidator implements Validator{
    static String countryCode = "LT";
    static String phoneNumber;
    static String returnedPhoneNumber;

    @Override
    public boolean validate() {
        My_Implementation.Validators.PhoneValidator.addNewCountryRule(new CountryRule("LV", 9, "37"));
        returnedPhoneNumber = My_Implementation.Validators.PhoneValidator.validatePhoneNumber(countryCode, phoneNumber);
        System.out.println(returnedPhoneNumber);
        return returnedPhoneNumber != null;
    }
}
