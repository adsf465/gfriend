package thisthis;

import javax.swing.JFrame;

public class BeattheBit extends JFrame {
	
	public BeattheBit (){
		
		setTitle("Beat the Bit");//프로 그램 시작시 창 왼쪽 위에 보이는 제목을 지정 ㅎ
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//창의 크기 설정(가로, 세로)
		setResizable(false);//프로그램 실행후 창의 크기를 조절할수 없게 해주는놈
		setLocationRelativeTo(null);//실행시 만든창이 정 중앙에 뜨게 끔 한다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 실행후 프로그램 창을 종료하면 안에 실행 되고 있던 모든 프로그램 종료
		setVisible(true);//프로그램창이 뜨게끔 해준다.		
		
	}

}
