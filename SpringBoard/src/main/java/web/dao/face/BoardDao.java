package web.dao.face;

import java.util.List;

import web.dto.Board;

public interface BoardDao {

	/**
	 * board테이블의 전체 정보를 조회한다.
	 * 
	 * @return - 조회한 board의 모든 정보를 list객체로 반환
	 */
	public List<Board> selectAll();

}
