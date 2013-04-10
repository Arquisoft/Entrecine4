package es.uniovi.asw.entrecine;

import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Cuando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertTrue;

public class GoogleSteps {

	private WebDriver driver = new HtmlUnitDriver();


	@Dado("^que visito la página \"([^\"]*)\"$")
	public void que_visito_la_página(String url) throws Throwable {
	driver.get(url);
}

	@Cuando("^busco la palabra \"(\\w+)\"$")
	public void busco_la_palabra(String palabra) throws Throwable {
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(palabra);
		element.submit();
}

	@Entonces("^el navegador debe tener el título \"(\\w+)\"$")
	public void el_navegador_debe_tener_el_título(String titulo) throws Throwable {
		assertTrue(driver.getTitle().contains(titulo));
}


}