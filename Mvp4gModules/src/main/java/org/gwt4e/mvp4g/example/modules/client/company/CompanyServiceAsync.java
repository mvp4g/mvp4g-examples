package org.gwt4e.mvp4g.example.modules.client.company;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.gwt4e.mvp4g.example.modules.client.company.bean.CompanyBean;

public interface CompanyServiceAsync {

	void getCompanies(int start,
										int end,
										AsyncCallback<List<CompanyBean>> async);

	void deleteCompany(CompanyBean company,
										 AsyncCallback<Void> callback);

	void updateCompany(CompanyBean company,
										 AsyncCallback<Void> callback);

	void createCompany(CompanyBean company,
										 AsyncCallback<Void> callback);
}
