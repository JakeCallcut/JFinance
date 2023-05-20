import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JFrame implements ActionListener{
	
	private static JFrame frame = new JFrame();
	private static JPanel topPanel = new JPanel();
	private static JPanel timePanel = new JPanel();
	private static JPanel panel = new JPanel();
	private static JLabel title = new JLabel("JFinance");
	private static JLabel time = new JLabel("00:00:00 UTC");
	private static JLabel date = new JLabel("0000/00/00");
	
	private static JButton interestButton = new JButton("Interest Calculator");
	private static JButton budgetButton = new JButton("Budget Manager");
	private static JButton currencyButton = new JButton("Currency Converter");
	private static JButton mortgageButton = new JButton("Mortgage Calculator");
	private static JButton exitButton = new JButton("Exit");

	
	public Menu() {
		GridLayout timeGrid = new GridLayout(2, 1);
		GridLayout outerGrid = new GridLayout(2, 1);
		GridLayout grid = new GridLayout(5, 1);
		GridLayout topGrid = new GridLayout(1, 2);

		timeGrid.setVgap(0);
		
		frame.setLayout(outerGrid);
		
		timePanel.setLayout(timeGrid);
		panel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
		panel.setLayout(grid);
		panel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
		topPanel.setLayout(topGrid);
		topPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
		
		exitButton.addActionListener(exitListener);
		interestButton.addActionListener(interestListener);
		budgetButton.addActionListener(budgetListener);
		currencyButton.addActionListener(currencyListener);
		mortgageButton.addActionListener(mortgageListener);
		
		topPanel.add(title);
		timePanel.add(time);
		timePanel.add(date);
		topPanel.add(timePanel);
		panel.add(interestButton);
		panel.add(budgetButton);
		panel.add(currencyButton);
		panel.add(mortgageButton);
		panel.add(exitButton);
		
		panel.setBackground(Color.blue);
		topPanel.setBackground(Color.gray);
		timePanel.setBackground(Color.red);
		
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




