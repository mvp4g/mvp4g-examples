package org.gwt4e.mvp4g.example.modules.client.main;

import com.mvp4g.client.Mvp4gSplitter;
import com.mvp4g.client.annotation.module.Loader;
import org.gwt4e.mvp4g.example.modules.client.main.presenter.MainPresenter;

@Loader( MainPresenter.class )
public interface StatusSplitter extends Mvp4gSplitter {

}
