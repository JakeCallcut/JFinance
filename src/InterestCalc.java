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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
    private static JLabel rateLabel = new JLabel("0%");
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
