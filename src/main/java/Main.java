import controller.Controller;

import java.io.IOException;

/**
 * Main.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.getPlaceFromInputTextFile();
        controller.writeInformationToOutputFile(3);
    }

}
