package tw.core.generator;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Test
    public void generateTest() {
        RandomIntGenerator randomIntGenerator = Mockito.mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4)).thenReturn("8 4 2 1");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        try {
            Answer actual = answerGenerator.generate();
            assertEquals("8 4 2 1",actual.toString());
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }
}

