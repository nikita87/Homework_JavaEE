package com.tms.validator;

import com.tms.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (StringUtils.isEmpty(user.getUsername())){
            errors.rejectValue("username", "username is invalid");
        }
        if (StringUtils.isEmpty(user.getPassword())){
            errors.rejectValue("password", "password is invalid");
        }
        if (StringUtils.isEmpty(user.getName())){
            errors.rejectValue("name", "name is invalid");
        }
        if (StringUtils.isEmpty(user.getSurname())){
            errors.rejectValue("surname", "surname is invalid");
        }
    }
}
