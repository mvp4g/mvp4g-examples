package org.gwt4e.mvp4g.example.modules.client.main.presenter;

import java.util.Date;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import org.gwt4e.mvp4g.example.modules.client.main.MainEventBus;
import org.gwt4e.mvp4g.example.modules.client.main.StatusSplitter;
import org.gwt4e.mvp4g.example.modules.client.main.view.DateView;
import org.gwt4e.mvp4g.example.modules.client.util.HasBeenThereHandler;

@Presenter( view = DateView.class, async = StatusSplitter.class )
public class DatePresenter extends BasePresenter<DatePresenter.IDateView, MainEventBus> implements HasBeenThereHandler {

	public interface IDateView {

		void setDate(Date date);

	}

	public void bind() {
		// doesn't make sense to call this in the bind method but I'm just tested this method is correctly called.
		setDate();
	}

	public void onHasBeenThere() {
		setDate();
	}

	public void onBroadcastInfo( String[] info ) {
		setDate();
	}

	private void setDate() {
		view.setDate( new Date() );
	}

}
