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
	// 더블 버퍼링을 위한 화면을 담을 2개의 인스턴스 변수

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();// 바탕화면 이미지 부르는 객체 생성
															
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/pokeballclosed.png"));// 종료버튼 눌렀을때 아이콘 객체 생성
								
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/pokeball.png"));// 종료버튼의 평상시 모습 아이콘 객체 생성
																											
	private JButton exitButton = new JButton(exitButtonBasicImage);// 종료 버튼을 생성하는 객체 생성

	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/배너.png")));// 배너창을 바꿔주는 객체 생성

	private int mouseX, mouseY;

	public BeattheBit() {
		setUndecorated(true);// 기본적으로 제공되는 메뉴 바가 보이지 않음
		setTitle("Beat the Bit");// 프로 그램 시작시 창 왼쪽 위에 보이는 제목을 지정 ㅎ
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);// 창의 크기 설정(가로, 세로)
		setResizable(false);// 프로그램 실행후 창의 크기를 조절할수 없게 해주는놈
		setLocationRelativeTo(null);// 실행시 만든창이 정 중앙에 뜨게 끔 한다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 실행후 프로그램 창을 종료하면 안에 실행
														// 되고 있던 모든 프로그램 종료
		setVisible(true);// 프로그램창이 뜨게끔 해준다.
		setBackground(new Color(0, 0, 0, 0));// 색상을 일단 흰색을 넣는다
		setLayout(null);// 내가 입력한 위치에 들어 가게끔 해주는 녀석
		
		exitButton.setBounds(1245, 0, 30, 30);// 나가기 버튼 만들기 위해 위치 지정
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);// 앞에 3줄은 버튼의 테두리를 없에주는 역활
		add(exitButton);// 나가기 버튼의 위치를 지정하고 그것을 실제로 넣어주는 역활
		
		menubar.setBounds(0, 0, 1280, 30); // 앞의 두 수는 시작 되는 지점 나머지 두수는 크기 를 지정
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});// 마우스를 눌렀을때의 좌표를 구해준다
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});// 마우스 가 움직을때의 변화를 실행시킨다.
		add(menubar);// 위에 지정된 menubar를 넣어 준다

		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    Music buttonEnteredMusic =new Music("buttonEnter.mp3",false);
			    buttonEnteredMusic.start();
			}// 마우스를 종료버튼에 대면 종료버튼과 커서가 바뀜

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}//마우스를때면 종료버튼과 커서원상 복귀
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic =new Music("buttonpressed.mp3",false);// 버튼 누르면 음악 나옴
				buttonPressedMusic.start();//을 시작하는
				try{
						Thread.sleep(1000);// 1초
						}catch (InterruptedException ex){
							ex.printStackTrace();
						}// try catch 를 사용한 이유는 음악이 나온후 1초 의 시간을 벌기 위해서
				System.exit(0);
			}// 마우스를 누르면 음악이 나오고 프로그램 종료
		});

		Music introMusic = new Music("여자친구-01-바람의 노래 (Hear The Wind Sing).mp3", true);// 음악을넣어주고
		introMusic.start();// 음악을 실행 시키고
	}

	public void paint(Graphics g) {// paint 라는 메소드는 JFrame에서 제공하는 약손된 메소드이다
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);// 1280x720
																			// 만큼의
																			// 이미지를
																			// 만든
																			// 후에
																			// screenImage를
																			// 초기화
																			// 시키것다
		screenGraphics = screenImage.getGraphics();// screenImage라는 객체의
													// getGraphics()메소드 이용하여 넣어
													// 준다.
		screenDraw(screenGraphics); // screenDraw 를 이용하여 그리기.
		g.drawImage(screenImage, 0, 0, null);
	}//

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);/*
							 * drawImage 와 같이 그림을 창에 띄워주는 기능중 하나이다. 고정된 이미지를 띄울땐
							 * paintComponets 를 이용한다.
							 */
		this.repaint();
	}

}
