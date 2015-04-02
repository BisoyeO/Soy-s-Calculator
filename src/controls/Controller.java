package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import view.Calculator;

public class Controller implements ActionListener{
	
	private Calculator c;
	private static DecimalFormat df2 = new DecimalFormat("0.00");
	
	public Controller(Calculator c){
		this.c = c;
	}
	
	public static double math(String equation) {
		double x, y, z;
		String g;
		int index=-1;
		if(index==-1){
			index = equation.indexOf('+');
		}
		if(index==-1){
			index = equation.indexOf('-');
		}
		if(index==-1){
			index = equation.indexOf('/');
		}
		if(index==-1){
			index = equation.indexOf('*');
		}
		x = Double.parseDouble(equation.substring(0,index));
		y = Double.parseDouble(equation.substring(index+1));
		x = x * 1.0;
		y = y * 1.0;

		if (equation.charAt(index) == '-') {
			g = df2.format(x - y);
			z = Double.parseDouble(g);
			return z;
		}
		if (equation.charAt(index) == '+') {
			g = df2.format(x + y);
			z = Double.parseDouble(g);
			return z;
		}
		if (equation.charAt(index) == '/') {
			g = df2.format(x / y);
			z = Double.parseDouble(g);
			return z;
		}
		if (equation.charAt(index) == '*') {
			g = df2.format(x * y);
			z = Double.parseDouble(g);
			return z;
		}

		else
			return 0.0;
	}

	public void actionPerformed(ActionEvent e) {
		String curEq = c.getEquation();
		if(e.getActionCommand().equals("=")){
			c.setEquation(math(curEq)+"");
		}else if(e.getActionCommand().equals("c")){
			c.setEquation("");
		}else if(e.getActionCommand().equals("<")){
			c.setEquation(curEq.substring(0,curEq.length()-1));
		}else if(e.getActionCommand().equals("sin")){
			String value = String.valueOf(Math.sin(Double.parseDouble(curEq)));
			c.setEquation(value);
		}else if(e.getActionCommand().equals("cos")){
			String value = String.valueOf(Math.cos(Double.parseDouble(curEq)));
			c.setEquation(value);
		}else if(e.getActionCommand().equals("tan")){
			String value = String.valueOf(Math.tan(Double.parseDouble(curEq)));
			c.setEquation(value);
		}else{
			curEq+=e.getActionCommand();
			c.setEquation(curEq);
		}
		
	}

}
