package com.ga.board.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ga.board.service.BoardVO;
import com.ga.board.service.mapper.BoardMapper;
import com.ga.util.Criteria;
 
@Service("boardDAOService")
public class BoardDAOService implements BoardDAO{
    
    @Autowired
    private SqlSession sqlSession;
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectBoardList(Criteria cri) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        return mapper.selectBoardList(cri);
    }
 
    public void insertBoard(BoardVO boardVO) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        mapper.insertBoard(boardVO);
    }
 
    public void updateBoard(BoardVO boardVO) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        mapper.updateBoard(boardVO);
    }
 
    public void deleteBoard(BoardVO boardVO) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        mapper.deleteBoard(boardVO);
    }
 
    @Override
    public BoardVO selectBoardByCode(BoardVO boardVO) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        return mapper.selectBoardByCode(boardVO);
    }
   
}