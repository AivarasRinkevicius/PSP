
/*import com.company.validators.EmailValidator;
import com.company.validators.PasswordChecker;
import com.company.validators.PhoneValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class validationModules {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final EmailValidator emailValidator = new EmailValidator();
    private static final PasswordChecker passwordChecker = new PasswordChecker();
    private static final PhoneValidator phoneValidator = new PhoneValidator();

    public static void createUser(String path) throws IOException {
        User newUser = new User(readName(), readSurname(), readPhoneNumber(), readEmail(), readAddress(), readPassword());
        System.out.println(newUser);
       // AddUser.save(path, newUser);
    }

    private static String readName() throws IOException {
        System.out.println("Type in your name");
        return reader.readLine();
    }

    private static String readSurname(){
        System.out.println("Type in your surname");
        return scanner.nextLine();
    }

    private static String validatePhoneNumber() throws IOException {
        System.out.println("Write your phone number");
        String phoneNumber = reader.readLine();
        if(phoneValidator.validatePhone(phoneNumber)) {
            return phoneNumber;
        }
        else{
            System.out.println("Inserted phone number is not valid!");
            return null;
        }
    }

    private static String validateEmail() throws IOException {
        System.out.println("Write your email");
        String email = reader.readLine();
        if(emailValidator.validateEmail(email)) {
            return email;
        }
        else{
            System.out.println("Provided email address is incorrect");
            return null;
        }
    }

    /*private static String readAddress(){
        System.out.println("Type in your Adress");
        return scanner.nextLine();
    }*/

   /* private static String validatePassword(){
        System.out.println("Type in your Password");
        String password = scanner.nextLine();
        if(!passwordChecker.checkPassword(password)) {
            System.out.println("Password is not valid");
            System.exit(1);
        }
        return password;
    }
}
*/