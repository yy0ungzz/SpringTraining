package web.dao.face;

import java.util.List;

import util.Paging;
import web.dto.Board;

public interface BoardDao {

	/**
	 * 페이징을 적용하여 게시글 목록 조회
	 * 
	 * paging.startNo, paging.endNo를 이용하여 rownum을 조회한다.
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 페이징이 적용된 게시글 목록
	 */
	public List<Board> selectList(Paging paging);

	/**
	 * 전체 게시글 수를 조회한다.
	 * 
	 * @return 총 게시글 수
	 */
	public int selectCntAll();

}
