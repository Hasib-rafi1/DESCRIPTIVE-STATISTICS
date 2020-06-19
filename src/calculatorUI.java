import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class calculatorUI implements ActionListener {

	// Initializing the GUI variables
	private final JFrame frame;
	private final JPanel panel;
	private final JPanel buttonPanel;
	private final JPanel numberPanel;
	private final JPanel sidePanel;
	private final JPanel operatorPanel;
	private final JPanel equalPanel;
	private final JPanel display;
	private final JTextArea text,result;
	private final JLabel label1;
	private final JLabel label2;
	private final JButton but[], butComma, butMean ,butMini, butMax, butMode, butMidian,
	butLoadTxt,butLoadRandom, butCancel,butDecimalSeparator,btnMad,butStdDaviation,butLoad;
	private final Operations calc;
	private final  JScrollPane sp;
	private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9"};

	/**
	 * This function is Building the UI of the application
	 */
	public calculatorUI() {
		frame = new JFrame("DESCRIPTIVE-STATISTICS");
		frame.setResizable(false);
		panel = new JPanel(new GridLayout(2,0));
		display = new JPanel(new GridLayout(4,0));
		buttonPanel = new JPanel(new GridLayout(0,2));
		numberPanel =new JPanel(new GridLayout(0,3));
		operatorPanel =new JPanel(new GridLayout(5,1));
		equalPanel = new JPanel(new GridLayout(0,1));
		sidePanel = new JPanel(new GridLayout(0,2));
		text = new JTextArea(2, 45);
		sp = new JScrollPane(text);
		result = new JTextArea(2, 45);
		label1 = new JLabel("Finite Random Data");
		label2 = new JLabel("Output");
		but = new JButton[10];
		for (int i = 0; i < 10; i++) {
			but[i] = new JButton(String.valueOf(i));
		}
		butComma = new JButton(",");
		butMean = new JButton("Arithmetic Mean (μ)");
		butMini = new JButton("Minimum");
		butMax = new JButton("Maximum");
		butMode = new JButton("Mode");
		butMidian = new JButton("Median");
		butLoadTxt = new JButton("Load From Text");
		btnMad = new JButton("Mean Absolute Deviation");
		butCancel = new JButton("Clear");
		butStdDaviation = new JButton("Standard Deviation (σ)");
		butLoad = new JButton("Load From Display");
		butDecimalSeparator = new JButton(".");
		butLoadRandom = new JButton("Random Generator");
		calc = new Operations();
	}

	/**
	 * This function is creating the block of the UI and setting them into the place.
	 */
	public void init() {
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		display.add(label1);
		display.add(sp);
		display.add(label2);
		display.add(result);
		panel.add(display);
		panel.add(buttonPanel);
		buttonPanel.add(numberPanel);
		buttonPanel.add(sidePanel);
		sidePanel.add(operatorPanel);
		sidePanel.add(equalPanel);

		for (int i = 1; i < 10; i++) {
			numberPanel.add(but[i]);
			but[i].addActionListener(this);

		}

		numberPanel.add(butComma);
		numberPanel.add(but[0]);
		but[0].addActionListener(this);
		numberPanel.add(butDecimalSeparator);


		operatorPanel.add(butMini);
		operatorPanel.add(butMax);
		operatorPanel.add(butMode);
		operatorPanel.add(butMidian);


		        
		operatorPanel.add(butMean);      
		equalPanel.add(btnMad);
		equalPanel.add(butStdDaviation);
		equalPanel.add(butLoad);
		equalPanel.add(butLoadTxt);
		equalPanel.add(butLoadRandom);
		equalPanel.add(butCancel);

		disableBtn();
		initial();
		butComma.addActionListener(this);
		butMean.addActionListener(this);
		butMini.addActionListener(this);
		butMax.addActionListener(this);
		butMode.addActionListener(this);
		butMidian.addActionListener(this);
		butDecimalSeparator.addActionListener(this);
		butLoadTxt.addActionListener(this);
		butCancel.addActionListener(this);
		btnMad.addActionListener(this);
		butLoad.addActionListener(this);
		butLoadRandom.addActionListener(this);
		butStdDaviation.addActionListener(this);

	}
	
	/**
	 * This function disables the buttons which are dependent on the different button.
	 */
	public void initial() {
		butComma.setEnabled(false);
		butLoad.setEnabled(false);
	}

	/**
	 * This function activates disable buttons based on different conditions from different places
	 */
	public void activeBtn() {
		btnMad.setEnabled(true);
		butStdDaviation.setEnabled(true);
		butMean.setEnabled(true);
		butMini.setEnabled(true);
		butMax.setEnabled(true);
		butMode.setEnabled(true);
		butMidian.setEnabled(true);
	}

	/**
	 * This function disables the activated buttons based on different conditions from different places
	 */
	public void disableBtn() {
		btnMad.setEnabled(false);
		butStdDaviation.setEnabled(false);
		butMean.setEnabled(false);
		butMini.setEnabled(false);
		butMax.setEnabled(false);
		butMode.setEnabled(false);
		butMidian.setEnabled(false);
	}

	/**
	 * This function is handling the events of the buttons and text area.
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();

		for (int i = 0; i < 10; i++) {
			if (source == but[i]) {
				text.replaceSelection(buttonValue[i]);

				butComma.setEnabled(true);
				butLoadTxt.setEnabled(false);
				butLoad.setEnabled(true);
				butLoadRandom.setEnabled(false);
				return;
			}
		}
		if (source == butComma) {
			text.replaceSelection(",");
			butComma.setEnabled(false);
			butDecimalSeparator.setEnabled(true);
			
			return;

		}
		if(source== butDecimalSeparator) {
			text.replaceSelection(".");
			butComma.setEnabled(false);
			butDecimalSeparator.setEnabled(false);
			return;
		}
		if (source == butMini) {
			resultShow(calc.minimum());

		}

		if (source == butMax) {
			resultShow(calc.maximum());
		}

		if (source == butMode) {
			resultShowMode(calc.mode().toString());
		}

		if (source == butMidian) {
			resultShow(calc.median());
		}
		if (source == butMean) {
			resultShow(calc.arithmeticMean());
		}

		if(source == btnMad) {
			resultShow(calc.meanAbsoluteDeviation());
		} 
		if (source == butStdDaviation) {
			resultShow(calc.standardDeviation());
		}
		
		if (source == butLoad) {
			calc.loadFromDisplay(reader());
			activeBtn();
			butLoad.setEnabled(false);
			deactivateNumber();
			butComma.setEnabled(false);
			butDecimalSeparator.setEnabled(false);
			butLoadRandom.setEnabled(false);
			
			
		}

		if (source == butLoadTxt) {
			try {
				writer(calc.loadFromTxt());
				activeBtn();
				deactivateNumber();
				butLoadTxt.setEnabled(false);
				butComma.setEnabled(false);
				butDecimalSeparator.setEnabled(false);
				butLoadRandom.setEnabled(false);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frame, "Input File is not found");
			}
			
		}
		
		if (source == butLoadRandom) {
			writer(calc.loadFromRandom());
			activeBtn();
			deactivateNumber();
			butLoadTxt.setEnabled(false);
			butComma.setEnabled(false);
			butDecimalSeparator.setEnabled(false);
			butLoadRandom.setEnabled(false);	
			
		}
		
		if (source == butCancel) {
			writer(calc.reset());
			resultShow(Double.NaN);
			butComma.setEnabled(true);
			butDecimalSeparator.setEnabled(true);
			butLoadTxt.setEnabled(true);
			butLoadRandom.setEnabled(true);
			disableBtn();
			initial();
			for (int i = 0; i < 10; i++) {
				but[i].setEnabled(true);
			}
		}

		text.selectAll();
	}

	/**
	 * This function deactivated the numbers button when it is not needed. 
	 */
	public void deactivateNumber() {
		for (int i = 0; i < 10; i++) {
			but[i].setEnabled(false);
		}
	}

	/**
	 * Read the string from the display
	 * @return returns the string from the display
	 */
	public String reader() {
		
		String str;
		str = text.getText();

		return str;
	}

	/**
	 * Write the string in the display
	 * @param display The text presented on the Display
	 */
	public void writer(String display) {
		
			text.setText(display);
	}

	/**
	 * Write the output in the result section
	 * @param num The operation result to be displayed
	 */
	public void resultShow(final Double num) {
		if (Double.isNaN(num)) {
			result.setText("");
		} else {
			result.setText(Double.toString(num));
		}
	}

	/**
	 * Write the mode output in the result section
	 * @param num The string containing the mode value(s)
	 */
	public void resultShowMode(final String num) {
	
			result.setText(num);
	}
}
