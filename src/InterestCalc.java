import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.chrono.HijrahChronology;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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

	private static JFrame frame = new JFrame();
	private static JPanel topPanel = new JPanel();
	private static JPanel buttonPanel = new JPanel();	
	
	private static JLabel title = new JLabel("Interest Calculator");
    private static ButtonGroup group = new ButtonGroup();
    private static JRadioButton simpleButton = new JRadioButton("Simple Interest");
    private static JRadioButton complexButton = new JRadioButton("Complex Interest");	
    private static JSeparator hr = new JSeparator(SwingConstants.HORIZONTAL);
    private static JLabel initiaLabel = new JLabel("Initial Capital");
    private static JTextField capitalField = new JTextField(100);
    private static JLabel interestLabel = new JLabel("Interest Rate");
    private static JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
    private static JLabel rateLabel = new JLabel("5.0%");
    private static JLabel yearsLabel = new JLabel("Number of years invested");
    private static SpinnerNumberModel model = new SpinnerNumberModel(5, 0, 50, 1);
    private static JSpinner spinner = new JSpinner(model);
    //hr here
    private static JButton calcButton = new JButton("Calculate");
    private static JButton menuButton = new JButton("Back to Menu");
    
    public InterestCalc() {
		GridLayout outerGrid = new GridLayout(2, 1);
		GridLayout topGrid = new GridLayout(12, 1);
		GridLayout grid = new GridLayout(1, 2);
		
		frame.setLayout(outerGrid);
		topPanel.setLayout(topGrid);
		buttonPanel.setLayout(grid);
		
		//listeners
		slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                int value = source.getValue();
                rateLabel.setText(Double.toString(value/10.0) + "%");
            }
        });
		spinner.setEditor(new JSpinner.DefaultEditor(spinner) {
            public boolean isEditable() {
                return false;
            }
        });
		simpleButton.setSelected(true);
		
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
		
		buttonPanel.add(calcButton);
		buttonPanel.add(menuButton);
		
		frame.add(topPanel);
		frame.add(buttonPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JFinance");
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}













