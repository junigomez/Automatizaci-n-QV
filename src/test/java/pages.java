import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class  pages extends base{

    public pages(WebDriver driver){
        super(driver);
    }

    /**----------------------------LOCALIZADORES-------------------------------------------*/

    By titleLogin = By.xpath("//*[@id=\"login-title\"]/h1"); // TITULO DEL LOGIN

    By inputUser = By.id("user"); // LOCALIZADOR DEL CAMPO USUARION
    By inputPassword = By.id("pwd"); // LOCALIZADOR DEL CAMPO CONTRASEÑA
    By btnSubmit = By.xpath("//*[@id=\"login-submit\"]/div/input"); // LOCALIZADOR BOTON DE ENTRAR

    By newRequest = By.id("brick-services");
    By itemTechnologyManagement = By.xpath("//*[@id=\"brick_content_tree\"]/li[1]/span");
    By itemEnvironmentDeployment = By.xpath("//*[@id=\"brick_content_tree\"]/li[1]/ul/li/span");
    By itemPipeline = By.xpath("//*[@id=\"brick_content_tree\"]/li[1]/ul/li/ul/li[2]/span");

    By inputImpact = By.name("impact");
    By optionPerson = By.xpath("//option[@value='3']");

    By inputUrgency = By.name("urgency");
    By optionHigh = By.cssSelector("option[value='2']");

    By inputAffair = By.name("title");

    By searchClient = By.xpath("//div[contains(@class,'input-group-addon') and .//span[contains(@class,'glyphicon-search')]]");
    By inputFilter = By.cssSelector("div.dataTables_filter input[type='search']");
    By checKbox = By.id("274");
    By btnSubmitClient = By.cssSelector("input[type='button'][value='Enviar']");

    By txtDescription = By.cssSelector("div.ck-editor__editable");






    //PASOS DE AUTOMATIZACIÓN

    public void ingreso() { // METODO PARA INGRESAR AL SISTEMA
        System.out.println("Ingreso a login exitoso");

    }


    public void inicioSesion() {

        if (isDisplayed(titleLogin)) {

            type("", inputUser);
            type("", inputPassword);
            click(btnSubmit);

            System.out.println("Inicio de sesión exitosa");

        } else {
            System.out.println("No fue posible iniciar sesión");
        }

    }

    public void nuevoRequerimiento(){

        if (isDisplayed(newRequest)) {
            click(newRequest);
            click(itemTechnologyManagement);
            click(itemEnvironmentDeployment);
            click(itemPipeline);


            System.out.println("As ingresado al formulario de  nuevo requerimiento exitosamente");

        } else {
            System.out.println("No fue posible ingresar al modulo");
        }
    }

    public void formularioNuevoRequerimientoImpacto(){
        if (isDisplayed(inputImpact)) {
            selectDropdownOption(inputImpact,optionPerson);
            System.out.println("Menú desplegado de impacto");
        } else {
            System.out.println("No fue posible desplegar el menú");
        }
    }

    public void formularioNuevoRequerimientoUrgencia(){
        if (isDisplayed(inputUrgency)) {
            selectDropdownOption(inputUrgency, optionHigh);
            System.out.println("Menú desplegado de urgencia");
        } else {
            System.out.println("No fue posible desplegar el menú");
        }
    }

    public void asunto(){
        if (isDisplayed(inputAffair)) {
            type("Asunto de prueba", inputAffair);
            System.out.println("Asunto agregado");
        } else {
            System.out.println("No fue posible ingresar la descripción");
        }
    }

    public void cliente(){

        if (isDisplayed(searchClient)) {
           click(searchClient);
            System.out.println("Buscador desplegado");
        } else {
            System.out.println("No fue posible ingresar la descripción");
        }
    }

    public void buscarCliente(){

        if (isDisplayed(inputFilter)) {
            typeAndEnter("Banco Unión", inputFilter);
            System.out.println("Filtro aplicado correctamente");
        } else {
            System.out.println("No fue posible aplicar el filtro");
        }
    }

    public void elegirOpcion(){
        if (isDisplayed(checKbox)) {
            click(checKbox);
            click(btnSubmitClient);
            System.out.println("Cliente seleccionado correctamente");
        } else {
            System.out.println("No fue posible seleccionar al cliente");
        }
    }

    public void ingresarDescripcion() {
        if (isDisplayed(txtDescription)) {
            click(txtDescription);               // Enfocar el editor
            type("Descripción de prueba", txtDescription);         // Escribir
            System.out.println("Descripción ingresada correctamente");
        } else {
            System.out.println("No fue posible ingresar la descripción");
        }
    }




}
