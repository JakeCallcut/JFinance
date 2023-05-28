import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonReadableChannelException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class CurrencyConverter extends JFrame implements ActionListener{

	private double beforeAmt;
	private double afterAmt;
	private double rate;
	
	private String[] currencies = {"USD", "EUR", "GBP", "CAD", "AUD", "JPY", "MXN", "KRW", "INR", "RUB", "NZD"};
	
	private static JFrame frame = new JFrame();
	private static JPanel outPanel = new JPanel();
	private static JPanel topPanel = new JPanel();
	private static JPanel bottomPanel = new JPanel();
	
	private static JLabel title = new JLabel("Currency Converter");
	private static JLabel fromLabel = new JLabel("From:");
	private static JComboBox fromBox = new JComboBox();
	private static JLabel toLabel = new JLabel("To:");
	private static JComboBox toBox = new JComboBox();
	private static JLabel amountLabel = new JLabel("Amount:");
	private static JButton convertButton = new JButton("Convert");
	private static JLabel resultLabel = new JLabel("0 USD = 0 USD");
	private static JLabel updateLabel = new JLabel("Last checked:");
	
	public CurrencyConverter() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
