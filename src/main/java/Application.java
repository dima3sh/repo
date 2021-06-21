
import Controllers.TextController;
import Service.Service;
import TextUnits.*;

import java.io.*;

public class Application {
    public static void main(String[] args)throws IOException {
        Text text = new Text("notes1.txt");
        TextController controller = new TextController(text);
        controller.createUnitTextList(controller.readFile());
        System.out.println(text);

    }
}
