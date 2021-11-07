
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ValidatorFactory validatorFactory = new ValidatorFactory();
        Validator emailValidator = validatorFactory.getValidator("EMAIL");
        Validator passwordValidator = validatorFactory.getValidator("PASSWORD");
        Validator phoneValidator = validatorFactory.getValidator("Phone");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            System.out.println("press 1 to insert new user \n press 2 to update user \n press 3 to delete the user \n press 4 to read user information \n press 5 to add new validation rules for phone number");
            String choice = reader.readLine();
            switch (choice)
            {
                case "1":
                    System.out.println("write name:");
                    String name = reader.readLine();
                    while(name.equals(""))
                    {
                        System.out.println("Wrong name please insert valid name:");
                        name = reader.readLine();
                    }
                    System.out.println("write surname:");
                    String surname = reader.readLine();
                    while(surname.equals(""))
                    {
                        System.out.println("Wrong name please insert valid surname:");
                        surname = reader.readLine();
                    }
                    /*System.out.println("write phone number country code:");
                    String countryCode = reader.readLine();
                    while(countryCode.equals(""))
                    {
                        System.out.println("Wrong country code please insert valid country code:");
                        countryCode = reader.readLine();
                    }*/
                    System.out.println("write phone number:");
                    String phoneNumber = reader.readLine();
                    PhoneValidator.phoneNumber = phoneNumber;
                    while(phoneNumber.equals("")||!phoneValidator.validate())
                    {
                        System.out.println("Wrong phone number please insert valid phone number:");
                        phoneNumber = reader.readLine();
                        PhoneValidator.phoneNumber = phoneNumber;
                    }
                    break;
            }
        }
    }

}
