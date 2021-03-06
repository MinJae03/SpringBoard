package com.ga.board.web;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ga.board.service.BoardVO;
import com.ga.board.service.impl.BoardService;
import com.ga.util.Criteria;
import com.ga.util.PageMaker;
 
@Controller
public class BoardController {
 
    @Autowired
    private BoardService boardServiceImpl;
    
    /**
     * 게시판 조회
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/board/boardList.do")
    public ModelAndView boardList(Criteria cri) throws Exception{
    	ModelAndView mav = new ModelAndView("/board/boardList");
    	
    	PageMaker pageMaker = new PageMaker();
    	pageMaker.setCri(cri);
    	pageMaker.setTotalCount(boardServiceImpl.countBoardListTotal());
    	
    	List<Map<String, Object>> list = boardServiceImpl.selectBoardList(cri);
    	mav.addObject("list", list);
    	mav.addObject("pageMaker", pageMaker);
    	return mav;
    }
    
    /**
     * 글쓰기 폼
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/board/writeForm.do")
    public String writeBoardForm() throws Exception{
        
        return "board/writeForm";
    }
    
    /**
     * 게시글 등록
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/board/write.do")
    public String write(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception{
        
        boardServiceImpl.insertBoard(boardVO);
        
        return "redirect:/board/boardList.do";
    }
    
    /**
     * 게시글 조회
     * @param boardVO
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/board/viewContent.do")
    public String viewForm(@ModelAttribute("boardVO") BoardVO boardVO, Model model, HttpServletRequest request) throws Exception{
        
        int code = Integer.parseInt(request.getParameter("code"));
        boardVO.setCode(code);
        
        BoardVO resultVO = boardServiceImpl.selectBoardByCode(boardVO);
        
        model.addAttribute("result", resultVO);
        
        return "board/viewForm";
    }
    
    /**
     * 게시글 수정
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/board/updateboard.do")
    public String updateBoard(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception{
        
        try{
            
            boardServiceImpl.updateBoard(boardVO);
            
        } catch (Exception e){
            e.printStackTrace();
        }        
        
        return "redirect:/board/boardList.do";
        
    }
    /** 
     * 게시글 삭제
     */
    @RequestMapping(value="/board/deleteBoard.do")
    public String deleteBoard(@ModelAttribute("boardVO") BoardVO boardVO, Model model) {
    	try {
			boardServiceImpl.deleteBoard(boardVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "redirect:/board/boardList.do";
    }
}
