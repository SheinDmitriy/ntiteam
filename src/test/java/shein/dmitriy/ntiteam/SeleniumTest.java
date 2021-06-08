package shein.dmitriy.ntiteam;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080");
    }

    @Test
    public void governorTableResultCheck(){
        WebElement element = driver.findElement(By.id("gov"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void planetTableResultCheck(){
        WebElement element = driver.findElement(By.id("plan"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void topTableResultCheck(){
        WebElement element = driver.findElement(By.id("top"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void slackersTableResultCheck(){
        WebElement element = driver.findElement(By.id("slac"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void addGovernorTest(){
        WebElement nameGovernor = driver.findElement(By.id("add_gover_name_field"));
        WebElement ageGovernor = driver.findElement(By.id("add_gover_age_field"));
        WebElement addGovernorButton = driver.findElement(By.id("add_gover_button"));
        List<WebElement> rowsOld = driver.findElements(By.id("gov"));
        nameGovernor.sendKeys("test");
        ageGovernor.sendKeys("12");
        addGovernorButton.click();
        List<WebElement> rowsNew = driver.findElements(By.id("gov"));
        Assert.assertEquals(rowsNew.size() - rowsOld.size(), 1);
    }

    @Test
    public void addPlanetTest(){
        WebElement namePlanet = driver.findElement(By.id("add_planet_name_field"));
        WebElement addPlanetButton = driver.findElement(By.id("add_planet_button"));
        List<WebElement> rowsOld = driver.findElements(By.id("plan"));
        namePlanet.sendKeys("test");
        addPlanetButton.click();
        List<WebElement> rowsNew = driver.findElements(By.id("plan"));
        Assert.assertEquals(rowsNew.size() - rowsOld.size(), 1);
    }

    @Test
    public void deletePlanetTest(){
        WebElement addPlanetButton = driver.findElement(By.id("delete_planet_button"));
        List<WebElement> rowsOld = driver.findElements(By.id("plan"));
        addPlanetButton.click();
        List<WebElement> rowsNew = driver.findElements(By.id("plan"));
        Assert.assertEquals(rowsNew.size() - rowsOld.size(), -1);
    }

    @Test
    public void chooseGovernorTest(){
        WebElement namePlanet = driver.findElement(By.id("add_planet_name_field"));
        WebElement addPlanetButton = driver.findElement(By.id("add_planet_button"));
        namePlanet.sendKeys("test");
        addPlanetButton.click();

        WebElement nameGovernor = driver.findElement(By.id("add_gover_name_field"));
        WebElement ageGovernor = driver.findElement(By.id("add_gover_age_field"));
        WebElement addGovernorButton = driver.findElement(By.id("add_gover_button"));

        nameGovernor.sendKeys("test");
        ageGovernor.sendKeys("12");
        addGovernorButton.click();

        WebElement selectGovernor = driver.findElement(By.id("choose_gover_select"));
        Select selectGov = new Select(selectGovernor);
        selectGov.selectByVisibleText("test");

        WebElement selectPlanet = driver.findElement(By.id("choose_planet_select"));
        Select selectPlan = new Select(selectPlanet);
        selectPlan.selectByVisibleText("test");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement chooseGoverButton = driver.findElement(By.id("choose_gover_button"));
        chooseGoverButton.click();

        List<WebElement> rows = driver.findElements(By.id("plan"));

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        for (WebElement row: rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            if (cells.get(1).getText().equals("test"))
                Assert.assertEquals("test", cells.get(2).getText());
        }
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
