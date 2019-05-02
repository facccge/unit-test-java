package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tw.commands.GuessInputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private String systemOut() {
        return outContent.toString();
    }

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void playTest() {
        try {
            GuessInputCommand guessInputCommand = Mockito.mock(GuessInputCommand.class);
            when(guessInputCommand.input()).thenReturn(Answer.createAnswer("8 4 2 1"));

            RandomIntGenerator randomIntGenerator = Mockito.mock(RandomIntGenerator.class);
            when(randomIntGenerator.generateNums(9, 4)).thenReturn("8 4 2 1");

            AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
            Game game = new Game(answerGenerator);
            GameView gameView = new GameView();
            GameController gameController = new GameController(game, gameView);
            gameController.play(guessInputCommand);

            String expected = "Guess Result: 4A0B\r\n" +
                    "Guess History:\r\n" +
                    "[Guess Numbers: 8 4 2 1, Guess Result: 4A0B]\r\n" +
                    "Game Status: success\r\n";
            assertEquals(expected, systemOut());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }
}