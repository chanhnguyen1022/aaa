package search;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DeletedAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomerDAO dao = new CustomerDAO();
		String data = request.getParameter("data");
		ArrayList<Integer> isCus = idCustomers(data);
		for(int i : isCus){
			dao.deleted(i);
		}
		
		return mapping.findForward("search");
	}
	
	public ArrayList<Integer> idCustomers(String data){
		ArrayList<Integer> isCus = new ArrayList<Integer>();
		StringTokenizer strto = new StringTokenizer(data, "-");
		while(strto.hasMoreTokens()){
			isCus.add(Integer.parseInt(strto.nextToken()));
		}
		return isCus;
	}
}
