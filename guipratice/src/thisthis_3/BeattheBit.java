package thisthis_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BeattheBit extends JFrame {
	private Image screenImage;
	private Graphics screenGraphics;
	// ���� ���۸��� ���� ȭ���� ���� 2���� �ν��Ͻ� ����

	private Image introBackground;

	public BeattheBit() {

		setTitle("Beat the Bit");// ���� �׷� ���۽� â ���� ���� ���̴� ������ ���� ��
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);// â�� ũ�� ����(����, ����)
		setResizable(false);// ���α׷� ������ â�� ũ�⸦ �����Ҽ� ���� ���ִ³�
		setLocationRelativeTo(null);// ����� ����â�� �� �߾ӿ� �߰� �� �Ѵ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ������ ���α׷� â�� �����ϸ� �ȿ� ����
														// �ǰ� �ִ� ��� ���α׷� ����
		setVisible(true);// ���α׷�â�� �߰Բ� ���ش�.
		/* ���� ���۸� �� ����ؼ� �̹����� �ҷ� �´�, �ż������� ���ۿ� �̹����� ��Ƽ� ����ϴ� ����̴� */
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		// main Ŭ������ ��ġ�� ������� �Ͽ� �̹��� ������ ��� �´��� �̹��� �ν��Ͻ��� �޾� introBackground��
		// �ʱ�ȭ �Ѵ�.
		Music introMusic = new Music("����ģ��-01-�ٶ��� �뷡 (Hear The Wind Sing).mp3", true);// �������־��ְ�
		introMusic.start();// ������ ���� ��Ű��
	}

	public void paint(Graphics g) {// paint ��� �޼ҵ�� JFrame���� �����ϴ� ��յ� �޼ҵ��̴�
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);// 1280x720
																			// ��ŭ��
																			// �̹�����
																			// ����
																			// �Ŀ�
																			// screenImage��
																			// �ʱ�ȭ
																			// ��Ű�ʹ�
		screenGraphics = screenImage.getGraphics();// screenImage��� ��ü��
													// getGraphics()�޼ҵ� �̿��Ͽ� �־�
													// �ش�.
		screenDraw(screenGraphics); // screenDraw �� �̿��Ͽ� �׸���.
		g.drawImage(screenImage, 0, 0, null);
	}//

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}

}
