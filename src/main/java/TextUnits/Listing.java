package TextUnits;

public class Listing extends UnitText {

    public String toString(){
        String s = "";
        for(UnitText symbol: getUnitTextList()){
            String str = symbol.toString();
            if(str.equals("{") || str.equals("}") || str.equals(";")){
                str = str + "\n";
            }
            s+=str;
        }
        return s;
    }
}
