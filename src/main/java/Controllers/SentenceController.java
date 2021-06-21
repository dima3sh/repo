package Controllers;

import TextUnits.Sentence;
import TextUnits.UnitText;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceController implements UnitTextController {
    private Sentence sentence;

    public SentenceController(String text){
        this.sentence = new Sentence();
        createUnitTextList(text);
    }

    public Sentence getSentence() {
        return sentence;
    }

    @Override
    public void createUnitTextList(String text) {
        List<UnitText> wordList = new ArrayList<>();
        Pattern p = Pattern.compile(".+?\\)?(\\..+?)?[\\.\\?!(?=\\s)]");
        Matcher m = p.matcher(text);
        WordController wordController;
        while(m.find()) {
            String wordText = m.group();
            wordText = wordText.trim();
            wordController = new WordController(wordText);
            wordList.add(wordController.getWord());
        }
        sentence.setUnitTextList(wordList);
    }
}
