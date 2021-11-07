
public class EmailValidator implements Validator{
    public static String email;

    @Override
    public boolean validate() {
        return My_Implementation.Validators.EmailValidator.validateEmail(email);
    }
}
