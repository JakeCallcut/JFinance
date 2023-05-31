import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockMenu {

	private String apikey = "N3HAVJPBZH45MY3C";
	
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
	private static JComboBox chooseTicker = new JComboBox();
	private static JButton addButton = new JButton("Add ticker to main menu");
	
	public StockMenu() {
		
		//config
		for (JLabel jLabel : tickers) {
			chooseTicker.addItem(jLabel.getText());
		}
		
		//layouts
		GridLayout tickerGrid = new GridLayout(11, 4);
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
		
		//adding to frame
		topPanel.add(title);
		bottomPanel.add(chooseTicker);
		bottomPanel.add(addButton);
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
	
	public static void main(String[] args) throws FileNotFoundException {
	
	}
	
}
