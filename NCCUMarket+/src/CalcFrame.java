import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CalcFrame extends JFrame {
	private JButton btnEqual;
	private JTextField textFieldA, textFieldB;
	private JRadioButton rbtnAdd, rbtnSub, rbtnMul, rbtnDiv;
	private JTextArea outputArea;
	
	private String op;

//constructor
	public CalcFrame() {

		outputArea = new JTextArea(8, 12);
		outputArea.setEditable(false);
		createTextField();
		createButton();
		createRbtn();
		createLayout();
		setSize(600, 200);
	}

	private void createTextField() {
// Here is your code //兩個
		textFieldA = new JTextField(10);
		textFieldB = new JTextField(10);
	}

	private void createRbtn() {
// Here is your code /四個家重 嘉進group
		rbtnAdd = new JRadioButton("+");
		
		rbtnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        op = "+";
		    }
		});
		
		rbtnSub = new JRadioButton("-");
		rbtnSub.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        op = "-";
		    }
		});
		
		rbtnMul = new JRadioButton("*");
		rbtnMul.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        op = "*";
		    }
		});
		
		rbtnDiv = new JRadioButton("/");
		rbtnDiv.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        op = "/";
		    }
		});
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnAdd);
		group.add(rbtnSub);
		group.add(rbtnMul);
		group.add(rbtnDiv);
		
	}

	private void createButton() {
		btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	double a = Double.parseDouble(textFieldA.getText());
		    	double b = Double.parseDouble(textFieldB.getText());
		    	
		    	String formula = getResult(a, op, b);
		    	outputArea.append(formula + "\n");
		    }
		});
	}

	private String getResult(double a, String op, double b) {
		
		 switch (op) {
	        case "+":
	            return String.format("%.2f + %.2f = %.2f", a, b, a + b);
	        case "-":
	            return String.format("%.2f - %.2f = %.2f", a, b, a - b);
	        case "*":
	            return String.format("%.2f * %.2f = %.2f", a, b, a * b);
	        case "/":
	            if (b == 0) return "除以 0 錯誤";
	            return String.format("%.2f / %.2f = %.2f", a, b, a / b);
	        default:
	            return "未知運算子";
	    }
		
	}

	private void createLayout() {
		JPanel flow_panel = new JPanel();
		JPanel rbtn_panel = new JPanel(new GridLayout(4, 1));
		rbtn_panel.add(this.rbtnAdd);
		rbtn_panel.add(this.rbtnSub);
		rbtn_panel.add(this.rbtnMul);
		rbtn_panel.add(this.rbtnDiv);
		flow_panel.add(this.textFieldA);
		flow_panel.add(rbtn_panel);
		flow_panel.add(this.textFieldB);
		flow_panel.add(this.btnEqual);
		flow_panel.add(new JScrollPane(outputArea));
		add(flow_panel);
	}
}