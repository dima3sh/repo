package Controllers;

import TextUnits.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextController implements UnitTextController{
    private Text textMain;

    public TextController(Text text){
        this.textMain = text;
    }

    public String readFile(){

        String fileName = textMain.getFileName();
        BufferedReader in = null;
        final Logger LOGGER = LoggerFactory.getLogger(Text.class);

        try {
            in = new BufferedReader(new FileReader((fileName)));
        }catch(FileNotFoundException e){
            LOGGER.warn("Could not open " + fileName);
            return "";
        }catch(Exception e){
            try{
                in.close();
                LOGGER.info("File(" + fileName + ") is closed ");
            }catch(IOException e2){
                LOGGER.warn("Could not close " + fileName);
                System.exit(1);
            }
            return "";
        }

        LOGGER.info("File(" + fileName + ") is open");

        String str;
        StringBuilder sb = new StringBuilder();
        try {
            while ((str = in.readLine()) != null)
                sb.append(str);
            in.close();
        }catch(Exception e){

        }
        return sb.toString();
    }

    public List getSentences (){
        List<UnitText>  sentenceList= new ArrayList<>();
        for(UnitText paragraph: textMain.getUnitTextList()){
            for(UnitText sentence : paragraph.getUnitTextList()){
                sentenceList.add(sentence);
            }
        }
        return sentenceList;
    }

    public List getWords(){
        List<UnitText> words= new ArrayList<>();
        List<UnitText> paragraphs = textMain.getUnitTextList();

        for(UnitText paragraph :  paragraphs){
            for(UnitText sentence : paragraph.getUnitTextList()){
                words.addAll(sentence.getUnitTextList());
            }
        }
        return words;
    }


    public void createUnitTextList(String text){
        List<UnitText> paragraphListingList = new ArrayList<>();
        Pattern p = Pattern.compile("\\|\\|?(.+?)\\|");
        String pCode = "\\{code\\}(.+?)\\{\\/code\\}";
        Matcher m = p.matcher(text);
        ParagraphController paragraphController;
        ListingController listingController;

        while(m.find()) {
            if(Pattern.matches(pCode, m.group(1))){
                Matcher m2 = Pattern.compile(pCode).matcher(m.group(1));

                if(m2.find()) {
                    listingController = new ListingController(m2.group(1));
                    paragraphListingList.add(listingController.getListing());
                }
            }else {
                paragraphController = new ParagraphController(m.group(1));
                paragraphListingList.add(paragraphController.getParagraph());
            }
        }
        textMain.setUnitTextList(paragraphListingList);
    }
}
