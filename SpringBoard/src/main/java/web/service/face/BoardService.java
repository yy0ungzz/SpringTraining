package web.service.face;

import java.util.List;

import web.dto.Board;

public interface BoardService {
	
	/**
	 * board의 정보를 조회한다.
	 * 
	 * @return - 조회한 board의 정보를 list로 반환
	 */
	public List<Board> list();

}
