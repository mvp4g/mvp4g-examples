package org.gwt4e.mvp4g.example.modules.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.gwt4e.mvp4g.example.modules.client.company.CompanyService;
import org.gwt4e.mvp4g.example.modules.client.company.bean.CompanyBean;

public class CompanyServiceImpl extends RemoteServiceServlet implements CompanyService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4546417863195659071L;

	public void deleteCompany( CompanyBean company ) {
		// TODO Auto-generated method stub
	}

	public List<CompanyBean> getCompanies(int start, int end) {
		List<CompanyBean> companies = new ArrayList<CompanyBean>();
		for ( int i = start; i <= end; i++ ) {
			companies.add( new CompanyBean( i, "Company " + i ) );
		}
		return companies;
	}

	public void updateCompany( CompanyBean company ) {
		// TODO Auto-generated method stub
	}

	public void createCompany( CompanyBean company ) {
		// TODO Auto-generated method stub		
	}

}
