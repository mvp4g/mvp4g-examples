package org.gwt4e.mvp4g.example.modules.client.util.token;

public interface TokenGenerator {
	
	public String convertToToken(String name,
															 String value);
	
	public String convertFromToken(String token);

}
