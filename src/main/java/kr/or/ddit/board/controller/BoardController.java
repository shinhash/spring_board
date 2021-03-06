package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.BoardKindVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.file.vo.FileVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.reple.service.RepleServiceI;
import kr.or.ddit.reple.vo.RepleVO;



@RequestMapping("/board")
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
	
	
	@Resource(name = "repleService")
	private RepleServiceI repleService;
	
	
	
	
	
	@RequestMapping("/main")
	public String mainPage() {
		return "tiles/layout/main_content";
	}
	
	
	
	
	
	/**
	 * 회원이 생성한 게시판 목록을 보여주는 메서드
	 */
	@RequestMapping("/myboardView")
	public String bkCreateView(HttpSession session) {
		
		MemberVO member = (MemberVO) session.getAttribute("MEMBER");
		List<BoardKindVO> memBkList = boardService.selectAddedBoardKind(member.getUserid());
		session.setAttribute("memBkList", memBkList);
		
		return "tiles/board/boardCreate";
	}
	
	
	
	
	
	
	/**
	 * 회원이 게시판을 생성하는 메서드
	 */
	@RequestMapping("/boardCreate")
	public String boardCreateAction(HttpSession session, String addboardName, String board_use) {
		
		MemberVO member = (MemberVO) session.getAttribute("MEMBER");
		BoardKindVO bkVO = new BoardKindVO(addboardName, board_use, member.getUserid());
		int insertCnt = boardService.insertBoardKind(bkVO);
		
		if(insertCnt == 1) {
			List<BoardKindVO> bkList = boardService.selectAllBoardKind();
			session.setAttribute("bkList", bkList);
		}
		return "redirect:/board/myboardView";
	}
	
	
	
	
	
	
	
	
	/**
	 * 회원이 생성한 게시판의 속성을 변경하는 메서드
	 */
	@RequestMapping("/boardKindUpdate")
	public String boardKindUpdateAction(HttpSession session, String upBoardKindId, String boardUse) {
		
		BoardKindVO bkVO = new BoardKindVO();
		bkVO.setBOARD_KIND_ID(Integer.parseInt(upBoardKindId));
		bkVO.setBOARD_KIND_STATUS(boardUse);
		
		int updateCnt = boardService.updateBoardKind(bkVO);
		if(updateCnt == 1) {
			List<BoardKindVO> bkList = boardService.selectAllBoardKind();
			session.setAttribute("bkList", bkList);
		}
		
		return "redirect:/board/myboardView";
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 게시판을 리스트 형태로 반환하는 메서드
	 */
	@RequestMapping("/boardList")
	public String boardListView(Model model,
								String boardKindId,
								@RequestParam(name = "pageNum", defaultValue = "1") String pageNumStr) {
		
		int pageNum = Integer.parseInt(pageNumStr);
		int pageSize = 10;
		
		Map<String, Object> boardInfoMap = boardService.selectBoardPageList(Integer.parseInt(boardKindId), pageNum, pageSize);
		
		int pageCnt = (Integer) boardInfoMap.get("pageCnt");
		List<BoardVO> boardPageList = (List<BoardVO>) boardInfoMap.get("boardList");
		
		if(boardPageList.size() > 0) {
			for(BoardVO nbspBoard : boardPageList) {
				String title = nbspBoard.getBOARD_TITLE();
				if(!"[삭제된 게시글 입니다.]".equals(title)) {
					if(nbspBoard.getBOARD_PSEQ() != 0) {
						String newTitle = title.replaceAll(" ", "&nbsp;");
						nbspBoard.setBOARD_TITLE(newTitle);
					}
				}
			}
			
		}
		String boardKindTitle = (String)boardInfoMap.get("boardKindTitle");
		
		model.addAttribute("boardKindId", boardKindId);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("boardPageList", boardPageList);
		model.addAttribute("boardKindTitle", boardKindTitle);
		
		return "tiles/board/boardPageList";
	}
	
	
	
	
	
	
	/**
	 * 선택한 게시글 번호와 일치하는 게시글의 정보(게시글정보, 파일정보, 댓글정보)를 반환하는 메서드
	 */
	@RequestMapping("/boardInfo")
	public String boardInfoView(String boardSeq, Model model) {
		
		BoardVO boardVO = boardService.selectBoardInfo(Integer.parseInt(boardSeq));
		List<FileVO> fileList = boardService.selectFileList(Integer.parseInt(boardSeq));
		List<RepleVO> repleList = repleService.selectRepleList(boardVO);
		
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("fileList", fileList);
		model.addAttribute("repleList", repleList);
		
		return "tiles/board/boardInfo";
	}
	
	
	
	
	
	/**
	 * 게시글 작성 페이지 이동 메서드
	 */
	@RequestMapping("/registView")
	public String boardRegistView(String boardPseq, String boardKindId, Model model) {
		
		if(boardPseq == null) {
			
			model.addAttribute("boardKindId", Integer.parseInt(boardKindId));
		}else {
			
			model.addAttribute("boardPseq", boardPseq);
			model.addAttribute("boardKindId", Integer.parseInt(boardKindId));
		}
		
		return "tiles/board/boardRegist";
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 작성한 게시글 등록 메서드
	 */
	@RequestMapping(path="/registAction", method = RequestMethod.POST)
	public String registAction(HttpSession session, 
							   String boardTitle, 
							   String editordata, 
							   String BOARD_KIND_ID,
							   @RequestParam(name = "boardPseq", defaultValue = "0") String boardPseq, 
							   @RequestPart("file") List<MultipartFile> fileList
							   ) throws IllegalStateException, IOException {
		
		MemberVO memVO = (MemberVO) session.getAttribute("MEMBER");
		
		
		// 다음번 번호 생성
		int boardSeq = boardService.selectBoardSeq();
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setBOARD_SEQ(boardSeq);
		boardVO.setBOARD_TITLE(boardTitle);
		boardVO.setBOARD_CONTENT(editordata);
		boardVO.setUSERID(memVO.getUserid());
		boardVO.setBOARD_KIND_ID(Integer.parseInt(BOARD_KIND_ID));
		boardVO.setBOARD_STATUS("Y");

		// 답글작성 ==> 부모글이 있는지 확인
		int boardPseqNum = Integer.parseInt(boardPseq);

		// 부모글의 정보를 가져오기 및 셋팅
		BoardVO boardGnVO = boardService.selectBoardGnVO(boardPseqNum);
		boardVO.setBOARD_PSEQ(boardGnVO.getBOARD_SEQ());
		boardVO.setBOARD_GN(boardGnVO.getBOARD_GN());
		
		
		// 게시글 작성(insert)
		FileVO fileVO = null;
		int insertBoardCnt = boardService.insertBoard(boardVO);
		
		
		
		int boardInsertFileCnt = 0; // 저장한 파일의 수
		int boardFileAllCnt = 0;	// 전체 파일의 수
		
		// 게시글 작성결과가 성공일 경우 실행
		if(insertBoardCnt == 1) {
			
			
			if(fileList.size() > 0) {
				
				for(MultipartFile file : fileList) {
					
					if(!file.getOriginalFilename().equals("")) {
						logger.debug("fileName : {}", file.getOriginalFilename());
						
						boardFileAllCnt++;
						
						
						// 파일의 진짜 이름(이름 + 확장자)
						String fileRealName = file.getOriginalFilename();
						
						// uuid
						String tempName = UUID.randomUUID().toString();
						
						// file 확장자
						String fileEx = FileUploadUtil.getExtension(fileRealName);
						
						// db에 저장할 파일의 경로와 파일의 이름 + 확장자
						String filename = "D:\\upload\\" + tempName + "." + fileEx;
						
						
						File insertFile = new File(filename);
						
						// 파일 업로드
						file.transferTo(insertFile);
						
						
						// 파일경로를 db에 저장
						fileVO = new FileVO();
						fileVO.setFILE_NAME(filename);
						fileVO.setREAL_FILE_NAME(fileRealName);
						fileVO.setBOARD_KIND_ID(Integer.parseInt(BOARD_KIND_ID));
						fileVO.setBOARD_SEQ(boardSeq);
						fileVO.setFILE_STATUS("Y");
						
						int insertFileCnt = boardService.insertBoardFile(fileVO);
						if(insertFileCnt == 1) {
							boardInsertFileCnt++;
						}
					}
				}
			}			
		}
		
		if(insertBoardCnt == 1 && boardFileAllCnt == boardInsertFileCnt) {
			String redirectpath = "redirect:/board/boardInfo?boardSeq="+boardSeq;
			return redirectpath;
		}else {
			String forwardPath = "/board/registView?boardKindId="+BOARD_KIND_ID;
			return forwardPath;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private List<FileVO> fileList = null;
	
	
	
	
	/**
	 * 게시글 수정 페이지 이동 메서드
	 */
	@RequestMapping("/boardUpdateView")
	public String boardupdateView(String boardSeq, Model model) {
		
		BoardVO boardVO = boardService.selectBoardInfo(Integer.parseInt(boardSeq));
		fileList = boardService.selectFileList(Integer.parseInt(boardSeq));
		
		if(fileList != null && fileList.size() > 0) {
			model.addAttribute("fileList", fileList);			
			model.addAttribute("boardVO", boardVO);
		}else {
			fileList = new ArrayList<FileVO>();
			model.addAttribute("fileList", fileList);
			model.addAttribute("boardVO", boardVO);
		}
		
		return "tiles/board/boardUpdate";
	}
	
	
	
	
	
	
	
	
	/**
	 * 게시글 수정 등록 메서드
	 */
	@RequestMapping(path="/boardUpdateAction", method = RequestMethod.POST)
	public String boardUpdateAction(HttpSession session, 
								    String BOARD_SEQ, 
								    String boardTitleName, 
								    String editordata, 
								    String BOARD_KIND_ID,
								    @RequestParam(name = "delFileIdInfo", required = false) String[] delFileIdInfo,
								    @RequestPart(name = "file", required = false) List<MultipartFile> fileList) throws IllegalStateException, IOException {
		
		
		MemberVO memVO = (MemberVO) session.getAttribute("MEMBER");
		
		
		
		logger.debug("delFileIdInfo : {}", (Object) delFileIdInfo);
		logger.debug("fileList : {}", (Object) fileList);
		
		
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBOARD_SEQ(Integer.parseInt(BOARD_SEQ));
		boardVO.setBOARD_TITLE(boardTitleName);
		boardVO.setBOARD_CONTENT(editordata);
		boardVO.setUSERID(memVO.getUserid());
		boardVO.setBOARD_KIND_ID(Integer.parseInt(BOARD_KIND_ID));
		boardVO.setBOARD_STATUS("Y");
		
		
		
		
		// board update
		// 파일 리스트에서 삭제한것이 있는지 확인
		List<Integer> fileIdList = null;
		if(delFileIdInfo != null) {
			fileIdList = new ArrayList<Integer>();
			for(String fileInfoId : delFileIdInfo) {
				int delFileId = Integer.parseInt(fileInfoId);
				fileIdList.add(delFileId);
			}
		}
		
		
		// 파일을 추가했는지에 대한 여부 확인
		List<FileVO> insertFileList = null;
		FileVO insertFileVO = null;
		
		
		if(fileList.size() > 0) {
			insertFileList = new ArrayList<FileVO>();
			
			for(MultipartFile file : fileList) {
				
				if(!file.getOriginalFilename().equals("")) {
					logger.debug("fileName : {}", file.getOriginalFilename());
					
					
					// 파일의 진짜 이름(이름 + 확장자)
					String fileRealName = file.getOriginalFilename();
					
					// uuid
					String tempName = UUID.randomUUID().toString();
					
					// file 확장자
					String fileEx = FileUploadUtil.getExtension(fileRealName);
					
					// db에 저장할 파일의 경로와 파일의 이름 + 확장자
					String filename = "D:\\upload\\" + tempName + "." + fileEx;
					
					
					File insertFile = new File(filename);
					
					// 파일 업로드
					file.transferTo(insertFile);
					
					
					// 파일경로를 db에 저장
					insertFileVO = new FileVO();
					insertFileVO.setFILE_NAME(filename);
					insertFileVO.setREAL_FILE_NAME(fileRealName);
					insertFileVO.setBOARD_KIND_ID(Integer.parseInt(BOARD_KIND_ID));
					insertFileVO.setBOARD_SEQ(Integer.parseInt(BOARD_SEQ));
					insertFileVO.setFILE_STATUS("Y");
					
					insertFileList.add(insertFileVO);
					
					logger.debug("insertFileVO : {}", insertFileVO);
				}
			}
		}
		
		
		Map<String, Object> updateInfoMap = new HashMap<String, Object>();
		updateInfoMap.put("boardVO", boardVO);
		updateInfoMap.put("fileIdList", fileIdList);
		updateInfoMap.put("insertFileList", insertFileList);
		
		
		
		int updateBoardCnt = boardService.updateBoardInfo(updateInfoMap);
		if(updateBoardCnt == 1) {
			String redirectpath = "redirect:/board/boardInfo?boardSeq="+BOARD_SEQ;
			return redirectpath;
		}else {
			String forwardPath = "redirect:/board/boardUpdateView?boardSeq="+BOARD_SEQ;
			return forwardPath;
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * 게시글 삭제 메서드
	 */
	@RequestMapping("/boardDelete")
	public String boardDelete(String boardSeq, String boardKindId) {
		
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBOARD_SEQ(Integer.parseInt(boardSeq));
		boardVO.setBOARD_STATUS("N");
		boardVO.setBOARD_TITLE("[삭제된 게시글 입니다.]");
		int delBoardCnt = boardService.delBoardStatus(boardVO);
		
		if(delBoardCnt == 1) {
			String delRedirectPath = "redirect:/board/boardList?boardKindId=" + boardKindId;
			return delRedirectPath;
		}else {
			String infoRedirectPath = "redirect:/board/boardInfo?boardSeq=" + boardSeq;
			return infoRedirectPath;
		}
	}
	
	
	
	

	
	

}
