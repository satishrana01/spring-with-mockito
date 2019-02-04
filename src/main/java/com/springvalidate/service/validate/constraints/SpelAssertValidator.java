package com.springvalidate.service.validate.constraints;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;

import javax.inject.Inject;
import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @see ConstraintValidator
 * @see ConstraintDeclarationException
 * @see SpelAssert
 * @see <a href="http://musingsofaprogrammingaddict.blogspot.com/2010/12/putting-spell-on-bean-validation-api.html">musingsofaprogrammingaddict blog</
 * 
 * @author et2448
 *
 */
public class SpelAssertValidator
    implements ConstraintValidator<SpelAssert, Object>
{

    @Inject
    private ExpressionParser parser;

    private Expression expression;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize( SpelAssert constraintAnnotation )
    {
        //SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        String rawExpression = constraintAnnotation.value();
       if ( rawExpression == null )
        {
            throw new ConstraintDeclarationException( "The expression specified in @" 
                                                      + SpelAssert.class.getSimpleName() 
                                                      + " must not be null." );
        }

        expression = parser.parseExpression( rawExpression );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid( Object value, ConstraintValidatorContext context )
    {
        return value == null ? true : expression.getValue( value, Boolean.class );
    }
}
