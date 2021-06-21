package TextUnits;

import java.util.ArrayList;
import java.util.List;

abstract public class UnitText {
    private List<UnitText> unitTextList = new ArrayList<>();

    public void setUnitTextList(List<UnitText> unitTextList) {
        this.unitTextList = unitTextList;
    }

    public List<UnitText> getUnitTextList() {
        return unitTextList;
    }

    public int getListSize(){
        return unitTextList.size();
    }
}
