package com.project.pages;

import com.project.util.DriverUtils;
import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public class BasePage {

    @Autowired
    protected AppiumDriver driver;

    @Autowired
    protected TypeSecurityCodeBlock typeCodeBlock;

    @Autowired
    protected DriverUtils driverUtils;

    @Autowired
    protected HeaderBlock headerBlock;
}
