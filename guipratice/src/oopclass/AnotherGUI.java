package oopclass;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnotherGUI extends JFrame{
	JButton btn;
	public void buildGUI(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���� �׷��� �ݾƵ� ������ ���ϰ� ���ִ� ��Ȱ
		
		btn =new JButton("������");
		this.add(btn);//add(btn); ��� �ص� �����ϴ�.		
		setSize(600,400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new AnotherGUI().buildGUI();

	}

}
