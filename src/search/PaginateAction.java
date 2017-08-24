package search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PaginateAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomerDAO dao = new CustomerDAO();
		int start = Integer.parseInt(request.getParameter("start"));
		request.setAttribute("list", dao.getAllcustomers(start));
		request.setAttribute("start",start);
		request.setAttribute("all", dao.countCustomers());
		return mapping.findForward("page");
	}
}
