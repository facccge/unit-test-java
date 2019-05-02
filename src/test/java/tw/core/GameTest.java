package tw.core;

import org.junit.Test;
import org.mockito.Mockito;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.core.model.GuessResult;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    @Test
    public void guessTest(){
        Answer inputAnswer= Answer.createAnswer("8 4 2 1");
        RandomIntGenerator randomIntGenerator = Mockito.mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("8 4 2 1");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Game game = null;
        try {
            game = new Game(answerGenerator);
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
        GuessResult actual =game.guess(inputAnswer);
        assertEquals("4A0B",actual.getResult());
    }
}
