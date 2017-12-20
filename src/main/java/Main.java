import controller.Controller;
import controller.OutputFileWriter;
import tools.PlaceNotFoundException;

import java.io.IOException;

/**
 * Main.
 */
public class Main {

    public static void main(String[] args) throws IOException, PlaceNotFoundException {
        Controller controller = new Controller(new OutputFileWriter("src\\main\\resources\\txt\\input.txt", "src\\main\\resources\\txt\\output.txt"));
        //controller.getWeatherUsingConsoleOneFile();
        //controller.getWeatherUsingInputOneFile();
        controller.getWeatherUsingInputMultipleFiles();
    }

}
