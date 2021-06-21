package TextUnits;

public class Paragraph extends UnitText {

    public String toString(){
        String s = "";
        for(UnitText sentence: getUnitTextList()){
            s +=sentence;
        }
        return s;
    }
}
