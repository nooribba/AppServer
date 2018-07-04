package books.entity;

public class BookDTO {
	private String bisbn;     		// 책 ISBN 번호
	private String btitle;			// 책 제목 
	private String bdate;			// 책 출판일
	private String bpage;			// 책 페이지수
	private int bprice;				// 책 가격
	private String bauthor;			// 책 저자				
	private String btranslator;		// 책 번역자
	private String bsupplement;		// 책 부록 ( 없음, CD 1장, etc )
	private String bpublisher;		// 책 출판사	
	private String bimgurl;			// 책 Thumbnail 이미지 URL  
	private String bimgbase64;		// 책 Thumbnail 이미지 base64 string

	 
	public BookDTO() {
		super();
	}


	public String getBisbn() {
		return bisbn;
	}


	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public String getBpage() {
		return bpage;
	}


	public void setBpage(String bpage) {
		this.bpage = bpage;
	}


	public int getBprice() {
		return bprice;
	}


	public void setBprice(int bprice) {
		this.bprice = bprice;
	}


	public String getBauthor() {
		return bauthor;
	}


	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}


	public String getBtranslator() {
		return btranslator;
	}


	public void setBtranslator(String btranslator) {
		this.btranslator = btranslator;
	}


	public String getBsupplement() {
		return bsupplement;
	}


	public void setBsupplement(String bsupplement) {
		this.bsupplement = bsupplement;
	}


	public String getBpublisher() {
		return bpublisher;
	}


	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}


	public String getBimgurl() {
		return bimgurl;
	}


	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}


	public String getBimgbase64() {
		return bimgbase64;
	}


	public void setBimgbase64(String bimgbase64) {
		this.bimgbase64 = bimgbase64;
	}
	
	
}
