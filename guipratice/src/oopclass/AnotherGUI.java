package oopclass;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnotherGUI extends JFrame{
	JButton btn;
	public void buildGUI(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로 그램을 닫아도 실행을 안하게 해주는 역활
		
		btn =new JButton("눌러요");
		this.add(btn);//add(btn); 라고 해도 무방하다.		
		setSize(600,400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new AnotherGUI().buildGUI();

	}

}
