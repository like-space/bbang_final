package spms.controller;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MySqlProductDAO;

@Component("/detaillist.do")
public class ProductDetailController implements Controller, DataBinding {
	/*
	 * DI(Dependency Injection) 1) Ŭ������ ���յ� ���� 2) MemberDAO �������̽��� �����ϰ� ��ӱ����ϹǷν� �ٸ�
	 * DBMS���� ��ȯ ���� 3) ���߿� ������ �ڵ�ȭ �۾��� ���
	 */

	MySqlProductDAO productDAO = null;

	public ProductDetailController setProdectDAO(MySqlProductDAO productDAO) {
		this.productDAO = productDAO;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"detail_path", String.class	
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		model.put("detail_path", (String)model.get("detail_path"));
		return "/product/new-item1.jsp";
	}
}