package TextUnits;

import java.io.IOException;

public class Text extends UnitText{
    private String text;
    private String fileName = "";

    public Text(String fileName) throws IOException{
        this.fileName = fileName;
        //createList(string);
    }

    public Text(){}

    public String getFileName(){
        return fileName;
    }

    public String toString(){
        String s = "";
        for(UnitText paragraph: getUnitTextList()){
            s+=paragraph;
            s+="\n";
        }
        return s;
    }
}
