package thisthis_6;
//음악과 타이틀 이미지를 담고 있다.
public class Track {
	private String titleImage;//여러 색깔의 자바고를 나타낼것이다.
	
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
