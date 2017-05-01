package thisthis_6;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {// tread �� ����Ŭ������ ���������� �ϳ��� ���α׷��� ���� ���α׷���
									// ����� ���ؼ�

	private Player player;// jar �����ؼ� ����Ҽ� �ִ� �ν��Ͻ� ���� �̴�.
	private boolean isLoop;// ���� ������ ����Ұ��� �ѹ��� �Ұ��� �������ִ� ��Ȱ�� �Ѵ�.
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

	}// ���� ���� �ǰ� �ִ� ������ ���� � �κ��� �귯 ������ �ִ��� �˾ƺ��� �޼ҵ�

	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();// ��� thread�� ���� ���·� �����. �� ���� �� Ʋ���ִ� ���� ���α׷��� �����ϴ� ��Ȱ

	}// ������ �������� ���� ������ �ϴ� �Լ�

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
