import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalculatorFrame extends JFrame implements ActionListener {
	
	int FRAME_WIDTH = 420;
	int FRAME_HEIGHT = 550;	
	JPanel panel;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	Font myFont = new Font("Ink Free",Font.BOLD,30);
	String currentOp;
	int ind; 
	double num1;
	double num2; 
	double currentAns; 
	
	
	CalculatorFrame() {
		
		this.setTitle("Calculator"); //sets title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
		this.setResizable(false); //resize 
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT); //sets x and y dimension of frame 
		this.setLayout(null);
        
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		this.add(panel);
		this.add(negButton);
		this.add(delButton);
		this.add(clrButton);
		this.add(textfield);
		this.setVisible(true);
		
    }
	
	public void calculate() { 
		
		num2 = Double.parseDouble(String.valueOf(textfield.getText()));
		
		switch(currentOp) { 
		case "+": 
			currentAns = num1 + num2;
			break;
		case "-": 
			currentAns = num1 - num2;
			break;
		case "*": 
			currentAns = num1 * num2;
			break;
		case "/": 
			currentAns = num1 / num2;
			break;
		}
		DecimalFormat decimalFormat = new DecimalFormat("#.000");
		currentAns = Double.parseDouble(decimalFormat.format(currentAns));
		textfield.setText(String.valueOf(currentAns));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i =0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == addButton || e.getSource() == subButton || e.getSource() == mulButton || e.getSource() == divButton) {
		    String input = textfield.getText();
		    if (!input.isEmpty()) {
		        num1 = Double.parseDouble(input);
		        currentOp = e.getActionCommand();
		        textfield.setText("");
		    }
		}
		if(e.getSource() == clrButton) { 
			textfield.setText("");
		}
		if(e.getSource() == delButton) { 
			String currentText = textfield.getText();
	        if (!currentText.isEmpty()) {
	            textfield.setText(currentText.substring(0, currentText.length() - 1));
	        }
		}
		if(e.getSource() == equButton) { 
			calculate();
		}
		if(e.getSource() == decButton) { 
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == negButton) {
			textfield.setText(textfield.getText().concat("-"));
		}
	}

}
