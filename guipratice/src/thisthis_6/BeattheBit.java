package thisthis_6;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeattheBit extends JFrame {

	private boolean isMainsScreen =false;
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/pokeballclosed.png"));// 종료버튼 눌렀을때 아이콘 객체 생성
								
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/pokeball.png"));// 종료버튼의 평상시 모습 아이콘 객체 생성
	
	private ImageIcon gomainButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/pokeballclosed.png"));// 메인돌아가는 버튼 눌렀을때 아이콘 객체 생성
	
	private ImageIcon gomainButtonBasicImage = new ImageIcon(Main.class.getResource("../images/pokeball.png"));// 메인돌아가는 평상시 모습 아이콘 객체 생성
	
	private ImageIcon startButtonEnteredImage	 =new ImageIcon(Main.class.getResource("../images/buttonstartpressed.png"));// 눌렀을때의시작버튼을 만들어 준다
	
	private ImageIcon startButtonBasicImage	 =new ImageIcon(Main.class.getResource("../images/buttonstart.png"));// 평상시의 시작버튼을 만들어 준다
	
	private ImageIcon quitButtonEnteredImage	 =new ImageIcon(Main.class.getResource("../images/quitbuttonpressed.png"));// 눌렀을때의 음악 끄기 만들어 준다
	
	private ImageIcon quitButtonBasicImage	 =new ImageIcon(Main.class.getResource("../images/quitbutton.png"));// 평상시의 음악끄기 버튼을 만들어 준다
	
	private ImageIcon rightButtonEnteredImage	 =new ImageIcon(Main.class.getResource("../images/rightpointpressed.png"));// 오른쪽 버튼 눌렸을때 만들어 준다
	
	private ImageIcon rightButtonBasicImage	 =new ImageIcon(Main.class.getResource("../images/rightpoint.png"));// 오른쪽  버튼을 만들어 준다
	
	private ImageIcon leftButtonEnteredImage	 =new ImageIcon(Main.class.getResource("../images/leftpointpressed.png"));// 눌렀을때의 왼쪽 버튼 만들어 준다
	
	private ImageIcon leftButtonBasicImage	 =new ImageIcon(Main.class.getResource("../images/leftpoint.png"));// 평상시의 왼쪽 버튼을 만들어 준다
	
	private JButton gomainButton = new JButton(exitButtonBasicImage);// 종료 버튼을 생성하는 객체 생성 
	
	private JButton exitButton = new JButton(exitButtonBasicImage);// 종료 버튼을 생성하는 객체 생성 
	
	private JButton startButton = new JButton(startButtonBasicImage);// 시작 버튼을 생성하는 객체 생성 
	
	private JButton quitButton = new JButton(quitButtonBasicImage);// 음악 종료 버튼을 생성하는 객체 생성 
	
	private JButton rightButton = new JButton(rightButtonBasicImage);// 종료 버튼을 생성하는 객체 생성 
	
	private JButton leftButton = new JButton(leftButtonBasicImage);// 종료 버튼을 생성하는 객체 생성 
	
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/배너.png")));// 배너창을 바꿔주는 객체 생성
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();// 바탕화면 이미지 부르는 객체 생성
	
	private Image dragon = new ImageIcon(Main.class.getResource("../images/ana.gif")).getImage();// 망나뇽 이미지 부르는 객체 생성

	private Image screenImage;
	private Graphics screenGraphics;
	// 더블 버퍼링을 위한 화면을 담을 2개의 인스턴스 변수
	private int mouseX, mouseY;
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image new_Image;
	private Music selectedMusic;
	private int nowSelected =0;

	
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
		
		gomainButton.setBounds(640, 40, 30, 30);// 나가기 버튼 만들기 위해 위치 지정
		gomainButton.setBorderPainted(false);
		gomainButton.setContentAreaFilled(false);
		gomainButton.setFocusPainted(false);// 앞에 3줄은 버튼의 테두리를 없에주는 역활
		add(gomainButton);
		gomainButton.setVisible(false);
		
		startButton.setBounds(40, 40, 345, 322);// 나가기 버튼 만들기 위해 위치 지정
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);// 앞에 3줄은 버튼의 테두리를 없에주는 역활
		add(startButton);// 나가기 버튼의 위치를 지정하고 그것을 실제로 넣어주는 역활
		
		quitButton.setBounds(700,100 , 203, 248);// 나가기 버튼 만들기 위해 위치 지정
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);// 앞에 3줄은 버튼의 테두리를 없에주는 역활
		add(quitButton);// 나가기 버튼의 위치를 지정하고 그것을 실제로 넣어주는 역활
		
		rightButton.setBounds(850,120 , 200, 200);// 나가기 버튼 만들기 위해 위치 지정
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);// 앞에 3줄은 버튼의 테두리를 없에주는 역활
		add(rightButton);// 나가기 버튼의 위치를 지정하고 그것을 실제로 넣어주는 역활
		rightButton.setVisible(false);
		
		leftButton.setBounds(280,120 , 200, 200);// 나가기 버튼 만들기 위해 위치 지정
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);// 앞에 3줄은 버튼의 테두리를 없에주는 역활
		add(leftButton);// 나가기 버튼의 위치를 지정하고 그것을 실제로 넣어주는 역활
		leftButton.setVisible(false);
		
		menubar.setBounds(0, 0, 1280, 30); // 앞의 두 수는 시작 되는 지점 나머지 두수는 크기 를 지정
		
		Music introMusic = new Music("여자친구-01-바람의 노래 (Hear The Wind Sing).mp3", true);// 음악을넣어주고
		introMusic.start();// 음악을 실행 시키고
		// 이밑에 4녀석은 노래 선택할 이미지와 음악을 같이 가지고 있는 track 클래스에 값을 넣었다.
		trackList.add(new Track("greenjavago.png","036 지코 (ZICO)-02-유레카 (Feat. Zion.T).mp3"));// index 0
		trackList.add(new Track("borajavago.png","002 여자친구-02-시간을 달려서 (Rough).mp3"));// index 1
		trackList.add(new Track("bluejavago.png","020 여자친구-02-오늘부터 우리는 (Me Gustas Tu).mp3"));// index 2
		trackList.add(new Track("KakaoTalk_20170430_151546817.png","여자친구-01-바람의 노래 (Hear The Wind Sing).mp3"));// index 3
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
		
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    Music buttonEnteredMusic =new Music("buttonEnter.mp3",false);
			    buttonEnteredMusic.start();
			}// 마우스를 시작버튼에 대면 시작버튼과 커서가 바뀜

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}//마우스를때면 시작버튼과 커서원상 복귀
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic =new Music("buttonpressed.mp3",false);// 버튼 누르면 음악 나옴
				buttonPressedMusic.start();//을 시작하는
				selectedTrack(0);
				introMusic.close();//음악 끄고
				startButton.setVisible(false);
				quitButton.setVisible(false);
				gomainButton.setVisible(true);
				rightButton.setVisible(true);
				leftButton.setVisible(true);

				background = new ImageIcon(Main.class.getResource("../images/background_2.jpg")).getImage();// 바탕화면 이미지 바꾸기
				isMainsScreen=true;//자바고 이미지 만들기
			
				
			}
		});
		
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    Music buttonEnteredMusic =new Music("buttonEnter.mp3",false);
			    buttonEnteredMusic.start();
			}// 마우스를 종료버튼에 대면 종료버튼과 커서가 바뀜

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}//마우스를때면 종료버튼과 커서원상 복귀
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic =new Music("buttonpressed.mp3",false);// 버튼 누르면 음악 나옴
				buttonPressedMusic.start();//을 시작하는
				introMusic.close();//음악 끄고
				
				
				}
		});
		
		gomainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				gomainButton.setIcon(exitButtonEnteredImage);
				gomainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    Music buttonEnteredMusic =new Music("buttonEnter.mp3",false);
			    buttonEnteredMusic.start();
			}// 마우스를 종료버튼에 대면 종료버튼과 커서가 바뀜

			@Override
			public void mouseExited(MouseEvent e) {
				gomainButton.setIcon(gomainButtonBasicImage);
				gomainButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}//마우스를때면 종료버튼과 커서원상 복귀
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic =new Music("buttonpressed.mp3",false);// 버튼 누르면 음악 나옴
				buttonPressedMusic.start();//을 시작하는
				
				selectedMusic.close();
				gomainButton.setVisible(false);
				quitButton.setVisible(true);//잠시 없엔걸 보이게 한다.
				startButton.setVisible(true);//잠시 없엔걸 보이게 한다.
				rightButton.setVisible(false);
				leftButton.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();// 바탕화면 이미지 바꾸기
				isMainsScreen=false;// 자바고 이미지  없에기
				
				
				}
		});
		
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    Music buttonEnteredMusic =new Music("buttonEnter.mp3",false);
			    buttonEnteredMusic.start();
			}// 마우스를 종료버튼에 대면 종료버튼과 커서가 바뀜

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}//마우스를때면 종료버튼과 커서원상 복귀
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic =new Music("buttonpressed.mp3",false);// 버튼 누르면 음악 나옴
				buttonPressedMusic.start();//을 시작하는
				selectRight();
				
				}
		});
		
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    Music buttonEnteredMusic =new Music("buttonEnter.mp3",false);
			    buttonEnteredMusic.start();
			}// 마우스를 종료버튼에 대면 종료버튼과 커서가 바뀜

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}//마우스를때면 종료버튼과 커서원상 복귀
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic =new Music("buttonpressed.mp3",false);// 버튼 누르면 음악 나옴
				buttonPressedMusic.start();//을 시작하는
				selectLeft();
				
				
				}
		});

	
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
		g.drawImage(background, 0, 0, null);
		//g.drawImage(dragon, 700, 500, null);// 망나뇽 나오게 하기
	
		paintComponents(g);/*
							 * drawImage 와 같이 그림을 창에 띄워주는 기능중 하나이다. 고정된 이미지를 띄울땐
							 * paintComponets 를 이용한다.
							 * 또한 역동적인 이미지를 보여줄때도 drawImage 를 쓴다.
							 */
		if(isMainsScreen){
			g.drawImage(new_Image,500,100,null);// 자바고 이미지 나오게 하기
			
		}
		this.repaint();
	}
	
	public void selectedTrack(int nowSelected){
		if(selectedMusic != null)
			selectedMusic.close();
		new_Image = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getTitleImage())).getImage();// 바탕화면 이미지 부르는 객체 생성
		selectedMusic =new Music(trackList.get(nowSelected).getStartmusic(),true);
		selectedMusic.start();
	
	}// track class를 불러 곡이 나오게끔 하는녀석
	public void selectLeft(){
		if(nowSelected==0)
			nowSelected=trackList.size()-1;
		else
			nowSelected--;
		selectedTrack(nowSelected);
	}
	public void selectRight(){
		if(nowSelected==trackList.size()-1)
			nowSelected=0;
		else
			nowSelected++;
		selectedTrack(nowSelected);
			
	}
}
