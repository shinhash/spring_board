package kr.or.ddit.file.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.file.service.FileServiceI;
import kr.or.ddit.file.vo.FileVO;



@RequestMapping("/file")
@Controller
public class FileDownloadController {

	@Resource(name = "fileService")
	private FileServiceI fileService;
	
	
	@RequestMapping("/download")
	public String fileDownload(Model model, int fileId) {
		FileVO fileVO = fileService.selectFileVO(fileId);
		model.addAttribute("fileVO", fileVO);
		
		return "attchFileDownload";
	}
	
}
