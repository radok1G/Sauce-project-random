import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper {

    public static void login(WebDriver driver, String username, String password) {
        driver.get("https://saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
}