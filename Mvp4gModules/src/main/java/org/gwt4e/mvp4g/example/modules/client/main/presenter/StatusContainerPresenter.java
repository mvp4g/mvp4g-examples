package org.gwt4e.mvp4g.example.modules.client.main.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import org.gwt4e.mvp4g.example.modules.client.main.MainEventBus;
import org.gwt4e.mvp4g.example.modules.client.main.StatusSplitter;
import org.gwt4e.mvp4g.example.modules.client.main.view.StatusContainerView;

@Presenter( view = StatusContainerView.class, async = StatusSplitter.class )
public class StatusContainerPresenter extends BasePresenter<StatusContainerPresenter.IStatusContainerView, MainEventBus> {

	public interface IStatusContainerView {

		void showPopup();

	}

	public void onShowStatus( String info) {
		view.showPopup();
	}

}
