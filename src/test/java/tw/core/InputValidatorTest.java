package tw.core;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tw.validator.InputValidator;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private static InputValidator inputValidator;

    @BeforeClass
    public static void init(){
        inputValidator = new InputValidator();
    }

    @Test
    public void validateSuccess(){
        String input = "8 4 2 1";
        Boolean actual = inputValidator.validate(input);
        assertTrue(actual);
    }

    @Test
    public void validateFailure(){
        String input = "9999";
        Boolean actual = inputValidator.validate(input);
        assertFalse(actual);
    }
}
