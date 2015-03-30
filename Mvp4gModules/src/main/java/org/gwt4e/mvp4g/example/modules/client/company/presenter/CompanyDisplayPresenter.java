package org.gwt4e.mvp4g.example.modules.client.company.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.Presenter;
import org.gwt4e.mvp4g.example.modules.client.company.bean.CompanyBean;
import org.gwt4e.mvp4g.example.modules.client.company.view.CompanyDisplayView;

@Presenter( view = CompanyDisplayView.class )
public class CompanyDisplayPresenter extends AbstractCompanyPresenter {

	public void onGoToDisplay( CompanyBean company ) {
		displayCompany( company );		
	}

	public void onCompanyCreated( CompanyBean company ) {
		displayCompany( company );
	}
	
	public void onNameSelected( String name ){
		view.alert( "Selected a name on the display page does nothing, sorry." );
	}

	@Override
	protected void clickOnLeftButton( ClickEvent event ) {
		eventBus.goToEdit( company );
	}

	@Override
	protected void clickOnRightButton( ClickEvent event ) {
		fillBean();
		service.deleteCompany( company, new AsyncCallback<Void>() {

			public void onSuccess( Void result ) {
				eventBus.companyDeleted( company );
				eventBus.backToList();
			}

			public void onFailure( Throwable caught ) {
				eventBus.displayMessage( "Deletion Failed" );
			}
		} );
	}

	private void displayCompany( CompanyBean company ) {
		this.company = company;
		fillView();
		eventBus.changeBody( view );
	}

}
