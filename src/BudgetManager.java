import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.security.PublicKey;
import java.security.KeyStore.PrivateKeyEntry;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BudgetManager extends JFrame implements ActionListener{

	public static double budget = 0;
	
	private static JFrame frame = new JFrame();
	private static JPanel outPanel = new JPanel();
	private static JPanel leftPanel = new JPanel();
	private static JPanel rightPanel = new JPanel();	
	
	private static JLabel title = new JLabel("Budget Manager");
	private static JTextArea textArea = new JTextArea();
	private static JLabel itemNameLabel = new JLabel("Item Name:");
	private static JTextField itemName = new JTextField();
	private static JLabel itemPriceLabel = new JLabel("Item Price:");
	private static JTextField itemPrice = new JTextField();
	
	private static JButton addButton = new JButton("Add Item");
	private static JButton exitButton = new JButton("Back to Menu");
	
	private static JLabel padding = new JLabel();
	private static JTextField budgetField = new JTextField("Enter Budget");
	private static JButton setBudget = new JButton("Set Budget");
	
	public BudgetManager() {
		GridLayout outer = new GridLayout(1, 2);
		FlowLayout leftLayout = new FlowLayout();
		FlowLayout rightLayout = new FlowLayout();
		
		outPanel.setLayout(outer);
		leftPanel.setLayout(leftLayout);
		rightPanel.setLayout(rightLayout);
		rightPanel.setBorder(new EmptyBorder(30, 0, 0, 0));
		
		textArea.setEditable(false);
		outPanel.setPreferredSize(new Dimension(660, 460));
		textArea.setPreferredSize(new Dimension(300, 400));
		addButton.setPreferredSize(new Dimension(250, 50));
		exitButton.setPreferredSize(new Dimension(250, 50));
		itemName.setPreferredSize(new Dimension(250, 50));
		itemPrice.setPreferredSize(new Dimension(250, 50));
		outPanel.setBackground(Color.darkGray);
		leftPanel.setBackground(Color.darkGray);
		rightPanel.setBackground(Color.darkGray);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 24));
		title.setForeground(Color.orange);
		textArea.setBackground(Color.gray);
		textArea.setForeground(Color.white);
		itemName.setBackground(Color.gray);
		itemName.setForeground(Color.white);
		itemPrice.setBackground(Color.gray);
		itemPrice.setForeground(Color.white);
		itemNameLabel.setForeground(Color.white);
		itemNameLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 16));
		itemPriceLabel.setForeground(Color.white);
		itemPriceLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 16));
		budgetField.setBackground(Color.gray);
		budgetField.setForeground(Color.white);
		budgetField.addFocusListener(focusListener);
		
		padding.setPreferredSize(new Dimension(0, 100));
		budgetField.setPreferredSize(new Dimension(100, 20));
		
		leftPanel.add(title);
		leftPanel.add(textArea);
		rightPanel.add(itemNameLabel);
		rightPanel.add(itemName);
		rightPanel.add(itemPriceLabel);
		rightPanel.add(itemPrice);
		rightPanel.add(addButton);
		rightPanel.add(exitButton);
		rightPanel.add(budgetField);
		rightPanel.add(padding);
		rightPanel.add(setBudget);
		
		outPanel.add(leftPanel);
		outPanel.add(rightPanel);
		frame.add(outPanel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("JFinance");
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
	}
	
	FocusListener focusListener = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
            if (budgetField.getText().equals("")) {
                budgetField.setText("Enter Budget");
            }
		}
		
		@Override
		public void focusGained(FocusEvent e) {
            if (budgetField.getText().equals("Enter Budget")) {
                budgetField.setText("");
            }
		}
	};
	
	ActionListener exitListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};
	
	ActionListener addListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
