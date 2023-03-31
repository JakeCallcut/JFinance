import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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
	private static JPanel panel = new JPanel();
	private static JLabel title = new JLabel("JFinance");
	
	private static JButton interestButton = new JButton("Interest Calculator");
	private static JButton budgetButton = new JButton("Budget Manager");
	private static JButton currencyButton = new JButton("Currency Converter");
	private static JButton mortgageButton = new JButton("Mortgage Calculator");
	private static JButton exitButton = new JButton("Exit");

	
	public Menu() {
		GridLayout grid = new GridLayout(6, 1);

		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));
		panel.setLayout(grid);
		
		panel.add(title);
		panel.add(interestButton);
		panel.add(budgetButton);
		panel.add(currencyButton);
		panel.add(mortgageButton);
		panel.add(exitButton);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Financial Toolkit");
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new Menu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}




