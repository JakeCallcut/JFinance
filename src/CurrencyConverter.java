import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonReadableChannelException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class CurrencyConverter extends JFrame implements ActionListener{

	private double beforeAmt;
	private double afterAmt;
	private double rate;
	
	private static String[] currencies = {"USD", "EUR", "GBP", "CAD", "AUD", "JPY", "MXN", "KRW", "INR", "RUB", "NZD"};
	
	private static JFrame frame = new JFrame();
	private static JPanel outPanel = new JPanel();
	private static JPanel topPanel = new JPanel();
	private static JPanel bottomPanel = new JPanel();
	
	private static JLabel title = new JLabel("Currency Converter");
	private static JLabel fromLabel = new JLabel("From:");
	private static JComboBox fromBox = new JComboBox(currencies);
	private static JLabel toLabel = new JLabel("To:");
	private static JComboBox toBox = new JComboBox(currencies);
	private static JLabel amountLabel = new JLabel("Amount:");
	private static JTextField amountField = new JTextField(); 
	private static JButton convertButton = new JButton("Convert");
	private static JLabel resultLabel = new JLabel("0 USD = 0 USD");
	private static JLabel updateLabel = new JLabel("Last checked:");
	
	public CurrencyConverter() {
		
	    //layouts
		GridLayout outer = new GridLayout(3, 1);
		GridLayout topGrid =  new GridLayout(2, 2);
		FlowLayout bottomLayout = new FlowLayout();
		outPanel.setLayout(outer);
		topPanel.setLayout(topGrid);
		bottomPanel.setLayout(bottomLayout);
		
		//adding to frame
		outPanel.add(title);
		topPanel.add(fromLabel);
		topPanel.add(toLabel);
		topPanel.add(fromBox);
		topPanel.add(toBox);
		bottomPanel.add(amountLabel);
		bottomPanel.add(amountField);
		bottomPanel.add(convertButton);
		bottomPanel.add(resultLabel);
		bottomPanel.add(updateLabel);	
		outPanel.add(topPanel);
		outPanel.add(bottomPanel);
		
		//running frame
		frame.add(outPanel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("JFinance");
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
