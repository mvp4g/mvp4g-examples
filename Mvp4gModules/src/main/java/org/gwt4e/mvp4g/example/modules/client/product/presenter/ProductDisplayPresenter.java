package org.gwt4e.mvp4g.example.modules.client.product.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.Presenter;
import org.gwt4e.mvp4g.example.modules.client.product.bean.ProductBean;
import org.gwt4e.mvp4g.example.modules.client.product.view.ProductDisplayView;

@Presenter( view = ProductDisplayView.class )
public class ProductDisplayPresenter extends AbstractProductPresenter {

	public void onGoToDisplay( ProductBean product ) {
		displayProduct( product );
		eventBus.selectProductMenu();
	}

	@Override
	protected void clickOnLeftButton( ClickEvent event ) {
		eventBus.goToEdit( product );
	}

	@Override
	protected void clickOnRightButton( ClickEvent event ) {
		fillBean();
		service.deleteProduct( product, new AsyncCallback<Void>() {

			public void onSuccess( Void result ) {
				eventBus.productDeleted( product );
				eventBus.backToList();
			}

			public void onFailure( Throwable caught ) {
				eventBus.displayMessage( "Deletion Failed" );
			}
		} );
	}

	private void displayProduct( ProductBean product ) {
		this.product = product;
		fillView();
		eventBus.changeBody( view );
	}
	
	@Override
	protected String getPageName() {
		return "Product Display Page";
	}

}
