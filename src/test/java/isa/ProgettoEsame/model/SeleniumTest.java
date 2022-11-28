package isa.ProgettoEsame.model;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import isa.ProgettoEsame.ProgettoEsameApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProgettoEsameApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumTest {
    private WebDriver driver;

    @BeforeClass
    public static void start() {
        final String webDriverPath = "C:\\Users\\chris\\Desktop\\ISA2022\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webDriverPath);
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testUser() throws InterruptedException {
        /*Collegamento localhost*/
        driver.get("http://localhost:8080/");

        /*Procedura di Login*/
        driver.findElement(By.name("userId")).sendKeys("mark");
        driver.findElement(By.name("pwd")).sendKeys("321");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        
        /*Inserimento di una nuova prenotazione */
        driver.findElement(By.linkText("Le mie prenotazioni")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Aggiungi")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("description")).sendKeys("Prova con Selenium");
        Select drpTravel = new Select(driver.findElement(By.name("travel")));
        drpTravel.selectByVisibleText("Parigi");
        Select drpUser = new Select(driver.findElement(By.name("user")));
        drpUser.selectByIndex(0);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
    
        /*Modifica della prenotazione*/
        driver.findElement(By.cssSelector("div>table>tbody>tr:last-of-type>td:last-of-type>a[class='btn btn-primary btn-sm mb-3']")).click();
        Thread.sleep(2000);
        WebElement descr = driver.findElement(By.name("description"));
        descr.clear();
        descr.sendKeys("Prova con Selenium-modified");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);

        /*Eliminazione della prenotazione*/
        driver.findElement(By.cssSelector("div>table>tbody>tr:last-of-type>td:last-of-type>a[class='btn btn-danger btn-sm mb-3']")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(4000);
    }

    @Test
    public void testAdmin() throws InterruptedException {
        /*Collegamento localhost*/
        driver.get("http://localhost:8080/");

        /*Procedura di Login*/
        driver.findElement(By.name("userId")).sendKeys("detratti");
        driver.findElement(By.name("pwd")).sendKeys("123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);

        /*Inserimento di un nuovo link*/
        driver.navigate().to("http://localhost:8080/link/add");
        Thread.sleep(2000);
        driver.findElement(By.name("destination")).sendKeys("Cracovia-Selenium");
        driver.findElement(By.name("time")).sendKeys("6");
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
    

        /*Modifca del collegamento relativo a Barcellona*/
        driver.navigate().to("http://localhost:8080/link");
        WebElement selectedRow = driver.findElement(By.xpath("//tr[td//text()[contains(.,'Barcellona')]]"));
        selectedRow.findElement(By.cssSelector("td:last-of-type>a[class='btn btn-primary btn-sm mb-3']")).click();
        Thread.sleep(2000);
        WebElement timeLinked = driver.findElement(By.name("time"));
        timeLinked.clear();
        timeLinked.sendKeys("12");
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
     driver.quit();
    }
}
