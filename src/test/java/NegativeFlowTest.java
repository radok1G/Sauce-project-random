import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NegativeFlowTest {
    public WebDriver driver;

    @Test

    public void testMethodNegativ(){
        driver = DriverHelper.createDriver();
        LoginHelper.login(driver, "locked_out_user", "secret_sauce");

        System.out.println("Daca nu te poti loga, inseamna ca e problema la account si testul trece.");
        System.out.println("Mersi, like, subscribe, share la Alex Dorha @ IT School ca o fost momente cand era sa plang da acuma-i bine ca nu mai is momente, plang intruna");

        driver.quit();

    }
}
