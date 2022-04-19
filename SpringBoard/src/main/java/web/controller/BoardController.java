package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.util.Paging;
import web.dto.Board;
import web.service.face.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/list")
	public void list(Paging paramData, Model model) {
		
		logger.info("/board/list [Connection]");
		
		//페이징 계산
		Paging paging = boardService.getPaging(paramData);
		logger.info("paging 객체 {}", paging);
		
		//게시글 목록 조회
		List<Board> list = boardService.list(paging);
		for (Board b : list) {
			logger.info("{}", b);
		}
		
		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
	}
}
