import java.awt.Color;
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
//import org.json.JSONObject; //last edit trying to make location work


public class Menu extends JFrame implements ActionListener{
	
	private static JFrame frame = new JFrame();
	private static JPanel topPanel = new JPanel();
	private static JPanel panel = new JPanel();
	private static JLabel title = new JLabel("JFinance");
	private static JLabel time = new JLabel("00:00:00 UTC");
	private static JLabel time2 = new JLabel("00:00:00 UTC");
	private static JLabel date = new JLabel("0000/00/00");
	
	private static JButton interestButton = new JButton("Interest Calculator");
	private static JButton budgetButton = new JButton("Budget Manager");
	private static JButton currencyButton = new JButton("Currency Converter");
	private static JButton mortgageButton = new JButton("Mortgage Calculator");
	private static JButton exitButton = new JButton("Exit");

	
	public Menu() {
		
		GridLayout outerGrid = new GridLayout(2, 1);
		GridLayout grid = new GridLayout(5, 1);
		GridLayout topGrid = new GridLayout(4, 1);
		
		frame.setLayout(outerGrid);
	
		topPanel.setBackground(Color.darkGray);
		panel.setBackground(Color.gray);
		title.setForeground(Color.orange);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 24));
		time.setForeground(Color.white);
		date.setForeground(Color.white);
		
		panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		panel.setLayout(grid);
		topPanel.setLayout(topGrid);
		topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		exitButton.addActionListener(exitListener);
		interestButton.addActionListener(interestListener);
		budgetButton.addActionListener(budgetListener);
		currencyButton.addActionListener(currencyListener);
		mortgageButton.addActionListener(mortgageListener);
			
		topPanel.add(title);
		topPanel.add(time);
		topPanel.add(time2);
		topPanel.add(date);
		panel.add(interestButton);
		panel.add(budgetButton);
		panel.add(currencyButton);
		panel.add(mortgageButton);
		panel.add(exitButton);
		
		frame.add(topPanel);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Financial Toolkit");
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
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
			System.exit(0);
		}
	};
	
	ActionListener currencyListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	ActionListener mortgageListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
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

	                System.out.println(response.toString());
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




