package com.ga.util;

public class Criteria {//게시글 조회 쿼리문에 전달될 파라미터를 담게 될 클래스(VO)
    
    private int page;//현재 페이지 번호
    private int perPageNum;//한 페이지당 보여줄 게시글의 수
    
    public int getPageStart() {//특정 페이지의 게시글 시작 번호
        return (this.page-1)*perPageNum;
    }
    
    public Criteria() {//기본 생성자, 페이징을 처리하기 위해 필요한 정보(현재 페이지 번호, 페이지당 보여줄 게시글의 수)가 최초로 게시판 목록에 들어왔을 때
    	//존재하지 않으므로 생성자를 통해 기본값을 세팅한다
        this.page = 1;
        this.perPageNum = 10;
    }
    
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        if(page <= 0) {//페이지가 음수가 되지 않도록 설정, 음수=>1페이지로 세팅
            this.page = 1;
        } else {
            this.page = page;
        }
    }
    public int getPerPageNum() {
        return perPageNum;
    }
    public void setPerPageNum(int pageCount) {//페이지당 보여줄 게시글 수 일정하도록 세팅
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }
    
}
