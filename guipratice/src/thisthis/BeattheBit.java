package thisthis;

import javax.swing.JFrame;

public class BeattheBit extends JFrame {
	
	public BeattheBit (){
		
		setTitle("Beat the Bit");//���� �׷� ���۽� â ���� ���� ���̴� ������ ���� ��
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//â�� ũ�� ����(����, ����)
		setResizable(false);//���α׷� ������ â�� ũ�⸦ �����Ҽ� ���� ���ִ³�
		setLocationRelativeTo(null);//����� ����â�� �� �߾ӿ� �߰� �� �Ѵ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ������ ���α׷� â�� �����ϸ� �ȿ� ���� �ǰ� �ִ� ��� ���α׷� ����
		setVisible(true);//���α׷�â�� �߰Բ� ���ش�.		
		
	}

}
