package util;

import exception.CustomException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

public class checkValidation {
    public static <T> boolean isValid(T object) {

        try {

            ValidatorFactory factory = Validation.byDefaultProvider().configure()
                    .messageInterpolator(new ParameterMessageInterpolator()).buildValidatorFactory();

            Validator validator = factory.getValidator();
            Set<ConstraintViolation<T>> violationSet = validator.validate(object);

            if (!violationSet.isEmpty()) {
                for (ConstraintViolation<T> violation : violationSet) {
                    System.out.println(violation.getMessage());
                }
                factory.close();
                return false;
            } else {
                return true;
            }
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}