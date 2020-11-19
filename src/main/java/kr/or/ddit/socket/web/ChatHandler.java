package kr.or.ddit.socket.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class ChatHandler 
//extends TextWebSocketHandler 
{

//	private static final Logger logger = LoggerFactory.getLogger(ChatHandler.class);
//	
//	
//	//세션 리스트
//	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
//	
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		
//		logger.debug("");
//		logger.debug("");
//		logger.debug("=============================================");
//		logger.debug("일단 옴");
//		logger.debug("=============================================");
//		logger.debug("");
//		logger.debug("");
//		
//		sessionList.add(session);
//		
//		// 모든 세션에 채팅 전달
//		for (int i = 0; i < sessionList.size(); i++) {
//			WebSocketSession s = sessionList.get(i);
//			s.sendMessage(new TextMessage(session.getId() + "님이 입장 했습니다."));
//		}
//	}
//	
//	@Override
//	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//		for(WebSocketSession sess: sessionList) {
//			sess.sendMessage(new TextMessage(session.getId()+": "+message.getPayload()));
//		}
//	}
//	
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		sessionList.remove(session);
//		
//		// 모든 세션에 채팅 전달
//		for (int i = 0; i < sessionList.size(); i++) {
//			WebSocketSession s = sessionList.get(i);
//			s.sendMessage(new TextMessage(session.getId() + "님이 퇴장 했습니다."));
//		}
//	}
	
	
	
}
