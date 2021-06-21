package Controllers;

import TextUnits.Symbol;
import TextUnits.UnitText;
import TextUnits.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordController implements UnitTextController {
    private Word word;

    public WordController(String wordText){
        this.word = new Word();
        createUnitTextList(wordText);
    }

    public Word getWord() {
        return word;
    }

    @Override
    public void createUnitTextList(String text) {
        List<UnitText> symbolList = new ArrayList<>();
        Pattern p = Pattern.compile(".");
        Matcher m = p.matcher(text);
        while(m.find()) {
            symbolList.add(new Symbol(m.group()));
        }
        word.setUnitTextList(symbolList);
    }
}
