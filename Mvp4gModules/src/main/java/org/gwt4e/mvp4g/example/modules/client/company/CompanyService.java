package org.gwt4e.mvp4g.example.modules.client.company;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.gwt4e.mvp4g.example.modules.client.company.bean.CompanyBean;

@RemoteServiceRelativePath( "company" )
public interface CompanyService extends RemoteService {

	public List<CompanyBean> getCompanies(int start,
																				int end);

	public void createCompany(CompanyBean company);

	public void deleteCompany(CompanyBean company);

	public void updateCompany(CompanyBean company);

}
