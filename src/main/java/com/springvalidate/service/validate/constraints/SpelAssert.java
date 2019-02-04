package com.springvalidate.service.validate.constraints;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;

/**
 * 
 * @author et2448
 * @see <a href="http://musingsofaprogrammingaddict.blogspot.com/2010/12/putting-spell-on-bean-validation-api.html">musingsofaprogrammingaddict blog</
 * @see SpelAssertValidator
 * @see ConstraintValidator
 *
 */
@Target( { TYPE } )
@Retention( RUNTIME )
@Constraint( validatedBy = SpelAssertValidator.class )
@Documented
public @interface SpelAssert
{

    /**
     * The default message.
     * @return
     */
    String message() default "{com.edb.payment.pays.core.util.validation.constraints.SpelAssert.message}";

    /**
     * Validation groups
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * Additional payload.
     * @return
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * The SPEL expression to evaluate.
     * @return
     */
    String value();

}
