package org.gwt4e.mvp4g.example.modules.client.util.token;

public class BaseTokenGenerator implements TokenGenerator{

	public String convertFromToken( String token ) {
		return token.split( "=" )[1];
	}

	public String convertToToken( String name, String value ) {
		return name + "=" + value;
	}

}
