package com.ga.board.service.impl;

import java.util.List;
import java.util.Map;

import com.ga.board.service.BoardVO;
import com.ga.util.Criteria;
 
public interface BoardService {
 
    /**
     * 게시물 리스트 조회
     * @param boardVO
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> selectBoardList(Criteria cri) throws Exception;
    
    /**
     * 게시물 작성
     * @param boardVO
     * @throws Exception
     */
    public void insertBoard(BoardVO boardVO) throws Exception;
    
    /**
     * 게시물 수정
     * @param boardVO
     * @throws Exception
     */
    public void updateBoard(BoardVO boardVO) throws Exception;
    
    /**
     * 게시물 삭제
     * @param boardVO
     * @throws Exception
     */
    public void deleteBoard(BoardVO boardVO) throws Exception;
 
    /**
     * 게시글 조회
     * @param boardVO
     * @return
     * @throws Exception
     */
    public BoardVO selectBoardByCode(BoardVO boardVO) throws Exception;
    
    //총 게시물 갯수
    int countBoardListTotal() throws Exception;
}
