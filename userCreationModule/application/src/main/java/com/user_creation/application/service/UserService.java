package com.user_creation.application.service;

import com.user_creation.application.interfaces.Validator;
import com.user_creation.application.model.PasswordValidator;
import com.user_creation.application.model.User;
import com.user_creation.application.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final ValidatorFactory validatorFactory;

    public UserService(UserRepository userRepository, ValidatorFactory validatorFactory) {
        this.userRepository = userRepository;
        this.validatorFactory = validatorFactory;
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public void deleteById(long userId){
        userRepository.deleteById(userId);
    }

    public User findById(long id){
        if(userRepository.findById(id).isPresent())
        {
            return userRepository.findById(id).get();
        }
        return null;
    }

    public boolean validate(User user)
    {
        Validator emailValidator = validatorFactory.getValidator("EMAIL");
        Validator passwordValidator = validatorFactory.getValidator("PASSWORD");
        Validator phoneValidator = validatorFactory.getValidator("PHONE");

        boolean isEmailValid = emailValidator.validate(user.getEmail());
        boolean isPasswordValid = passwordValidator.validate(user.getSlaptazodis());
        boolean isPhoneValid = phoneValidator.validate(user.getTelefonoNumeris());

        if(!isEmailValid)
        {
            System.out.println("wrong email");
        }
        if(!isPasswordValid)
        {
            System.out.println("wrong password");
        }
        if(!isPhoneValid)
        {
            System.out.println("wrong phone number");
        }
        return(isEmailValid && isPasswordValid && isPhoneValid);
    }

    public void save(User user)
    {
        if(validate(user))
        {
            userRepository.save(user);
        }
    }

    public User add(User user) {
        if(validate(user)) {
            return userRepository.save(user);
        }
            return null;
    }
}
