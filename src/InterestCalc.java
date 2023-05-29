import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InterestCalc extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static double rate;
	
	private static JFrame frame = new JFrame();
	private static JPanel outPanel = new JPanel();
	private static JPanel topPanel = new JPanel();
	private static JPanel buttonPanel = new JPanel();	
	
	private static JLabel title = new JLabel("Interest Calculator");
    private static ButtonGroup group = new ButtonGroup();
    private static JRadioButton simpleButton = new JRadioButton("Simple Interest");
    private static JRadioButton complexButton = new JRadioButton("Compound Interest");	
    private static JSeparator hr = new JSeparator(SwingConstants.HORIZONTAL);
    private static JLabel initiaLabel = new JLabel("Initial Capital");
    private static JTextField capitalField = new JTextField(100);
    private static JLabel interestLabel = new JLabel("Interest Rate");
    private static JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
    private static JLabel rateLabel = new JLabel("5.0%");
    private static JLabel yearsLabel = new JLabel("Number of years invested");
    private static SpinnerNumberModel model = new SpinnerNumberModel(5, 0, 50, 1);
    private static JSpinner spinner = new JSpinner(model);
    private static JSeparator hr2 = new JSeparator(SwingConstants.HORIZONTAL);
    private static JLabel returnLabel = new JLabel("Return: 0");
    private static JLabel resultLabel = new JLabel("Final Capital: 0");
    private static JButton calcButton = new JButton("Calculate");
    private static JButton menuButton = new JButton("Back to Menu");
    
    public InterestCalc() {
		FlowLayout outerGrid = new FlowLayout();
		GridLayout topGrid = new GridLayout(14, 1);
		FlowLayout grid = new FlowLayout();
		
		outPanel.setLayout(outerGrid);
		topPanel.setLayout(topGrid);
		buttonPanel.setLayout(grid);
		
		calcButton.addActionListener(calcListener);
		menuButton.addActionListener(exitListener);
		slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                double value = source.getValue();
                rate = (value/1000);
                rateLabel.setText(Double.toString(value/10.0) + "%");
            }
        });
		spinner.setEditor(new JSpinner.DefaultEditor(spinner) {
            public boolean isEditable() {
                return false;
            }
        });
		
		simpleButton.setSelected(true);
		topPanel.setBackground(Color.darkGray);
		buttonPanel.setBackground(Color.darkGray);
		title.setForeground(Color.orange);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 24));
		simpleButton.setForeground(Color.white);
		complexButton.setForeground(Color.white);
		hr.setForeground(Color.white);
		initiaLabel.setForeground(Color.white);
		capitalField.setBackground(Color.gray);
		capitalField.setForeground(Color.white);
		interestLabel.setForeground(Color.white);
		slider.setForeground(Color.white);
		rateLabel.setForeground(Color.white);
		yearsLabel.setForeground(Color.white);
		spinner.setBackground(Color.gray);
		spinner.setForeground(Color.gray);
		hr2.setForeground(Color.white);
		returnLabel.setForeground(Color.orange);
		resultLabel.setForeground(Color.orange);
		
		group.add(simpleButton);
		group.add(complexButton);
		
		topPanel.add(title);
		topPanel.add(simpleButton);
		topPanel.add(complexButton);
		topPanel.add(hr);
		topPanel.add(initiaLabel);
		topPanel.add(capitalField);
		topPanel.add(interestLabel);
		topPanel.add(slider);
		topPanel.add(rateLabel);
		topPanel.add(yearsLabel);
		topPanel.add(spinner);
		topPanel.add(hr2);
		topPanel.add(returnLabel);
		topPanel.add(resultLabel);
		
		outPanel.setBackground(Color.darkGray);
		frame.setPreferredSize(new Dimension(350, 600));
		topPanel.setPreferredSize(new Dimension(300, 450));
		calcButton.setPreferredSize(new Dimension(150, 75));
		menuButton.setPreferredSize(new Dimension(100, 60));
		
		buttonPanel.add(calcButton);
		buttonPanel.add(menuButton);
		outPanel.add(topPanel);
		outPanel.add(buttonPanel);
		frame.add(outPanel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("JFinance");
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		
    }
    
	ActionListener calcListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				spinner.commitEdit();
			} catch (ParseException e1) {
				e1.printStackTrace();
				System.out.println("spinner error");
			}
			
			boolean isSimple;
				
			if (simpleButton.isSelected()) {
					
				isSimple = true;
				
			}
				
			else {
				isSimple = false;			
			}
			
			try {
				double initial = Double.valueOf(capitalField.getText());				
			} catch (NumberFormatException e2) {
				title.setText("Please enter a ");
			}
			
			double initial = Double.valueOf(capitalField.getText());
			double noofYears = (Integer) spinner.getValue(); 
			double result = 0.0;
			double myreturn = 0.0;
			
			if (isSimple) {
				myreturn = initial * noofYears * rate;
				result = initial + myreturn;
			}
			else {
				myreturn = initial * Math.pow(1 + rate, noofYears) - initial;
				result = initial + myreturn;
			}

			returnLabel.setText("Return: " + myreturn);
			resultLabel.setText("Final Capital: " + result);
		}
	};
	
	ActionListener exitListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}













