/**
 * @(#)Login action .java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CustomerAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomerDAO dao = new CustomerDAO();
		int index = 0;
		request.setAttribute("list", dao.getAllcustomers(index));
		request.setAttribute("start",index);
		request.setAttribute("all", dao.countCustomers());
		return mapping.findForward("search");
	}
}