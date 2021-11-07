public class ValidatorFactory {

    public Validator getValidator(String validatorType)
    {
        if(validatorType == null)
        {
            return null;
        }
        if(validatorType.equalsIgnoreCase("EMAIL")){
            return new EmailValidator();
        }
        else if(validatorType.equalsIgnoreCase("PASSWORD")){
            return new PasswordValidator();
        }
        else if(validatorType.equalsIgnoreCase("PHONE")){
            return new PhoneValidator();
        }

        return null;
    }
}
