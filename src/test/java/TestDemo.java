import com.demo.DashboardPage;
import com.demo.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo {
    private String baseUrl = "https://fortigate.fortidemo.com/";
    private WebDriver driver;

    /**
     * Sets the driver to ChromeDriver and Launches the browser to fortigate.com
     */
    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    /**
     * Tests login.
     * Expected output:
     *      Dashboard page and username of 'demo'
     */
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("demo", "demo");
        Assert.assertEquals(dashboardPage.getProfileName(), "demo");
    }
}
