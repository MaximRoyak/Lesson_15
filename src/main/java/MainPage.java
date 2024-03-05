import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private By productFirst = By.xpath("//*[text() = \"Ароматизатор для дома с палочками аромадиффузор\"]");
    private By productSec = By.xpath("//*[text() = \"Тонометр автоматический электронный для измерения давления\"]");
    private By productThird = By.xpath("//*[text() = \"Гидрофильное гель-масло для умывания и очищения лица\"]");

    public void clickProduct() {
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(productFirst));
        firstProduct.click();

        WebElement secondProduct = wait.until(ExpectedConditions.elementToBeClickable(productSec));
        secondProduct.click();

        WebElement thirdProduct = wait.until(ExpectedConditions.elementToBeClickable(productThird));
        thirdProduct.click();
    }
    public BasketPage clickBasket() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement basketIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-wba-header-name = 'Cart']")));
        basketIcon.click();

        return new BasketPage(driver);
    }

}


