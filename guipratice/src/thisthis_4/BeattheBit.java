package thisthis_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeattheBit extends JFrame {
	private Image screenImage;
	private Graphics screenGraphics;
	// ���� ���۸��� ���� ȭ���� ���� 2���� �ν��Ͻ� ����

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();// ����ȭ�� �̹��� �θ��� ��ü ����
															
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/pokeballclosed.png"));// �����ư �������� ������ ��ü ����
								
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/pokeball.png"));// �����ư�� ���� ��� ������ ��ü ����
																											
	private JButton exitButton = new JButton(exitButtonBasicImage);// ���� ��ư�� �����ϴ� ��ü ����

	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/���.png")));// ���â�� �ٲ��ִ� ��ü ����

	private int mouseX, mouseY;

	public BeattheBit() {
		setUndecorated(true);// �⺻������ �����Ǵ� �޴� �ٰ� ������ ����
		setTitle("Beat the Bit");// ���� �׷� ���۽� â ���� ���� ���̴� ������ ���� ��
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);// â�� ũ�� ����(����, ����)
		setResizable(false);// ���α׷� ������ â�� ũ�⸦ �����Ҽ� ���� ���ִ³�
		setLocationRelativeTo(null);// ����� ����â�� �� �߾ӿ� �߰� �� �Ѵ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ������ ���α׷� â�� �����ϸ� �ȿ� ����
														// �ǰ� �ִ� ��� ���α׷� ����
		setVisible(true);// ���α׷�â�� �߰Բ� ���ش�.
		setBackground(new Color(0, 0, 0, 0));// ������ �ϴ� ����� �ִ´�
		setLayout(null);// ���� �Է��� ��ġ�� ��� ���Բ� ���ִ� �༮
		
		exitButton.setBounds(1245, 0, 30, 30);// ������ ��ư ����� ���� ��ġ ����
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);// �տ� 3���� ��ư�� �׵θ��� �����ִ� ��Ȱ
		add(exitButton);// ������ ��ư�� ��ġ�� �����ϰ� �װ��� ������ �־��ִ� ��Ȱ
		
		menubar.setBounds(0, 0, 1280, 30); // ���� �� ���� ���� �Ǵ� ���� ������ �μ��� ũ�� �� ����
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});// ���콺�� ���������� ��ǥ�� �����ش�
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});// ���콺 �� ���������� ��ȭ�� �����Ų��.
		add(menubar);// ���� ������ menubar�� �־� �ش�

		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    Music buttonEnteredMusic =new Music("buttonEnter.mp3",false);
			    buttonEnteredMusic.start();
			}// ���콺�� �����ư�� ��� �����ư�� Ŀ���� �ٲ�

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}//���콺������ �����ư�� Ŀ������ ����
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic =new Music("buttonpressed.mp3",false);// ��ư ������ ���� ����
				buttonPressedMusic.start();//�� �����ϴ�
				try{
						Thread.sleep(1000);// 1��
						}catch (InterruptedException ex){
							ex.printStackTrace();
						}// try catch �� ����� ������ ������ ������ 1�� �� �ð��� ���� ���ؼ�
				System.exit(0);
			}// ���콺�� ������ ������ ������ ���α׷� ����
		});

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
		paintComponents(g);/*
							 * drawImage �� ���� �׸��� â�� ����ִ� ����� �ϳ��̴�. ������ �̹����� ��ﶩ
							 * paintComponets �� �̿��Ѵ�.
							 */
		this.repaint();
	}

}
