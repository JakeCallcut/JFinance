import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockMenu {

	private String apikey = "N3HAVJPBZH45MY3C";
	
	private static JLabel[] categories = {new JLabel("Technology"), new JLabel("Real Estate"), new JLabel("Finance"), new JLabel("Cryptocurrency")};
	private static JLabel[] tickers = new JLabel[40];
	
	private static JFrame frame = new JFrame();
	private static JPanel outPanel = new JPanel();
	private static JPanel topPanel = new JPanel();
	private static JPanel tickerPanel = new JPanel();
	private static JPanel bottomPanel = new JPanel();
	
	private static JLabel title = new JLabel("Stock Prices");
	private static JComboBox chooseTicker = new JComboBox(tickers);
	private static JButton addButton = new JButton("Add ticker to main menu");
	
	public StockMenu() {
		
		//config
		for (int i = 0; i < tickers.length; i++) {
			tickers[i] = new JLabel();
		}
		
		//layouts
		GridLayout tickerGrid = new GridLayout(11, 4);
		FlowLayout outerLayout = new FlowLayout();
		FlowLayout bottomLayout = new FlowLayout();
		outPanel.setLayout(outerLayout);
		tickerPanel.setLayout(tickerGrid);
		bottomPanel.setLayout(bottomLayout);
		
		//preferences
		
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
