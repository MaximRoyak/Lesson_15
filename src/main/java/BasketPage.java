import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(150));
    }

    private By fieldF = By.xpath("//*[text() = \"Ароматизатор для дома с палочками аромадиффузор\"]");
    private By fieldS = By.xpath("//*[text() = \"Тонометр автоматический электронный для измерения давления\"]");
    private By fieldT = By.xpath("//*[text() = \"Гидрофильное гель-масло для умывания и очищения лица\"]");

    private By prodFirstPrice = By.xpath("//ins[contains(text(),280)]");
    private By prodSecPrice = By.xpath("//ins[contains(text(),538)]");
    private By prodThirdPrice = By.xpath("//ins[contains(text(),437)]");
    private By totalPrice = By.xpath("//span[contains(text(), 308)]");

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldF));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
    }

    public String getFieldFText() {
        return driver.findElement(fieldF).getText();
    }

    public String getFeildSText() {
        return driver.findElement(fieldS).getText();
    }

    public String getFieldTText() {
        return driver.findElement(fieldT).getText();
    }

    public String getFirstProductPrice() {
        return driver.findElement(prodFirstPrice).getText();
    }

    public String getSecondProductPrice() {
        return driver.findElement(prodSecPrice).getText();
    }

    public String getThirdProductPrice() {
        return driver.findElement(prodThirdPrice).getText();
    }
    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }
}

