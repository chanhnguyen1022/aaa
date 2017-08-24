/**
 * @(#)Login action .java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UserLoginAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("DSFSJKTHGWRGE..");
		UserLoginForm loginForm = (UserLoginForm) form;

		String username = loginForm.getUserId();
		String password = loginForm.getPassword();
		System.out.println(username);
		System.out.println(password);
		UserLoginDAO dao = new UserLoginDAO();
		if (dao.authenticate(username, password)) {
			HttpSession se=request.getSession();
			se.setAttribute("username",username);
			return mapping.findForward("success");
		}
		return mapping.findForward("failure");
	}
	
}