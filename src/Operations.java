import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Operations {
    private ArrayList<Double> randomNumbers = new ArrayList<>(); // random number storage variable

    /*
     * This function will return the minimum value from the list of the random number
     */
    public Double minimum() {
        return randomNumbers.get(0);
    }

    /*
     * This function will return the maximum value from the list of the random number
     */
    public Double maximum() {
        return randomNumbers.get(0);
    }

    /*
     * This function will return the mode value from the list of the random number
     */
    public Double mode() {
        return randomNumbers.get(0);
    }

    /*
     * This function will return the median value from the list of the random number
     */
    public Double median() {
        return randomNumbers.get(0);
    }

    /*
     * This function will return the arithmetic mean value of the list of the random number
     */
    public Double arithmeticMean() {
        return randomNumbers.get(0);
    }

    /*
     * This function will return the mean absolute deviation value of the list of the random number
     */
    public Double meanAbsoluteDeviation() {
        return randomNumbers.get(0);
    }

    /*
     * This function will return the standard deviation value of the list of the random number
     */
    public Double standardDeviation() {
        return randomNumbers.get(0);
    }

    /*
     * This function will load the data from the user input. Which is String.
     * and it will separate the string by splitting comma (,) convert the string into double
     * and storing into the  randomNumbers variable (Arraylist of double)
     */
    public void loadFromDisplay(String displayTxt) {
        String[] arrOfStr = displayTxt.split(",");
        for (String a : arrOfStr) {
            randomNumbers.add(Double.valueOf(a));
        }
    }

    /*
     * This function will load the data from the text file. Which is String.
     * and it will separate the string by splitting comma (,) convert the string into double
     * and storing into the "randomNumbers" variable (Arraylist of double)
     */
    public String loadFromTxt() throws IOException {
        InputStream in = getClass().getResourceAsStream("input.txt");
        BufferedReader input = new BufferedReader(new InputStreamReader(in));
        String line;
        String fullText ="";
        while ((line = input.readLine()) != null)
        {
            fullText = fullText+line+"/n";
            String[] arrOfStr = line.split(",");
            for (String a : arrOfStr) {
                randomNumbers.add(Double.valueOf(a));
            }
        }

        input.close();
        in.close();

        return fullText;
    }

    /*
     * This function will reset the values of the "randomNumbers" variable (Arraylist of double).
     * After running this function there will be no values inside the variable
     */
    public String reset() {
        randomNumbers.clear();

        return "";
    }

    public static double sqrt(double number) {
        double t;

        double squareRoot = number / 2;

        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);

        return squareRoot;
    }
}
