package web.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import web.dao.face.BoardDao;
import web.dto.Board;
import web.dto.BoardFile;
import web.service.face.BoardService;
import web.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	ServletContext context;
	
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
	public void write(Board board, MultipartFile file) {
		
		// : : : 글 내용 삽입 : : :
		
		//제목이 빈칸 일 때, 제목없음
		if ("".equals(board.getTitle()) || board.getTitle() == null) {
			board.setTitle("(제목없음)");
		}
		
		boardDao.insert(board);
		
		// : : : 파일 업로드 정보 삽입 : : :
		
		//MultipartFile의 메소드 getSize를 통해 파일의 크기가 0이하 조건문 적용
		//파일 업로드를 수행할 대 파일 용량이 0바이트 상태면 서버에 무리?
		if (file.getSize() <= 0) {
			logger.info("파일의 크기가 0이하거나 파일이 없습니다,처리 중단");
			
			//if문에서의 break은 해당 if문만 중단 시키지만
			//return은 해당 메소드를 중단 시킨다.
			return;
		}
		
		//파일이 실제로 저장될 경로(RealPath)
		String storedPath = context.getRealPath("upload");
		logger.info("upload realPath : {}", storedPath);
		
		//upload 폴더가 존재하지 않으면 생성한다.
		File storedFolder = new File(storedPath);
		if (!storedFolder.exists()) {
			storedFolder.mkdir();
		}
		
		//저장될 파일의 이름 정하기
		//서버에 파일을 업로드할 때 UUID로 생성하여 저장하는 이유?
		//-> 파일의 이름이 중복되면 기존파일에 다른파일로 덮어씌워질 수 있다.
		//-> 랜덤으로 생성한 UUID가 혹시 겹칠수도 있으니 원본 파일명과 같이 저장
		String filename = file.getOriginalFilename(); //원본 파일명
		filename += UUID.randomUUID().toString().split("-")[4]; //UUID추가
		logger.info("filename : {}", filename);
		
		//최종 저장할 파일의 정보 객체
		File dest = new File(storedFolder, filename);
		
		logger.info("file : {}", file);
		
		//업로드된 파일을 저장하기
		//transferTo(File dest) -> 파일을 지정된 경로로 전송한다.
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//BoardFile 정보를 저장하는 DTO 객체에 저장
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardNo(board.getBoardNo());
		boardFile.setOriginName(file.getOriginalFilename());
		boardFile.setStoredName(filename);
		
		//파일의 정보가 있는 DTO객체에 대한 데이터를 DB에 삽입
		boardDao.insertFile(boardFile);
		
	}
	
	@Override
	public BoardFile getAttachFile(Board viewBoard) {
		return boardDao.selectBoardFileByBoardNo(viewBoard);
	}
	
	@Override
	public BoardFile getFile(BoardFile boardFile) {
		return boardDao.selectBoardFileByFileNo(boardFile);
	}
}
