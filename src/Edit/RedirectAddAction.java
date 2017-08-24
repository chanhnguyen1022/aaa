/**
 *@author chanh-nm,
 * @(#)Connect database .java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 * Version 1.1.a
 */
package Edit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class RedirectAddAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EditForm editForm = new EditForm();
		request.setAttribute("editForm", editForm);
		request.setAttribute("action", "processAdd.do");
		return mapping.findForward("add");

	}
}