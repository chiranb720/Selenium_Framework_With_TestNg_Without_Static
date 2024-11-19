package com.zapkiller.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import static com.zapkiller.automation.config.Hooks.configProps;

public class UIAutomationUtils {

    public WebDriver driver;
    public WebDriverWait wait;
    public static FileInputStream fis;

    public UIAutomationUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * <p>This method is used to read a properties / config file and its properties</p>
     * @return Properties
     * version 1.0
     */

    public static Properties readConfig(){
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config-qa.properties");
            Properties properties = new Properties();
            properties.load(fis);
            return properties;
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * <p>Clicks on provided web element</p>
     * @param element
     * @Version 1.0
     */
    public void clickElement(By element) {
//        waitForElementVisibility(element);
        driver.findElement(element).click();
    }

    /**
     * <p>Navigates to specified url within the browser</p>
     * @param url
     * @Version 1.0
     */
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    /**
     * <p>Waits for Visibility of WebElement for configured number of seconds</p>
     * @param locator
     * @Version 1.0
     */
    public void waitForElementVisibility(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(configProps.getProperty("webdriver.wait.inseconds"))));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * <p>Types or Sends Keystrokes to the mentioned Input Field</p>
     * @param locator
     * @param value
     * @Version 1.0
     */
    public void typeIntoField(By locator, String value) {
        waitForElementVisibility(locator);
        driver.findElement(locator).sendKeys(value);
    }

    /**
     * <p>Reads test data from a source and converts the same to 2D Array of values</p>
     * @param filePath
     * @param tabName
     * @return
     */
    public static String[][] readTestData(String filePath, String tabName) {
        try {
            fis = new FileInputStream(new File(filePath));
            DataFormatter formatter  = new DataFormatter();
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet(tabName);
            int rowCount = sheet.getLastRowNum();
            for(int i=1; i<=rowCount; i++) {
                int colCount = sheet.getRow(i).getLastCellNum();
                for(int j=0; j<colCount; j++) {
                    Cell cell = sheet.getRow(i).getCell(j);
                    if(cell.getCellType() == CellType.NUMERIC) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YY");
                        String formatterDate = simpleDateFormat.format(date);
                        System.out.println(formatterDate);
                    }
                    System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e); // Use Logger Statements here as per requirement
        }
        return null;
    }



}
