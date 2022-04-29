package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.dto.BoardFile;
import web.util.Paging;

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

	/**
	 * boarNo 해당 게시글의 조회수가 1 상승한다.
	 * 
	 * @param boardNo - 조회하려는 게시글 번호
	 */
	public void hit(Board viewBoard);

	/**
	 * boardNo 해당 게시글의 상세 정보 조회
	 * 
	 * @param boardNo - 조회하려는 boardNo
	 * @return 게시글 내용에 대한 DTO 객체
	 */
	public Board select(Board viewBoard);

	/**
	 * board DTO객체에 있는 제목과 내용을 insert하는 쿼리문을 실행
	 * 
	 * @param board - insert하려는 제목, 내용이 있는 DTO객체
	 */
	public void insert(Board board);
	
	/**
	 * 업로드할 파일의 정보를 insert하는 쿼리문 실행 
	 * 
	 * @param boardFile - insert하려는 원본 파일명, UUID 파일명
	 */
	public void insertFile(BoardFile boardFile);

}
