package kr.or.ddit.reple;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.vo.MemberVO;

public class RepleControllerTest extends WebTestConfig {

	
	
	
	@Test
	public void repleRegistTest() throws Exception {
		
		MemberVO member = new MemberVO();
		member.setUserid("brown");
		member.setPass("brownPass");
		
		String path = "/board/boardInfo?boardSeq="+0;
		
		
		mockMvc.perform(post("/reple/regist")
				.param("boardSeq", "0")
				.param("boardKindId", "0")
				.param("repleContent", "repleContentTest")
				.sessionAttr("MEMBER", member))
		.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl(path));
	}
	
	
	
	
	
	@Test
	public void repleDeleteTest() throws Exception {
		
		String path = "/board/boardInfo?boardSeq="+0;

		mockMvc.perform(post("/reple/delete")
							.param("repleId", "0"))
						.andDo(print())
						.andExpect(status().is3xxRedirection())
						.andExpect(redirectedUrl(path));
	}
	
	

}
