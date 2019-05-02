package tw.core;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import tw.core.generator.RandomIntGenerator;

import static java.lang.Math.random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private static RandomIntGenerator randomIntGenerator;

    @BeforeClass
    public static void init() {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void generateNumsSuccess() {
        Integer digitmax = 1;
        Integer numberOfNeeded = 1;

        String actual = randomIntGenerator.generateNums(digitmax, numberOfNeeded);
        assertEquals("0", actual);
    }

    @Test
    public void generateNumsSuccessWithTwoNumber() {
        Integer digitmax = 2;
        Integer numberOfNeeded = 2;

        String actual = randomIntGenerator.generateNums(digitmax, numberOfNeeded);
        assertTrue(actual.equals("0 1")
                || actual.equals("1 0"));
    }

    @Test
    public void generateNumsFailure() {
        Integer digitmax = 9;
        Integer numberOfNeeded = 10;

        try {
            randomIntGenerator.generateNums(digitmax, numberOfNeeded);
        } catch (Exception exception) {
            assertEquals("Can't ask for more numbers than are available", exception.getMessage());
        }

    }
}