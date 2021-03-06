/*
 * Copyright (c) 2020. All rights reserved.
 */

package simple;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;

/**
 * The <code>GameAppLauncher</code> class allows required runtime
 * components to be loaded properly.
 * 
 * @author marco.mangan@gmail.com
 * 
 * @see https://openjfx-dev.openjdk.java.narkive.com/aFiw9uqi/error-javafx-runtime-components-are-missing-and-are-required-to-run-this-application
 */

public final class GameAppLauncher {
	/** */
	private static final Logger LOGGER = Logger.getLogger(GameAppLauncher.class.getName());

	/** */
	private GameAppLauncher() {
	}

	/**
	 * 
	 * @param args not used
	 */
	public static void main(final String... args) {
		LOGGER.setLevel(Level.ALL);
		LOGGER.info("Starting application launcher: " + LOGGER.getName());
		Application.launch(GameApp.class, args);
		LOGGER.info("Ending application launcher: " + LOGGER.getName());
	}
}
