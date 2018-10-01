import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
public class EbayTest {

private static WebDriver driver;
    WebDriverWait wait;
    @Before
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
         driver = new ChromeDriver();
       wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }


    @Test
    public void testWebsite() {
        driver.get("http://www.ebay.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-ug")));
        driver.findElement(By.id("gh-ug")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sgnBt")));
        driver.findElement(By.id("userid")).sendKeys("ebay198@yandex.ru");
        driver.findElement(By.id("pass")).sendKeys("ebay123456");
        driver.findElement(By.id("sgnBt")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-btn")));
        driver.findElement(By.id("gh-ac")).sendKeys("samsung");
        driver.findElement(By.id("gh-btn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("e1-60")));
        driver.findElement(By.id("e1-60")).sendKeys(Keys.SPACE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("e1-67")));
        driver.findElement(By.id("e1-67")).sendKeys(Keys.SPACE);

        String text = driver.findElement(By.className("lvtitle")).getText().toLowerCase();
        boolean textcheck = text.contains("samsung");
        int count = Integer.parseInt(driver.findElement(By.className("rcnt")).getText().replaceAll(",", ""));
        assertNotNull(text);
        assertEquals(21, count);
        assertTrue(textcheck);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-ug")));
        driver.findElement(By.id("gh-ug")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign out")));
        driver.findElement(By.linkText("Sign out")).click();

        String textSignIn = driver.findElement(By.id("gh-eb-u")).getText();
        boolean checkSignIn = textSignIn.contains("Sign in");
        assertTrue(checkSignIn);

    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
