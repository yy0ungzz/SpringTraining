package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import web.dto.Board;
import web.service.face.BoardService;
import web.util.Paging;

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
	
	@GetMapping("/board/view")
	public String viewDetail(Board viewBoard, Model model 
			//RequestParam을 이용하여 Query String을 이용한 파라미터를 받을 수 있다.
			//@RequestParam("boardNo") int boardNo
			) {
		
		logger.info("/board/view [GET]");
		
		logger.info("선택한 게시글의 게시글 번호 viewBoard boardNo : {}", viewBoard);
		
		
		//클라이언트 측에서 직접 URL을 입력하여 올바르지 못한 접속을 하려 할 때
		if (viewBoard.getBoardNo() < 1) {
			return "redirect:/board/list";
		}
		
		//전달 받은 게시글 번호를 통해서 게시글의 상세 내용 조회
		viewBoard = boardService.view(viewBoard);
		logger.info("조회된 게시글 : {}", viewBoard);
		
		//boardNo에 해당되는 상세내용 모델값으로 전송
		model.addAttribute("viewBoard", viewBoard);
		
		return "board/view";
		
	}
	
	@GetMapping("/board/write")
	public void write() {
		logger.info("/board/write [GET]");
	}
	
	@PostMapping("/board/write")
	public String writeProcess(Model model, Board board, MultipartFile file) {
		
		logger.info("/board/write [POST]");
		
		//게시글 정보
		logger.info("Board - {}", board);
		//첨부파일 정보
		logger.info("File - {}", file);
		
		boardService.write(board, file);
		
		return "redirect:/board/list";
	}
	
}
