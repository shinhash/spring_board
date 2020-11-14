package kr.or.ddit.file.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceI;
import kr.or.ddit.file.vo.FileVO;


@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(FileDownloadServlet.class);
	private FileServiceI fileService;
	@Override
	public void init() throws ServletException {
		fileService = new FileService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fileId = Integer.parseInt(request.getParameter("fileId"));
		
		FileVO fileVO = fileService.selectFileVO(fileId);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileVO.getREAL_FILE_NAME() + "\"");
		response.setContentType("application/octet-stream");
		
		
		
		String filename = fileVO.getFILE_NAME(); // 파일경로
		
		
		if(filename != null) {
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
