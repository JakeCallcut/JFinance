import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

/**
 * @author Jake Callcut
 */

public class Menu extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private static JFrame frame = new JFrame();
	private static JPanel topPanel = new JPanel();
	private static JPanel panel = new JPanel();
	private static JLabel title = new JLabel("JFinance");
	private static JLabel menuLabel = new JLabel("Main Menu");
	private static JLabel time = new JLabel("00:00:00 UTC");
	private static JLabel location = new JLabel("Location Not Found");
	private static JLabel date = new JLabel("0000/00/00");
	
	private static JButton interestButton = new JButton("Interest Calculator");
	private static JButton budgetButton = new JButton("Budget Manager");
	private static JButton currencyButton = new JButton("Currency Converter");
	private static JButton stockButton = new JButton("Live Stock Prices");
	private static JButton exitButton = new JButton("Exit");
	
	public Menu() {
		
		//layouts
		GridLayout outerGrid = new GridLayout(2, 1);
		GridLayout grid = new GridLayout(5, 1); 
		GridLayout topGrid = new GridLayout(5, 1);		
		frame.setLayout(outerGrid);
		panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		panel.setLayout(grid);
		topPanel.setLayout(topGrid);
		topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
	
		//preferences
		Color darkOrange = new Color(186, 104, 4);
		frame.setBackground(Color.darkGray);
		topPanel.setBackground(Color.darkGray);
		panel.setBackground(Color.darkGray);
		title.setForeground(darkOrange);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 24));
		menuLabel.setForeground(Color.orange);
		menuLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 16));
		time.setForeground(Color.white);
		date.setForeground(Color.white);
		location.setForeground(Color.white);
		frame.setPreferredSize(new Dimension(222, 350));
		
		//listeners
		exitButton.addActionListener(exitListener);
		interestButton.addActionListener(interestListener);
		budgetButton.addActionListener(budgetListener);
		currencyButton.addActionListener(currencyListener);
		stockButton.addActionListener(stockListener);
			
		//adding to frame
		topPanel.add(title);
		topPanel.add(menuLabel);
		topPanel.add(time);
		topPanel.add(date);
		topPanel.add(location);
		panel.add(interestButton);
		panel.add(budgetButton);
		panel.add(currencyButton);
		panel.add(stockButton);
		panel.add(exitButton);
		
		//running frame
		frame.add(topPanel);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Financial Toolkit");
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	ActionListener exitListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	ActionListener interestListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new InterestCalc();
		}
	};
	
	ActionListener budgetListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new BudgetManager();
		}
	};
	
	ActionListener currencyListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new CurrencyConverter();
		}
	};
	
	ActionListener stockListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				new StockMenu();
		}
	};
	
	public static void main(String[] args) throws FileNotFoundException {
		new Menu();
		
		 try {
	            String url = "http://ip-api.com/json/";

	            // Open a connection to the IP-API endpoint
	            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	            connection.setRequestMethod("GET");

	            // Get the response code
	            int responseCode = connection.getResponseCode();

	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                // Read the response
	                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String line;
	                StringBuilder response = new StringBuilder();
	                while ((line = reader.readLine()) != null) {
	                    response.append(line);
	                }
	                reader.close();

	                JSONObject jsonResponse = new JSONObject(response.toString());
	                location.setText(jsonResponse.getString("city") + ", " + jsonResponse.getString("country"));
	                System.out.println(response);
	                
	            } else {
	                System.out.println("Error: " + responseCode);
	            }

	            connection.disconnect();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
        while (true) {
            Calendar now = Calendar.getInstance();
            int hours = now.get(Calendar.HOUR_OF_DAY);
            int minutes = now.get(Calendar.MINUTE);
            int seconds = now.get(Calendar.SECOND);
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH) + 1;
            int day = now.get(Calendar.DAY_OF_MONTH);
            time.setText(hours + ":" + minutes + ":" + seconds + " UTC");
            date.setText(year + "/" + (month + 1) + "/" + day);
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}




