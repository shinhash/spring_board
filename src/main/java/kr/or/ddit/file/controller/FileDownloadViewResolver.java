package kr.or.ddit.file.controller;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.file.vo.FileVO;

public class FileDownloadViewResolver extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		FileVO fileVO = (FileVO) model.get("fileVO");
		
		
		response.setContentType("application/octet-stream; charset=UTF-8");
		
		String downFileName = new String(fileVO.getREAL_FILE_NAME().getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + downFileName + "\"");
		
		
		String filename = fileVO.getFILE_NAME(); // 파일경로
		
		
		if(!fileVO.getFILE_NAME().equals("") && fileVO.getREAL_FILE_NAME() != null) {
			FileInputStream fis = new FileInputStream(filename);
			ServletOutputStream sos = response.getOutputStream();
			
			byte[] buffer = new byte[512];
			while(fis.read(buffer) != -1) {
				sos.write(buffer);
			}
			fis.close();
			sos.flush();
			sos.close();
		}
		
		
	}

}
