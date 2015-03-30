package org.gwt4e.mvp4g.example.modules.client.product;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBus;
import com.mvp4g.client.presenter.NoStartPresenter;
import org.gwt4e.mvp4g.example.modules.client.company.CompanyModule;
import org.gwt4e.mvp4g.example.modules.client.product.bean.ProductBean;
import org.gwt4e.mvp4g.example.modules.client.product.presenter.ProductCreationPresenter;
import org.gwt4e.mvp4g.example.modules.client.product.presenter.ProductDisplayPresenter;
import org.gwt4e.mvp4g.example.modules.client.product.presenter.ProductEditPresenter;
import org.gwt4e.mvp4g.example.modules.client.product.presenter.ProductListPresenter;
import org.gwt4e.mvp4g.example.modules.client.util.HasBeenThereHandler;

@Events( startPresenter = NoStartPresenter.class, module = ProductModule.class )
public interface ProductEventBus extends EventBus {

	/* Navigation events */
	@Event( handlers = ProductCreationPresenter.class, navigationEvent = true )
	void goToCreation();

	@Event( handlers = ProductListPresenter.class, navigationEvent = true )
	void backToList();

	@Event( handlers = ProductEditPresenter.class, navigationEvent = true )
	void goToEdit(ProductBean product);

	@Event( handlers = ProductDisplayPresenter.class, navigationEvent = true )
	void goToDisplay(ProductBean product);

	@Event( handlers = ProductListPresenter.class, navigationEvent = true )
	void goToProduct(Integer start,
									 Integer end);

	/* Business events */
	@Event( forwardToParent = true )
	void displayMessage(String message);

	@Event( forwardToParent = true )
	void changeBody(IsWidget body);

	@Event( forwardToParent = true )
	void selectProductMenu();

	@Event( handlers = ProductListPresenter.class )
	void productCreated(ProductBean product);

	@Event( handlers = ProductListPresenter.class )
	void productDeleted(ProductBean product);

	@Event( broadcastTo = HasBeenThereHandler.class, passive = true )
	void hasBeenThere();

	@Event( handlers = ProductListPresenter.class )
	void goToProduct2(String[] indexes);
	
	@Event( broadcastTo = HasBeenThereHandler.class, passive = true )
	void broadcastInfo(String[] info);
	
	@Event(forwardToModules = CompanyModule.class)
	void goToCompanyFromProduct(String info);
	
	@Event( broadcastTo = Mvp4gModule.class )
	void broadcastInfoFromProduct(String info);
	
	@Event( broadcastTo = Mvp4gModule.class, passive = true )
	void broadcastInfoFromProductPassive(String info);

}
