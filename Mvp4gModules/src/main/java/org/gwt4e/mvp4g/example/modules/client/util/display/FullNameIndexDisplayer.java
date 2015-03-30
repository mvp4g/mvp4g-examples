package org.gwt4e.mvp4g.example.modules.client.util.display;

public class FullNameIndexDisplayer implements IndexDisplayer {

	private String[] display = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };

	public String getDisplay( int value ) {
		return display[value % display.length];
	}

}
