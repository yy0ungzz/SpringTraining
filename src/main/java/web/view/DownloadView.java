package web.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import web.dto.BoardFile;

public class DownloadView extends AbstractView {
	
	@Autowired
	private ServletContext context;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//컨트롤러를 통해 전송한 모델값 가져오기
		BoardFile file = (BoardFile) model.get("downFile");
		
		//업로드된 파일의 객체
		File src = new File(context.getRealPath("upload"), file.getStoredName());
		
		//서버의 파일 입력 스트림
		FileInputStream input = new FileInputStream(src);
		
		//응답 헤더 설정
		response.setContentType("application/octet-stream");
		response.setContentLength((int) src.length());
		response.setCharacterEncoding("UTF-8");
		
		String outputName = URLEncoder.encode(file.getOriginName(), "UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + outputName + "\"" );
		
		//서버의 응답 출력 스트림
		OutputStream output = response.getOutputStream();
		
		//클라이언트 쪽으로 파일 전송
		FileCopyUtils.copy(input, output);
		
	}
}
