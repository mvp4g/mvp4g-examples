package org.gwt4e.mvp4g.example.modules.client.product.historyConverter;

import com.mvp4g.client.annotation.History;
import com.mvp4g.client.history.HistoryConverter;
import org.gwt4e.mvp4g.example.modules.client.product.ProductEventBus;
import org.gwt4e.mvp4g.example.modules.client.product.bean.ProductBean;

@History
public class ProductHistoryConverter implements HistoryConverter<ProductEventBus> {

	public void convertFromToken( String eventType, String param, ProductEventBus eventBus ) {
		String[] paramTab = param.split( "&" );
		ProductBean product = new ProductBean();
		product.setId( Integer.parseInt( paramTab[0].split( "=" )[1] ) );
		product.setName( paramTab[1].split( "=" )[1] );
		eventBus.goToDisplay( product );
	}

	public String onGoToDisplay( ProductBean product ) {
		return convertProductToToken( product );
	}

	public String convertProductToToken( ProductBean product ) {
		return "id=" + product.getId() + "&name=" + product.getName();
	}

	public boolean isCrawlable() {
		return false;
	}

}
