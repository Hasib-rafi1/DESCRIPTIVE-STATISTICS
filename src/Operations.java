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
    public ArrayList<Double> mode() {
    	
        //The return type should be an arrayList, in case there are multiple numbers
    	//TODO Need to fix UI implementation as return type as ArrayList
    	
    	Map<Double,Integer> map = new HashMap<>(); 
    	ArrayList<Double> allMode = new ArrayList<>();
    	// storing all elements in hashMap (O(n))
    	for(double key:randomNumbers) {
    		if(!map.containsKey(key)) {
    			map.put(key, 1);
    		}else {
    			map.put(key, map.get(key)+1);
    		}	
    	}
    	
    	// getting the maximum Frequency
    	int maxFreq = 0;
    	for(int values: map.values()) {
    		if(maxFreq < values) {
    			maxFreq = values;
    		}
    	}
    	
    	// storing all the keys to arrayList having value as maxFreq
    	for(Double key:map.keySet()) {
    		if(map.get(key) == maxFreq) {
    			allMode.add(key);
    		}
    	}
    	
        return allMode;
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
    	//use this arrayList. the function is returning Xi - mean 
    	ArrayList<Double> x_minus_mean = getXValueMinusMean();
    	//check the standardDeviation function may be you can use the concept. 
    	//Use sqrt(Double num) function for the square root. 
        return randomNumbers.get(0);
    }

    /**
     * This function will return the standard deviation value of the list of the random number
     */
    public Double standardDeviation() {
    	ArrayList<Double> x_minus_mean = getXValueMinusMean();
    	Double sum = 0.0;
    	for (Double double1 : x_minus_mean) {
			Double squre = double1*double1;
			sum += squre;
		}
    	sum = sum/x_minus_mean.size();
    	sum = sqrt(sum);
        return sum;
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
     * and storing into the "randomNumbers" variable (ArrayList of double)
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
     * This function will reset the values of the "randomNumbers" variable (ArrayList of double).
     * After running this function there will be no values inside the variable
     */
    public String reset() {
        randomNumbers.clear();

        return "";
    }

    /**
     * This function is returning the square root of a value. 
     * @param number
     * @return
     */
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
    
    /**
     * This method is used in mean absolute deviation and standard deviation. it will return the each Xi values after subtracting
     * @return ArrayList of deviation 
     */
    private ArrayList<Double> getXValueMinusMean(){
    	ArrayList<Double> list = new ArrayList<Double>();
    	Double mean = arithmeticMean();
    	for (Double double1 : randomNumbers) {
			list.add(double1-mean);
		}

        return list;
    }
}
