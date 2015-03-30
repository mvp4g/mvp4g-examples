package org.gwt4e.mvp4g.example.modules.client.product;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.gwt4e.mvp4g.example.modules.client.product.bean.ProductBean;

@RemoteServiceRelativePath( "product" )
public interface ProductService extends RemoteService {

	public List<ProductBean> getProducts(int start,
																			 int end);

	public void createProduct(ProductBean product);

	public void deleteProduct(ProductBean product);

	public void updateProduct(ProductBean product);

}
