package com.bhakti.orangehrm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Environment {

	private static final Logger LOGGER = LogManager.getLogger(Environment.class);
	private static Environment INSTANCE = new Environment();
	private static final String PROPERTY_FILE = "selenium.properties";
	private Properties properties = new Properties();

	private Environment() {
		try (InputStream inputStream = Environment.class.getClassLoader().getResourceAsStream(PROPERTY_FILE)) {
			if (Objects.isNull(inputStream)) {
				LOGGER.warn("Sorry, unable to find {}", PROPERTY_FILE);
				return;
			}
			properties.load(inputStream);
		} catch (IOException e) {
			LOGGER.error("Error while loading the {} file. ErrorMessage: {}", PROPERTY_FILE, e.getMessage());
			e.printStackTrace();
		}
	}

	public static Environment getInstance() {
		return INSTANCE;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}
}
