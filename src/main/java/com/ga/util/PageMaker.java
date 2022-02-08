package com.ga.util;

public class PageMaker {//페이징에 관련된 버튼들을 만드는 클래스
	private Criteria cri;
    private int totalCount;//총 게시글 수, 조회 쿼리에서  select count(*) from board; count(*)를 이용하여 구한다.
    private int startPage;//시작 페이지 번호(화면에 보여질 첫 번째 페이지 번호)
    private int endPage;//끝페이지 번호(화면에 보여지는 마지막 페이지 번호)
    private boolean prev;
    private boolean next;
    private int displayPageNum = 5;//하단에 보여지는 페이지 버튼의 수
    
    public Criteria getCri() {
        return cri;
    }
    public void setCri(Criteria cri) {
        this.cri = cri;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {//총 게시글 수를 셋팅할 때 calcData()메서드 호출=>페이징 관련 버튼 계산 실시
        this.totalCount = totalCount;
        calcData();
    }
    
    private void calcData() {//버튼 생성하는 계산식 메서드 끝페이지 번호, 시작페이지 번호, 이전, 다음 버튼을 구한다
    	//끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
        endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
        //cri.getPage():현재 페이지 정보
        startPage = (endPage - displayPageNum) + 1;
        if(startPage <= 0) startPage = 1;//시작페이지가 0, 음수라면 시작 페이지를 1로 한다
        
        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));//마지막 페이지 번호=총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
        //cri.getPerPageNum():한 페이지당 보여줄 게시글의 갯수
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
 
        prev = startPage == 1 ? false : true;//이전 버튼 생성 여부(시작 페이지 번호가 1이면 생성X)
        next = endPage * cri.getPerPageNum() < totalCount ? true : false;
        //다음 버튼 생성 여부(끝 페이지 번호*한 페이지당 보여줄 게시글의 갯수가 총 게시글 수보다 작을 경우 생성)
    }
    
    public int getStartPage() {
        return startPage;
    }
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
    public int getEndPage() {
        return endPage;
    }
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
    public boolean isPrev() {
        return prev;
    }
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
    public boolean isNext() {
        return next;
    }
    public void setNext(boolean next) {
        this.next = next;
    }
    public int getDisplayPageNum() {
        return displayPageNum;
    }
    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }
}
