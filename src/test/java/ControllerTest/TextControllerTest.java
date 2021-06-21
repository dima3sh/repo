package ControllerTest;

import Controllers.TextController;
import TextUnits.Text;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TextControllerTest {
   private TextController textController;

    @ParameterizedTest
    @MethodSource("getStrings")
    public void createUnitTextListTest(String answer, String textTask){
        Text text = new Text();
        textController = new TextController(text);
        textController.createUnitTextList(textTask);
        Assertions.assertEquals(answer.trim(), text.toString().trim());
    }

    private static Stream<Arguments> getStrings() {
        return Stream.of(
                Arguments.of("День и ночь. Пора прекрасная пришла. \nБыли дни и ночи.",
                        "|День и ночь. Пора прекрасная пришла.||Были дни и ночи.|"),
                Arguments.of("День и ночь. Пора прекрасная пришла. День.",
                        "|День и ночь. Пора прекрасная пришла. День.|"),
                Arguments.of("День и ночь. Пора прекрасная пришла. День и ночь. \n" +
                        "Пришло лето, ушла зима. \n" +
                        "int m = 5;\n int t = m + 2;",
                        "|День и ночь. Пора прекрасная пришла. День и ночь.|" +
                                 "|Пришло лето, ушла зима.|" +
                                 "|{code}int m = 5; int t = m + 2;{/code}|")
        );
    }
}
