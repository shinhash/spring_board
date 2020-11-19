package kr.or.ddit.board;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.vo.MemberVO;

public class BoardControllerTest extends WebTestConfig{

	@Test
	public void boardMainTest() throws Exception {
		mockMvc.perform(get("/board/main"))
						.andExpect(status().isOk())
						.andExpect(view().name("tiles/layout/main_content"));
	}
	
	
	
	@Test
	public void myboardViewTest() throws Exception {
		MemberVO member = new MemberVO("brown", "brownPass", "", "", "", "", "", "", "");
		mockMvc.perform(get("/board/myboardView").sessionAttr("MEMBER", member))
						.andExpect(status().isOk())
						.andExpect(view().name("tiles/board/boardCreate"));
	}
	
	
	
	@Test
	public void boardCreateTest() throws Exception {
		MemberVO member = new MemberVO("brown", "brownPass", "", "", "", "", "", "", "");
		mockMvc.perform(get("/board/boardCreate").sessionAttr("MEMBER", member).param("addboardName", "test").param("board_use", "Y"))
						.andExpect(status().is3xxRedirection())
						.andExpect(redirectedUrl("/board/myboardView"));
	}
	
	
	
	
	@Test
	public void boardUpdateTest() throws Exception {
		mockMvc.perform(get("/board/boardKindUpdate").param("boardUse", "N").param("upBoardKindId", "0"))
						.andExpect(status().is3xxRedirection())
						.andExpect(redirectedUrl("/board/myboardView"));
	}
	
	
	
	
	
	@Test
	public void boardListTest() throws Exception {
		mockMvc.perform(get("/board/boardList").param("boardKindId", "0").param("pageNum", "1"))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(view().name("tiles/board/boardPageList"));
	}
	
	
	
	
	
	@Test
	public void boardInfoTest() throws Exception {
		mockMvc.perform(get("/board/boardInfo").param("boardSeq", "0"))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(view().name("tiles/board/boardInfo"));
	}
	
	
	
	@Test
	public void registViewTest() throws Exception {
		mockMvc.perform(get("/board/registView").param("boardPseq", "0").param("boardKindId", "0"))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(view().name("tiles/board/boardRegist"));
	}
	
	
	
	
	
	@Test
	public void registActionTest() throws Exception {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		MockMultipartFile file = new MockMultipartFile("file", "sally.png", "image/png", is);
		
		MemberVO member = new MemberVO();
		member.setUserid("brown");
		member.setPass("brownPass");
		
		
		String path = "/board/boardInfo?boardSeq="+1;
		
		mockMvc.perform(fileUpload("/board/registAction")
							.file(file)
							.param("boardTitle", "titleTest")
							.param("editordata", "contentTest")
							.param("BOARD_KIND_ID", "0")
							.param("boardPseq", "0")
							.sessionAttr("MEMBER", member))
						.andDo(print())
						.andExpect(status().is3xxRedirection())
						.andExpect(redirectedUrl(path));
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void boardUpdateViewTest() throws Exception {
		mockMvc.perform(get("/board/boardUpdateView").param("boardSeq", "0"))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(view().name("tiles/board/boardUpdate"));
	}
	
	
	@Test
	public void boardDeleteTest() throws Exception {
		
		String path = "/board/boardList?boardKindId=" + 0;
		
		mockMvc.perform(get("/board/boardDelete").param("boardSeq", "0").param("boardKindId", "0"))
						.andDo(print())
						.andExpect(status().is3xxRedirection())
						.andExpect(redirectedUrl(path));
	}
	
	
	
	@Test
	public void boardUpdateActionTest() throws Exception {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		MockMultipartFile file = new MockMultipartFile("file", "sally.png", "image/png", is);
		
		MemberVO member = new MemberVO();
		member.setUserid("brown");
		member.setPass("brownPass");
		
		
		String path = "/board/boardInfo?boardSeq="+0;
		
		mockMvc.perform(fileUpload("/board/boardUpdateAction")
							.file(file)
							.param("BOARD_SEQ", "0")
							.param("boardTitleName", "titleTest")
							.param("editordata", "contentTest작성")
							.param("BOARD_KIND_ID", "0")
							.param("delFileIdInfo", "1")
							.sessionAttr("MEMBER", member))
						.andDo(print())
						.andExpect(status().is3xxRedirection())
						.andExpect(redirectedUrl(path));
	}
	
	
	

}
