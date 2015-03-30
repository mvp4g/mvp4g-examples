package org.gwt4e.mvp4g.example.modules.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.gwt4e.mvp4g.example.modules.client.product.ProductService;
import org.gwt4e.mvp4g.example.modules.client.product.bean.ProductBean;

public class ProductServiceImpl extends RemoteServiceServlet implements ProductService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4546417863195659071L;

	public void deleteProduct( ProductBean product ) {
		// TODO Auto-generated method stub
	}

	public List<ProductBean> getProducts( int start, int end ) {
		List<ProductBean> companies = new ArrayList<ProductBean>();
		for ( int i = start; i <= end; i++ ) {
			companies.add( new ProductBean( i, "Product " + i ) );
		}
		return companies;
	}

	public void updateProduct( ProductBean product ) {
		// TODO Auto-generated method stub
	}

	public void createProduct( ProductBean product ) {
		// TODO Auto-generated method stub		
	}

}
