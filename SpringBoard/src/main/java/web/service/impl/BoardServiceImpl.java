package web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.util.Paging;
import web.dao.face.BoardDao;
import web.dto.Board;
import web.service.face.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	//private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public Paging getPaging(Paging paramData) {
		//logger.info("BoardService getPaging 호출!");
		
		//총 게시글 조회
		int totalCount = boardDao.selectCntAll();
		
		//페이징 계산
		Paging paging = new Paging(totalCount, paramData.getCurPage());
		
		return paging;
	}

	@Override
	public List<Board> list(Paging paging) {
		//logger.info("BoardService list method 호출!");
		return boardDao.selectList(paging);
	}
	
	@Override
	public Board view(Board viewBoard) {
		
		//조회수를 상승 시킨다.
		boardDao.hit(viewBoard);
		
		return boardDao.select(viewBoard);
		
	}
	
	@Override
	public void write(Board board) {
		
		//제목이 빈칸 일 때, 제목없음
		if ("".equals(board.getTitle()) || board.getTitle() == null) {
			board.setTitle("(제목없음)");
		}
		
		boardDao.insert(board);
		
	}
}
