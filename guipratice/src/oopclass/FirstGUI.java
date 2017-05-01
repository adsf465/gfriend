package oopclass;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstGUI {
	public void buildGUI(){
		JFrame frame =new JFrame("안녕하세요");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로 그램을 닫아도 실행을 안하게 해주는 역활
		
		JButton btn =new JButton("눌러요");
		frame.add(btn);
		
		frame.setSize(600,400);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new FirstGUI().buildGUI();

	}

}
