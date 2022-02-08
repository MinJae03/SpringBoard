package com.ga.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ga.board.service.BoardVO;
import com.ga.util.Criteria;
 
@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardService{
    
    @Autowired
    private BoardDAO boardDAOService;
    
    @Override
    public List<Map<String, Object>> selectBoardList(Criteria cri) throws Exception {
        List<Map<String, Object>> list = null;
        list = boardDAOService.selectBoardList(cri);
        return list;
    }
 
    @Override
    public void insertBoard(BoardVO boardVO) throws Exception {
        boardDAOService.insertBoard(boardVO);
    }
 
    @Override
    public void updateBoard(BoardVO boardVO) throws Exception {
        boardDAOService.updateBoard(boardVO);
    }
 
    @Override
    public void deleteBoard(BoardVO boardVO) throws Exception {
        boardDAOService.deleteBoard(boardVO);
    }
 
    @Override
    public BoardVO selectBoardByCode(BoardVO boardVO) throws Exception {
        
        BoardVO resultVO = boardDAOService.selectBoardByCode(boardVO);
        
        return resultVO; 
    }


 
}
