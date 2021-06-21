package Controllers;

import TextUnits.Paragraph;
import TextUnits.UnitText;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphController implements UnitTextController {
    private Paragraph paragraph;

    public ParagraphController(String paragraphText){
        this.paragraph = new Paragraph();
        createUnitTextList(paragraphText);
    }

    @Override
    public void createUnitTextList(String text) {
        List<UnitText> sentenceList = new ArrayList<>();
        Pattern p = Pattern.compile("(?<=[\\.!\\?])?.+?(\\.\\W)?[\\.!\\?]");
        Matcher m = p.matcher(text);
        SentenceController sentenceController;

        while(m.find()) {
            sentenceController = new SentenceController(m.group());
            sentenceList.add(sentenceController.getSentence());
        }
        paragraph.setUnitTextList(sentenceList);
    }

    public Paragraph getParagraph() {
        return paragraph;
    }
}
