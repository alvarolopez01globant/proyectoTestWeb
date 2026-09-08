package com.globant.saucedo.utils;

import com.globant.saucedo.config.ConfigurationManager;
import com.globant.saucedo.driver.DriverManager;
import com.globant.saucedo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Clase base para pruebas UI con TestNG.
 * Gestiona las precondiciones y limpieza del navegador por cada test.
 */
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;

    /**
     * Inicializa el navegador y navega a SauceDemo antes de cada caso de prueba.
     */
    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigurationManager.getUrl());
        loginPage = new LoginPage(driver);
    }

    /**
     * Cierra el navegador al finalizar cada caso de prueba.
     */
    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
