import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

public class OperationsTest {


	Operations calc = new Operations();
    @Before
    public void setUp(){
        //This needs to be filled up.
    	String numbers = "12,18,90,10,6,35.5,16.4,120.3,10";
    	calc.loadFromDisplay(numbers);
    }

    @Test
    public void sortDataSet() {
    }

    @Test
    public void minimum() {
    	Double a = calc.minimum();
		Double b = 6.0;
		assertEquals(a,b);
    }

    @Test
    public void maximum() {
    	Double a = calc.maximum();
		Double b = 120.3;
		assertEquals(a,b);
    }

    @Test
    public void mode() {
    	ArrayList<Double> a = new ArrayList<>();
    	a.add(10.0);
    	ArrayList<Double> b = calc.mode();
     	assertEquals(b,a);
    }

    @Test
    public void median() {
    	Double a = calc.median();
		Double b = 16.4;
		assertEquals(a,b);
    }

    @Test
    public void arithmeticMean() {
    	Double a = calc.arithmeticMean();
		Double b = 35.35;
		assertEquals(a,b);
    }

    @Test
    public void meanAbsoluteDeviation() {
    	Double a = calc.meanAbsoluteDeviation();
		Double b = 31.04;
		assertEquals(a,b);
    }

    @Test
    public void standardDeviation() {
    	Double a = calc.standardDeviation();
		Double b = 38.8;
		assertEquals(a,b);
    }

    @Test
    public void loadFromTxt() {
    	calc.reset();
    	try {
			calc.loadFromTxt();
			ArrayList<Double> a = calc.getGeneratedList();
			assertEquals(a.size(),1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    public void loadFromRandom() {
    	calc.reset();
    	calc.loadFromRandom();
		ArrayList<Double> a = calc.getGeneratedList();
		assertEquals(a.size(),1000);
    }

    @Test
    public void reset() {
    	calc.reset();
		ArrayList<Double> a = calc.getGeneratedList();
		assertEquals(a.size(),0);
    }

    @Test
    public void sqrt() {
    	Double a = 4.0;
    	Double b = 2.0;
    	Double c = calc.sqrt(a);
    	assertEquals(c,b);
    }

    @Test
    public void ceil() {
    	assertEquals(calc.ceil(4.245),5);
    	
    }
}