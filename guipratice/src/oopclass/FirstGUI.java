package oopclass;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstGUI {
	public void buildGUI(){
		JFrame frame =new JFrame("�ȳ��ϼ���");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���� �׷��� �ݾƵ� ������ ���ϰ� ���ִ� ��Ȱ
		
		JButton btn =new JButton("������");
		frame.add(btn);
		
		frame.setSize(600,400);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new FirstGUI().buildGUI();

	}

}
