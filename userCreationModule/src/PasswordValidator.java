public class PasswordValidator implements Validator{
    static String password;

    @Override
    public boolean validate() {
        return My_Implementation.Validators.PasswordChecker.checkPassword(password);
    }
}
