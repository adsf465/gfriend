package thisthis_5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {// tread 를 상위클래스로 만든이유는 하나의 프로그램속 작은 프로그램을
									// 만들기 위해서

	private Player player;// jar 삽입해서 사용할수 있는 인스턴스 변수 이다.
	private boolean isLoop;// 곡을 무한히 재생할건지 한번만 할건지 지정해주는 역활을 한다.
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();

	}// 현재 실행 되고 있는 음악이 지금 어떤 부분이 흘러 나오고 있는지 알아보는 메소드

	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();// 헤당 thread를 중지 상태로 만든다. 즉 음악 을 틀어주는 작은 프로그램을 중지하는 역활

	}// 음악이 언제든지 종료 가능케 하는 함수

	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
