package thisthis_6;
//���ǰ� Ÿ��Ʋ �̹����� ��� �ִ�.
public class Track {
	private String titleImage;//���� ������ �ڹٰ� ��Ÿ�����̴�.
	
	private String startmusic;
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	
	public String getStartmusic() {
		return startmusic;
	}
	public void setStartmusic(String startmusic) {
		this.startmusic = startmusic;
	}
	
	public Track(String titleImage, String startmusic) {
		super();
		this.titleImage = titleImage;
		this.startmusic = startmusic;
	}
	



}
