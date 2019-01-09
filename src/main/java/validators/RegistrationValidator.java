/*
package validators;

import com.packageneha.models.Registration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator {
    public boolean supports (Class<?> aClass){
        System.out.println(aClass +": "+ Registration.class.equals(aClass));
        return Registration.class.equals(aClass);
    }
    public void validate(Object o, Errors errors){
        Registration registration= (Registration)o;
        System.out.println("inside validate");

        if(registration.firstName.equals("") || registration.firstName.equals(null)){
            System.out.println( " first name is null");
            errors.rejectValue("firstName","Registration.firstName", "firstName is null or empty");
        }
    }
}
*/
