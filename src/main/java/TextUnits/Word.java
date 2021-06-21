package TextUnits;

public class Word extends UnitText{

    public String toString(){
        String s = "";
        for(UnitText symbol: getUnitTextList()){
            s+=symbol;
        }
        return s;
    }
}
