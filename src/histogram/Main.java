package histogram;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Histogram histogram = new Histogram();
        //histogram.analyseString("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        try {
            histogram.analyseFile("src/histogram/analyze.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e);
            return;
        }

        histogram.printGraph();
    }
}
