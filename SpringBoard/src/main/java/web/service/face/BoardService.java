package web.service.face;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import web.dto.Board;
import web.util.Paging;

public interface BoardService {
	
	/**
	 * 게시글 목록을 위한 페이징 객체를 생성한다.
	 * 	
	 * 	파라미터 객체의 curPage(현재 페이지)
	 * 	DB에서 조회한 totalCount(총 게시글 수)
	 * 	
	 * 	두 가지 데이터를 활용하여 페이징 객체를 생성하여 반환
	 * 
	 * @param paramData - curPage를 저장하고 있는 객체
	 * @return 계산이 완료된 Paging객체
	 */
	public Paging getPaging(Paging paramData);
	
	/**
	 * 페이징이 적용된 게시글 목록 조회 
	 * 
	 * @param paging - 페이징 정보 객체 
	 * @return 페이징이 적용된 게시글 목록
	 */
	public List<Board> list(Paging paging);

	/**
	 * 게시글번호를 통해서 상세내용 조회 한다.
	 * 게시글 상세조회 하는 순간 hit 컬럼 1상승 조회수 상승한다.
	 * 
	 * @param boardNo - 게시글 번호
	 * @return 게시글 상세내용이 담긴 Board DTO 객체
	 */
	public Board view(Board viewBoard);

	/**
	 * 게시글 입력폼에서 입력한 내용을 전달 받아 게시한다.
	 * 전달 받은 multipartfile 정보도 함께 전달 받는다.
	 * 
	 * @param board - 게시글의 제목, 내용이 담긴 Board DTO 객체
	 * @parma file - 업로드될 파일정보 객체
	 */
	public void write(Board board, MultipartFile file);
	
}
