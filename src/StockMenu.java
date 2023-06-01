import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.JSONObject;

public class StockMenu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final static String apikey = "chshe89r01qr5oci0ukgchshe89r01qr5oci0ul0";
	
	private static JLabel[] categories = {new JLabel("Technology"), new JLabel("Real Estate"), new JLabel("Finance"), new JLabel("Pharmaceutical")};
	private static JLabel[] tickers = 
		{
			  new JLabel("AAPL"), new JLabel("PLD"), new JLabel("V"), new JLabel("LLY")
			, new JLabel("MSFT"), new JLabel("AMT"), new JLabel("JPM"), new JLabel("JNJ")
			, new JLabel("GOOG"), new JLabel("EQIX"), new JLabel("MA"), new JLabel("NVO")
			, new JLabel("AMZN"), new JLabel("PSA"), new JLabel("BAC"), new JLabel("MRK")
			, new JLabel("NVDA"), new JLabel("CCI"), new JLabel("WFC"), new JLabel("ABBV")
			, new JLabel("META"), new JLabel("SPG"), new JLabel("MS"), new JLabel("AZN")
			, new JLabel("TSLA"), new JLabel("WELL"), new JLabel("RY"), new JLabel("PFE")
			, new JLabel("AMD"), new JLabel("CSGP"), new JLabel("SPGI"), new JLabel("NVS")
			, new JLabel("BABA"), new JLabel("VICI"), new JLabel("HDB"), new JLabel("BMY")
			, new JLabel("ORCL"), new JLabel("DLR"), new JLabel("AXP"), new JLabel("SNY")
		};
	
	private static JFrame frame = new JFrame();
	private static JPanel outPanel = new JPanel();
	private static JPanel topPanel = new JPanel();
	private static JPanel tickerPanel = new JPanel();
	private static JPanel bottomPanel = new JPanel();
	
	private static JLabel title = new JLabel("Stock Prices");
	private static JLabel status = new JLabel("Last Update: ");
	private static JComboBox chooseTicker = new JComboBox();
	private static JButton addButton = new JButton("Add ticker to main menu");
	private static JButton updateButton = new JButton("Update Prices");
	
	public StockMenu() throws IOException {
		
		//config
		for (JLabel jLabel : tickers) {
			chooseTicker.addItem(jLabel.getText());
		}
		
		//layouts
		GridLayout tickerGrid = new GridLayout(11, 4);
		tickerGrid.setHgap(20);
		tickerGrid.setVgap(20);
		FlowLayout outerLayout = new FlowLayout();
		FlowLayout bottomLayout = new FlowLayout();
		outPanel.setLayout(outerLayout);
		tickerPanel.setLayout(tickerGrid);
		bottomPanel.setLayout(bottomLayout);
		
		//preferences
		Color darkOrange = new Color(186, 104, 4);
		outPanel.setBackground(Color.darkGray);
		topPanel.setBackground(Color.darkGray);
		tickerPanel.setBackground(Color.darkGray);
		bottomPanel.setBackground(Color.darkGray);
		tickerPanel.setForeground(Color.white);
		bottomPanel.setForeground(Color.white);
		outPanel.setForeground(Color.white);
		status.setForeground(darkOrange);
		title.setForeground(Color.orange);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 24));
		
		for (JLabel jLabel : categories) {
			jLabel.setForeground(darkOrange);
		}
		for (JLabel jLabel : tickers) {
			jLabel.setForeground(Color.white);
		}
		frame.setPreferredSize(new Dimension(510, 310));
		
		//listeners
		addButton.addActionListener(addListener);
		updateButton.addActionListener(updateListener);
		
		//adding to frame
		topPanel.add(title);
		topPanel.add(status);
		bottomPanel.add(chooseTicker);
		bottomPanel.add(addButton);
		bottomPanel.add(updateButton);
		for (JLabel iLabel : categories) {
			tickerPanel.add(iLabel);
		}
		for (JLabel jLabel : tickers) {
			tickerPanel.add(jLabel);
		}
		outPanel.add(topPanel);
		outPanel.add(tickerPanel);
		outPanel.add(bottomPanel);
		
		
		//running frame
		frame.add(outPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JFinance");
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
	}
	
	ActionListener addListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	ActionListener updateListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				UpdateTickers();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	public static void main(String[] args) throws IOException {
		
	}
	
	public static void UpdateTickers() throws IOException {
		String symbol;
		String apiurl;
		
		for (JLabel jLabel : tickers) {
			symbol = jLabel.getText();	
			URL url;
			
			try {
				url = new URL( "https://finnhub.io/api/v1/quote?symbol=" + symbol + "&token=" + apikey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
       
            JSONObject jsonResponse = new JSONObject(response.toString());     
            System.out.println(jsonResponse);
            double closePrice = jsonResponse.getDouble("c");
            System.out.println(jsonResponse);
            System.out.println(closePrice);
            
            jLabel.setText(symbol + " - " + closePrice);

            connection.disconnect();
			} catch (MalformedURLException e) {
				System.out.println("Invalid URL");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}











