import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class itopTest {

    private WebDriver driver; // DECLARAMOS WEB DRIVER
    pages pages; // OBJETO DE LA CLASS DE LOS LOCALIZADORES
    private WebDriverWait wait; // DECLARAMOS WebDriverWait ( TIEMPO DE ESPERA )

    @Before
    public void setUp() throws Exception {
        pages = new pages(driver); // LLAMAMOS LA CLASS DE LOS LOCALIZADORES
        //driver = pages.chromeDriverConnection(); // LLAMAMOS AL MÉTODO PARA INICIAR EL NAVEGADOR CHROME
        driver = pages.edgeDriverConnection(); // LLAMAMOS AL MÉTODO PARA INICIAR EL NAVEGADOR EDGE
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // TIEMPO DE ESPERA DEL NAVEGADOR
        pages.visit("https://qv-apps.q-vision.co/itop/pages/UI.php");// LLAMAMOS AL METODO PARA RECIBIR LA URL
    }

    @After
    public void tearDown() throws Exception {
        // CERRAR EL DRIVER DESPUES DE CADA PRUEBA

        /**  if (driver != null) {
         driver.quit();
         }
         */
    }

    @Test
    public void test() {

        pages.ingreso();

        pages.inicioSesion();

        pages.nuevoRequerimiento();

        pages.formularioNuevoRequerimientoImpacto();

        pages.formularioNuevoRequerimientoUrgencia();

        pages.asunto();

        pages.cliente();

        pages.buscarCliente();

        pages.elegirOpcion();

        pages.ingresarDescripcion();






    }

}
