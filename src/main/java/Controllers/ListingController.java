package Controllers;

import TextUnits.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListingController implements UnitTextController{
    private Listing listing;

    public ListingController(String text){
        this.listing = new Listing();
        createUnitTextList(text);
    }

    public Listing getListing() {
        return listing;
    }

    @Override
    public void createUnitTextList(String text) {
        List<UnitText> symbolList = new ArrayList<>();
        Pattern p = Pattern.compile(".");
        Matcher m = p.matcher(text);

        while(m.find()) {
            symbolList.add(new Symbol(m.group()));
        }
        listing.setUnitTextList(symbolList);
    }
}
