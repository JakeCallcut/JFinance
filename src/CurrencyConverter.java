import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONObject;

public class CurrencyConverter extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final String apikey = "e0cbabd4d96860dcf76e979b";
	
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
		
		//preferences
		frame.setPreferredSize(new Dimension(360, 300));
		outPanel.setBackground(Color.darkGray);
		topPanel.setBackground(Color.darkGray);
		bottomPanel.setBackground(Color.darkGray);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 24));
		title.setForeground(Color.orange);
		fromLabel.setForeground(Color.white);
		fromLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 16));
		toLabel.setForeground(Color.white);
		toLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 16));
		amountLabel.setForeground(Color.white);
		resultLabel.setForeground(Color.orange);
		resultLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 16));
		updateLabel.setForeground(Color.orange);
		updateLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 16));
		amountField.setBackground(Color.gray);
		amountField.setForeground(Color.white);
		amountField.setPreferredSize(new Dimension(100, 20));
		
		//listeners
		convertButton.addActionListener(convertListener);
		
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
		frame.setResizable(false);
	}
	
	ActionListener convertListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String baseCurrency = (String)fromBox.getSelectedItem();
				String targetCurrency = (String)toBox.getSelectedItem();
				double baseAmount = Double.parseDouble(amountField.getText());
				double targetAmount;
			
				
				URL url = new URL("https://v6.exchangerate-api.com/v6/" + apikey + "/latest/" + baseCurrency);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				
				connection.setRequestMethod("GET");
				int responseCode = connection.getResponseCode();
				
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                StringBuilder response = new StringBuilder();
	                String line;

	                while ((line = reader.readLine()) != null) {
	                	response.append(line);
	                }
	                reader.close();

	                System.out.println(response);
	                JSONObject json = new JSONObject(response.toString());
	                String check = (String)json.get("time_last_update_utc");
	                check = check.substring(0, check.length() - 6);
	                JSONObject rates = json.getJSONObject("conversion_rates");
	                double exchangeRate = rates.getDouble(targetCurrency);
	                System.out.println("Exchange rate: 1 " + baseCurrency + " = " + exchangeRate + " " + targetCurrency);
	                
	                targetAmount = baseAmount * exchangeRate;
	                
	                resultLabel.setText(MessageFormat.format("{0} {1} = {2} {3}", baseAmount, baseCurrency, targetAmount, targetCurrency));
	                updateLabel.setText("Last checked: " + check);

	            } else {
	                System.out.println("HTTP request failed with response code: " + responseCode);
	            }

	            connection.disconnect();
				
			} catch (MalformedURLException e1) {
				System.out.println("Invalid URL");
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("Cannot establish connection");
				e1.printStackTrace();
			} catch (NumberFormatException e1) {
				amountField.setText("");
			}
			
			
		}
	};

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
