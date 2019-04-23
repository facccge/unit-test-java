package tw.core;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import tw.validator.InputValidator;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        boolean actual = inputValidator.validate(input);
        assertTrue(actual);
    }

    @Test
    public void validateFailure(){
        String input = "9999";
        boolean actual = inputValidator.validate(input);
        assertFalse(actual);
    }
}
