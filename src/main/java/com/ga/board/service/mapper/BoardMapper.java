package com.ga.board.service.mapper;

import java.util.List;
import java.util.Map;

import com.ga.board.service.BoardVO;
import com.ga.util.Criteria;
 
public interface BoardMapper {
 
    // 게시물 리스트 조회
    public List<Map<String, Object>> selectBoardList(Criteria cri) throws Exception;
    
    // 게시물 등록
    public void insertBoard(BoardVO boardVO) throws Exception;
    
    // 게시물 수정
    public void updateBoard(BoardVO boardVO) throws Exception;
    
    // 게시물 삭제
    public void deleteBoard(BoardVO boardVO) throws Exception;
 
    // 게시물 조회
    public BoardVO selectBoardByCode(BoardVO boardVO) throws Exception;
    
    //총 게시물 갯수
    public int countBoardList() throws Exception;
}
