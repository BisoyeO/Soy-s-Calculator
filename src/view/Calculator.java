package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controls.Controller;

import panels.NumberPanel;

public class Calculator extends JFrame{
	
	private NumberPanel numbers;
	private Controller controls;
	
	private JButton dec = new JButton(".");
	private JButton clear = new JButton("c");
	private JButton mul = new JButton("*");
	private JButton div = new JButton("/");
	private JButton add = new JButton("+");
	private JButton sub = new JButton("-");
	private JButton equ = new JButton("=");
	private JButton sin = new JButton("sin");
	private JButton cos = new JButton("cos");
	private JButton tan = new JButton("tan");
	private JButton era = new JButton("<");

	private JTextField ans = new JTextField(20);
	int a1, b1, c1;

	// create Frame
	public Calculator() {
		super("Calculator");
		// Declare Container
		Container c = getContentPane();
		// set Layout
		c.setLayout(new FlowLayout());
		
		/////////////////////////////////////////
		controls = new Controller(this);
		numbers = new NumberPanel();
		numbers.addListeners(controls);
		/////////////////////////////////////////
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 4));
		p2.add(ans);
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(4, 1));
		JPanel p4 = new JPanel();
		p4.setBackground(Color.red);
		p4.add(era);
		// p3.add(p1,BorderLayout.CENTER);
		p3.add(div);
		p3.add(mul);
		p3.add(sub);
		p3.add(add);
		p3.add(equ);
		p3.add(sin);
		p3.add(cos);
		p3.add(tan);
		// add component
		c.add(p2, BorderLayout.NORTH);
		c.add(p4, BorderLayout.NORTH);
		c.add(numbers, BorderLayout.WEST);
		c.add(p3, BorderLayout.SOUTH);
		c.setBackground(Color.red);
		ans.setEditable(false);
		// textsum.setText(c1);

		// listener
		ans.addActionListener(controls);
		dec.addActionListener(controls);
		clear.addActionListener(controls);
		add.addActionListener(controls);
		sub.addActionListener(controls);
		div.addActionListener(controls);
		mul.addActionListener(controls);
		equ.addActionListener(controls);
		sin.addActionListener(controls);
		cos.addActionListener(controls);
		tan.addActionListener(controls);
		era.addActionListener(controls);
	}
	
	public String getEquation(){
		return ans.getText();
	}
	
	public String setEquation(String st){
		ans.setText(st);
		return ans.getText();
	}

	public static void main(String[] args) {
		Calculator f = new Calculator();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(420, 190);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		//f.setResizable(false);
		f.setBackground(Color.black);
		f.getMenuBar();
	}
}
