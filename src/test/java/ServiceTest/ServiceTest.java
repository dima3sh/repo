package ServiceTest;

import Controllers.TextController;
import Service.Service;
import TextUnits.Text;
import TextUnits.UnitText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ServiceTest {
    TextController textController;
    //Text textMock = Mockito.mock(Text.class);
    String mainText = "Ночь и день. Мальчик бегает быстро по дороге.";

    @Test
    public void sortSize(){
        String s = "|Мальчик бегает быстро по дороге.||Ночь и день.|";
        Text text = new Text();
        textController = new TextController(text);
        textController.createUnitTextList(s);
        Assertions.assertTrue(mainText.equals(new Service(text).sortSize().trim()));
    }

    @ParameterizedTest
    @MethodSource("getStrings")
    public void findFirstSingleWord(String answer, String textTask){
        Text text = new Text();
        textController = new TextController(text);
        textController.createUnitTextList(textTask);
        Assertions.assertEquals(answer, new Service(text).findFirstSingleWord().trim());
    }

    private static Stream<Arguments> getStrings() {
        return Stream.of(
                Arguments.of("День", "|День и ночь. Пора прекрасная пришла|"),
                Arguments.of("и", "|День и ночь. Пора прекрасная пришла. День.|"),
                Arguments.of("", "|День и ночь. Пора прекрасная пришла. День и ночь.|")
        );
    }

}
