package org.gwt4e.mvp4g.example.modules.client.company;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.HistoryName;
import com.mvp4g.client.annotation.module.Loader;
import org.gwt4e.mvp4g.example.modules.client.main.presenter.MainPresenter;
import org.gwt4e.mvp4g.example.modules.client.util.HasBeenThereHandler;

@Loader( MainPresenter.class )
@HistoryName( "company" )
public interface CompanyModule extends Mvp4gModule,
                                       HasBeenThereHandler {

}
