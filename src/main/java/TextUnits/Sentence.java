package TextUnits;

public class Sentence extends UnitText{

    public String toString(){
        String s = "";
        for(UnitText word: getUnitTextList()){
            s+=word;
            s+=" ";
        }
        return s;
    }

}
