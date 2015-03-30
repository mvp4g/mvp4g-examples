package org.gwt4e.mvp4g.example.modules.client.company.history;

import com.mvp4g.client.annotation.History;
import com.mvp4g.client.annotation.History.HistoryConverterType;
import com.mvp4g.client.history.HistoryConverter;
import org.gwt4e.mvp4g.example.modules.client.company.CompanyEventBus;

@History( type = HistoryConverterType.NONE )
public class CompanyCreationHistoryConverter implements HistoryConverter<CompanyEventBus> {

	public void convertFromToken( String eventType, String param, CompanyEventBus eventBus ) {
		eventBus.goToCreation();
	}

	public boolean isCrawlable() {
		return true;
	}

}
