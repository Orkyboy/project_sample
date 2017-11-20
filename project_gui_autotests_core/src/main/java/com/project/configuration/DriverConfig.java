package com.project.configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by User on 15.02.2017.
 */
@Configuration
public class DriverConfig {

    @Value("${driver.timeout.default:30000}")
    private int defaultTimeout;

    @Value("${driver.name: chrome}")
    private String driverName;

    @Value("${path.to.app}")
    private String pathToApp;

    @Value("${appium.server.url}")
    private String appiumUrl;

    @Value("${base.package}")
    private String basePackage;

    @Bean(destroyMethod = "quit")
    public AppiumDriver appiumDriver() {
        File appDir = new File(pathToApp);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, basePackage);

        try {
            return new AndroidDriver<MobileElement>(new URL(appiumUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Cannot crate android driver by URL: " + appiumUrl);
        }
    }
}
