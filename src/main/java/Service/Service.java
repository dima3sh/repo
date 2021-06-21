package Service;

import Controllers.TextController;
import TextUnits.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service implements ServiceControl {

    private Text text;
    public Service(Text  text){
        this.text = text;
    }

    //task number 2
    @Override
    public String sortSize() {
        TextController textController = new TextController(text);
        List<UnitText>  listSentences = textController.getSentences();
        listSentences.sort((UnitText sentence1, UnitText sentence2)->{
            return (sentence1.getListSize() - sentence2.getListSize());
        });
        String string = "";
        for(UnitText sentence : listSentences){
            string += sentence.toString();
        }
        return string;
    }
    //task number 3
    @Override
    public String findFirstSingleWord(){
        TextController textController = new TextController(text);
        List<Word> words= textController.getWords();
        List <Sentence> sens= textController.getSentences();
        Sentence sentence = sens.get(0);
        Pattern p = Pattern.compile("^(.+?)\\.?$");
        Matcher m1, m2;
        List<UnitText> firstSentWords = sentence.getUnitTextList();
        int count = 0;

        for(UnitText word : firstSentWords){
            count = 0;
            String str = "";
            m1 = p.matcher(word.toString().trim());
            if(m1.find()) str = m1.group(1);
            for(UnitText w : words){
                m2 = p.matcher(w.toString().trim()); //System.out.println(word.toString());
                String str2 = "";
                if(m2.find()) str2 = m2.group(1);
                if (str.equals(str2) && str != ""){
                    count++;
                }
                if (count > 1) break;


            }
            if(count == 1) return str;
        }
        return "";
    }

}
