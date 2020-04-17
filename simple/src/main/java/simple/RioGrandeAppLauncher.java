package simple;

import javafx.application.Application;

/**
 * 
 * @author marco.mangan@gmail.com
 * 
 * https://openjfx-dev.openjdk.java.narkive.com/aFiw9uqi/error-javafx-runtime-components-are-missing-and-are-required-to-run-this-application
 */
public final class RioGrandeAppLauncher {

	/**
	 * 
	 */
	private RioGrandeAppLauncher() {
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(final String... args) {
		Application.launch(RioGrandeApp.class, args);
	}
}
