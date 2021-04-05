package kr.co.vo;

public class Criteria {
	
	private int page;	//보여줄 페이지
	private int perPageNum;	//페이지당 보여줄 페이지 수
	
	public Criteria() {	//최초 default 생성자로 기본 객체 생성시 초기값을 지정
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
		}
		this.page = page;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}

	//limit 구문에서 시작 부문에 필요한 값을 반환
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
}