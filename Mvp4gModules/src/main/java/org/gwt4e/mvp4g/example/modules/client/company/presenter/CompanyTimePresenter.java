package org.gwt4e.mvp4g.example.modules.client.company.presenter;

import com.mvp4g.client.SingleSplitter;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import org.gwt4e.mvp4g.example.modules.client.company.CompanyEventBus;
import org.gwt4e.mvp4g.example.modules.client.company.view.CompanyTimeView;

@Presenter( view = CompanyTimeView.class, async = SingleSplitter.class )
public class CompanyTimePresenter extends BasePresenter<CompanyTimePresenter.ICompanyTimeView, CompanyEventBus> {

	public interface ICompanyTimeView {
		void showTime();
	}

	public void onShowStatus(String status) {
		view.showTime();
	}

}
