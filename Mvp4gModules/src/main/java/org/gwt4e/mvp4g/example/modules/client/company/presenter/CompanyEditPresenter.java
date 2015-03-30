package org.gwt4e.mvp4g.example.modules.client.company.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.history.NavigationConfirmationInterface;
import com.mvp4g.client.history.NavigationEventCommand;
import org.gwt4e.mvp4g.example.modules.client.company.bean.CompanyBean;
import org.gwt4e.mvp4g.example.modules.client.company.view.CompanyEditView;

@Presenter( view = CompanyEditView.class )
public class CompanyEditPresenter extends AbstractCompanyPresenter implements NavigationConfirmationInterface {

	public void onGoToEdit( CompanyBean company ) {
		this.company = company;
		fillView();
		eventBus.changeBody( view );
	}

	public void onNameSelected( String name ) {
		view.getName().setValue( name );
		view.alert( "Name changed on edit page." );
	}

	@Override
	protected void clickOnLeftButton( ClickEvent event ) {
		fillBean();
		service.updateCompany( company, new AsyncCallback<Void>() {

			public void onSuccess( Void result ) {
				eventBus.setNavigationConfirmation( null );
				eventBus.companyUpdated( company );
				eventBus.backToList();
				eventBus.displayMessage( "Update Succeeded" );
			}

			public void onFailure( Throwable caught ) {
				eventBus.displayMessage( "Update Failed" );
			}
		} );
	}

	@Override
	protected void clickOnRightButton( ClickEvent event ) {
		clear();
	}

	@Override
	public void onBeforeEvent() {
		eventBus.setNavigationConfirmation( this );
	}
	
	public void confirm( NavigationEventCommand event ) {
		if ( ( view.getName().getValue().equals( company.getName() ) )
				|| ( view.confirm( " Your company hasn't been saved. Are you sure you want to navigate away from this page?" ) ) ) {
			event.fireEvent();
		}
	}

}
