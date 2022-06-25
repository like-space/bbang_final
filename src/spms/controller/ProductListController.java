package spms.controller;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.MySqlProductDAO;

@Component("/production/list.do")
public class ProductListController implements Controller {
	/*
	 * DI(Dependency Injection) 1) Ŭ������ ���յ� ���� 2) MemberDAO �������̽��� �����ϰ� ��ӱ����ϹǷν� �ٸ�
	 * DBMS���� ��ȯ ���� 3) ���߿� ������ �ڵ�ȭ �۾��� ���
	 */

	MySqlProductDAO productDAO = null;

	public ProductListController setProdectDAO(MySqlProductDAO productDAO) {
		this.productDAO = productDAO;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// ���ϵ� ��ȸ ��� �ʿ� ����
		model.put("productList", productDAO.selectlist());
		String pageNo = (String) model.get("pageNo");

		if (pageNo != null && pageNo.equals("0")) {
			return "/new-item.jsp";
		} else {

			return "/production/productList.jsp";
		}
	}
}