import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HappyFlowTest {
    public WebDriver driver;

    @Test
    public void testMethod() {
        driver = DriverHelper.createDriver();
        LoginHelper.login(driver, "standard_user", "secret_sauce");

        ActiuniHelper.clickPePozitieDinCart(driver, 0, 2);
        ActiuniHelper.deschideCart(driver);

        ActiuniHelper.assertRemoveCount(driver, 2, "Ar trebui să fie 2 produse în coș înainte de remove. Daca ai doua produse inainte de remove inseamna ca ii ok, daca nu, nu esti creier");
        ActiuniHelper.removeFromCartByPozitie(driver, 1);
        ActiuniHelper.assertRemoveCount(driver, 1, "Ar trebui să fie 1 produs în coș după remove. Daca ai numa un produs inseamna ca esti creier");

        ActiuniHelper.continueShoppingButton(driver);
        ActiuniHelper.logout(driver);

        driver.quit();
    }
}