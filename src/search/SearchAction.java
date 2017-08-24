package search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SearchAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("ACTION SEARCH");
		SearchForm searchForm = (SearchForm) form;
		SearchDAO dao = new SearchDAO();
		List<CustomerForm> list = dao.searchCustomers(searchForm);
		System.out.println(list.toString());
		request.setAttribute("list", list);
		request.setAttribute("start", 0);
		request.setAttribute("all", 0);
		return mapping.findForward("result");
	}
}
