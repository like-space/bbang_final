package spms.controller;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.MySqlEventDAO;


@Component("/event/list.do")
public class EventListController implements Controller {
	/*
	 * DI(Dependency Injection)
	 * 1) Ŭ������ ���յ� ����
	 * 2) MemberDAO �������̽��� �����ϰ� ��ӱ����ϹǷν� �ٸ� DBMS���� ��ȯ ����
	 * 3) ���߿� ������ �ڵ�ȭ �۾��� ���
	 * */
	
	MySqlEventDAO eventDAO = null;
	
	public EventListController setProdectDAO(MySqlEventDAO eventDAO) {
		this.eventDAO = eventDAO;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		//���ϵ� ��ȸ ��� �ʿ� ����
		model.put("eventList", eventDAO.selectlist());
		
		return "/event/eventList.jsp";
	}
}