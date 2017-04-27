package thisthis_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BeattheBit extends JFrame {
	private Image screenImage;
	private Graphics screenGraphics;
	//더블 버퍼링을 위한 화면을 담을 2개의 인스턴스 변수
	
	private Image introBackground;
	
	
	public BeattheBit (){
		
		setTitle("Beat the Bit");//프로 그램 시작시 창 왼쪽 위에 보이는 제목을 지정 ㅎ
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//창의 크기 설정(가로, 세로)
		setResizable(false);//프로그램 실행후 창의 크기를 조절할수 없게 해주는놈
		setLocationRelativeTo(null);//실행시 만든창이 정 중앙에 뜨게 끔 한다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 실행후 프로그램 창을 종료하면 안에 실행 되고 있던 모든 프로그램 종료
		setVisible(true);//프로그램창이 뜨게끔 해준다.		
		/* 더블 버퍼링 을 사용해서 이미지를 불러 온다, 매순간마다 버퍼에 이미지를 담아서 출력하는 방법이다*/
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		//main 클래스의 위치를 기반으로 하여 이미지 파일을 얻어 온다음 이미지 인스턴스를 받아 introBackground를 초기화 한다.
	}
	public void paint(Graphics g){//paint 라는 메소드는 JFrame에서 제공하는 약손된 메소드이다
		screenImage =createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//1280x720 만큼의 이미지를 만든 후에 screenImage를 초기화 시키것다
		screenGraphics= screenImage.getGraphics();// screenImage라는 객체의 getGraphics()메소드 이용하여 넣어 준다.
		screenDraw(screenGraphics); //screenDraw 를 이용하여 그리기.
		g.drawImage(screenImage, 0,0, null);
	}//
	public void screenDraw(Graphics g){
		g.drawImage(introBackground, 0, 0,null);
		this.repaint();
	}

}
