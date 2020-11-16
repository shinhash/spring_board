package kr.or.ddit.board;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

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
	
	
	
	

}
