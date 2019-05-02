package tw.core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static tw.core.Answer.*;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    public void createAnswerTest() {
        String input = "8 4 2 1";
        Answer actual = createAnswer(input);
        Answer expected = new Answer();
        List list = new ArrayList<>();
        list.add("8");
        list.add("4");
        list.add("2");
        list.add("1");
        expected.setNumList(list);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void checkTest() {

    }

    @Test
    public void validateTest() {
        String input = "12 12 12 12";
        Answer actual = createAnswer(input);
        try {
            actual.validate();
        } catch (Exception e) {
            assertEquals("Answer format is incorrect", e.getMessage());
        }
    }
}