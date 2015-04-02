package panels;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NumberPanel extends JPanel{
	private JButton[] buttons;
	public static final int SIZE = 12;
	
	public NumberPanel(){
		super();
		setLayout(new GridLayout(4,3));
		buttons = new JButton[SIZE];
		for(int i=0;i<buttons.length-2;i++){
			buttons[i] = new JButton(i+"");
			add(buttons[i]);
		}
		buttons[10] = new JButton(".");
		buttons[11] = new JButton("c");
		add(buttons[10]);
		add(buttons[11]);
	}
	
	public void addListeners(ActionListener l){
		for(int i = 0; i<buttons.length;i++){
			buttons[i].addActionListener(l);
		}
	}
}
