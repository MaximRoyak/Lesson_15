import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



    public class MainPageTest {

        private WebDriver driver;
        private MainPage mainPage;

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\AS USER\\Desktop\\1111\\Lesson_15\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.wildberries.ru");
            mainPage = new MainPage(driver);
        }

        @Test
        public void basketIn() {
            BasketPage basketPage = mainPage.clickBasket();
            basketPage.waitForPageToLoad();

            Assert.assertEquals("Ароматизатор для дома с палочками аромадиффузор", basketPage.getFieldFText());
            Assert.assertEquals("Тонометр автоматический электронный для измерения давления", basketPage.getFeildSText());
            Assert.assertEquals("Гидрофильное гель-масло для умывания и очищения лица", basketPage.getFieldTText());

            Assert.assertEquals("280", basketPage.getFirstProductPrice());
            Assert.assertEquals("538", basketPage.getSecondProductPrice());
            Assert.assertEquals("437", basketPage.getThirdProductPrice());

            String actualTotalPrice = basketPage.getTotalPrice();
            Assert.assertEquals("1308", actualTotalPrice);
        }


        @After
        public void tearDown() {
            driver.quit();
        }
    }
