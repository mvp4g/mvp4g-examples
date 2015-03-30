package org.gwt4e.mvp4g.example.modules.client.product;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.gwt4e.mvp4g.example.modules.client.product.bean.ProductBean;

public interface ProductServiceAsync {

	void getProducts(int start,
									 int end,
									 AsyncCallback<List<ProductBean>> async);

	void deleteProduct(ProductBean product,
										 AsyncCallback<Void> callback);

	void updateProduct(ProductBean product,
										 AsyncCallback<Void> callback);

	void createProduct(ProductBean product,
										 AsyncCallback<Void> callback);
}
