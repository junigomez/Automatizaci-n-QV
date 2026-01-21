import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class base {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public base(WebDriver driver) {
    }

    /**----------------------------MÉTODO PARA INICIAR EL NAVEGADOR CHROME-------------------*/


    public WebDriver chromeDriverConnection() {// LUGAR DONDE ESTA GUARDADO EL EJECUTABLE DE GOOGLE DENTRO DEL PROYECTO

        System.setProperty("webdriver.chrome.driver",
                "./src/test/resources/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();// METODO PARA RESOLVER EL ERROR DE WEB SOCKED CONNECTION
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

    /**------------------ METODO PARA RECIBIR LA URL Y VERIFICAR LA PAGINA---------*/

    public void visit(String url) {
        driver.get(url);
    }

    /**----------------------------MÉTODO PARA INICIAR EL NAVEGADOR EDGE-------------------*/

    public WebDriver edgeDriverConnection() {

        System.setProperty(
                "webdriver.edge.driver",
                "src/test/resources/edgedriver/msedgedriver.exe"
        );

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new EdgeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //driver.manage().window().maximize();

        return driver;
    }


    // MÉTODOS DE SELENIUM ENVOLTORIO ( WRAP )

    /**
     * METODO PARA INGRESAR TEXTO EN UN CAMPO DE ENTRADA
     *
     * @param inputText El TEXTO A INGRESAR.
     * @param locator El LOCALIZADOR DEL ELEMENTO.
     */
    public void type(String inputText, By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // ESPERA HASTA QUE EL ELEMENTO SEA VISIBLE
        driver.findElement(locator).sendKeys(inputText);
    }

    /**
     * METODO PARA HACER CLIC EN ELEMENTO.
     *
     * @param locator El LOCALIZADOR DEL ELEMENTO.
     */
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)); // ESPERA HASTA QUE EL ELEMENTO SEA CLICKEABLE
        driver.findElement(locator).click();
    }

    /**
     * METODO PARA VERIFICAR SI UN ELEMENTO ESTA VISIBLE.
     *
     * @param locator El LOCALIZADOE DEL ELEMENTO.
     * @return true SI EL ELEMENTO ESTA VISIBLE, false EN CASO CONTRARIO.
     */
    public boolean isDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }


    /** METODO PARA SELECCIONAR UNA OPCIÓN DE UNA LISTA DESPLEGABLE */
    public void selectDropdownOption(By buttonLocator, By optionLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        driver.findElement(buttonLocator).click();

        wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        driver.findElement(optionLocator).click();
    }

/**---------------------METODO PARA FILTROS ESTATICOS---------------------------*/

    public void clickAndType(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(locator);
        element.click();          // DA FOCO AL CAMPO
        element.clear();          // LIMPIA EL CAMPO
        element.sendKeys(text);   // ESCRIBE
    }


    /**---------------------METODO PARA FILTROS DINAMICOS EJECUTADOS POR EVENTO---------------------------*/

    public void typeAndEnter(String text, By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }



}