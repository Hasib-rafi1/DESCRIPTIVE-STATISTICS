import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Operations {
    private ArrayList<Double> randomNumbers = new ArrayList<>(); // random number storage variable
    private ArrayList<Double> sortedDataSet = new ArrayList<>(); // ascending sorted data set
    //private Map<Double, Integer> valueFrequency = new HashMap<Double, Integer>(); // stores data set keys and the occurrence of each
    //private ArrayList<Double> frequentValues = new ArrayList<Double>(); // contains the most frequent values

    public void sortDataSet(){
        System.out.println("Sorted");
        sortedDataSet = sort(randomNumbers);
    }


    /**
     * This function will return the minimum value from the list of the random number
     * @return The minimum value of the dataset
     */
    public Double minimum() {
        if(sortedDataSet.isEmpty()){
            sortDataSet();
        }

        return sortedDataSet.get(0);
    }

    /**
     * This function will return the maximum value from the list of the random number
     * @return The maximum value of the dataset
     */
    public Double maximum() {
        if(sortedDataSet.isEmpty()){
            sortDataSet();
        }

        return sortedDataSet.get(sortedDataSet.size() - 1);
    }

    /**
     * This function will return the mode value from the list of the random number
     * @return The most frequent values in the dataset
     */
    public Double mode() {
        //The return type should be an arraylist, in case there are multiple numbers
        //Need to fix UI implementation


//        for(int i = 0; i < randomNumbers.size(); i++){
//            if(!valueFrequency.containsKey(randomNumbers.get(i))){
//                valueFrequency.put(randomNumbers.get(i), 1);
//            }else{
//                int count = valueFrequency.get(randomNumbers.get(i));
//                valueFrequency.put(randomNumbers.get(i), count + 1);
//            }
//        }
//
//        int count = 0;
//        int maxValue = 0;
//
//        ArrayList<Integer> mapValues = new ArrayList<Integer>(valueFrequency.values());
//
//        for(int i = 0; i < mapValues.size(); i++){
//            if (mapValues.get(i) > maxValue){
//                maxValue = mapValues.get(i);
//            }
//        }
//
//        for(Map.Entry<Double, Integer> val : valueFrequency.entrySet())
//        {
//            if (val.getValue() == maxValue)
//            {
//                frequentValues.add(val.getKey());
//            }
//        }
//
//        System.out.println(frequentValues);
//       // return frequentValues;
//
        return randomNumbers.get(0);
    }

    /**
     * This function will return the median value from the list of the random number
     * @return
     */
    public Double median() {
//        if(sortedDataSet.size() % 2 == 0){
//
//            // To implement if dataset is even - Arithmetic Mean
//
//        }else{
//            return sortedDataSet.get(sortedDataSet.size()/2);
//        }
        return randomNumbers.get(0);
    }

    /**
     * This function will return the arithmetic mean value of the list of the random number
     * @return am as the arithmetic mean value
     */
    public Double arithmeticMean() {
    	Double am, sum = 0.0; //initialize arithmetic mean value and sum value
    	
        //iterate through the data and calculate the sum
    	for (Double x : randomNumbers) {
    		sum += x;
    	}
    	
    	am =  sum/randomNumbers.size(); //calculate the arithmetic mean value
    	return am;
    }

    /**
     * This function will return the mean absolute deviation value of the list of the random number
     */
    public Double meanAbsoluteDeviation() {
        return randomNumbers.get(0);
    }

    /**
     * This function will return the standard deviation value of the list of the random number
     */
    public Double standardDeviation() {
        return randomNumbers.get(0);
    }

    /**
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

    /**
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

    /**
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

    /**
     * This method sorts dataset.
     * @param input the dataset
     * @return the sort dataset
     */
    private ArrayList<Double> sort(ArrayList<Double> input){

        if(input.size() <= 1){
            return input;
        }

        int middle = (int) ceil((double)input.size() / 2);
        double pivot = input.get(middle);

        ArrayList<Double> low = new ArrayList<Double>();
        ArrayList<Double> high = new ArrayList<Double>();

        for (int i = 0; i < input.size(); i++) {
            if(input.get(i) <= pivot){
                if(i == middle){
                    continue;
                }
                low.add(input.get(i));
            }
            else{
                high.add(input.get(i));
            }
        }

        return concatenate(sort(low), pivot, sort(high));
    }

    /**
     * This function returns the ceiling of a number
     * @param num The given number to get the ceiling
     * @return The ceiling of the number
     */
    int ceil(double num) {
        int inum = (int)num;
        if (num == (float)inum) {
            return inum;
        }
        return inum + 1;
    }

    /**
     * Concatenate both arrays
     * @param low ArrayList with values lower than the pivot.
     * @param pivot The pivot
     * @param high ArrayList with values higher than the pivot.
     * @return The sorted ArrayList
     */
    private ArrayList<Double> concatenate(ArrayList<Double> low, double pivot, ArrayList<Double> high){

        ArrayList<Double> list = new ArrayList<Double>();

        for (int i = 0; i < low.size(); i++) {
            list.add(low.get(i));
        }

        list.add(pivot);

        for (int i = 0; i < high.size(); i++) {
            list.add(high.get(i));
        }

        return list;
    }
}
