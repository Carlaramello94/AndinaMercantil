package com.andina;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.proyect.pom.Base;

public class AndinaPage extends TestBase {
	
	
	By usernameLocator = By.id("inputName");
	By telefonoLocator = By.id("inputTel");
	By mailLocator = By.id("inputemail");
	By viviendaLocator = By.id("tipovivienda");
	By superficieLocator = By.id("superficie");
	By ubicacionLocator = By.id("ubicacion");
	By cotizarBtnLocator = By.id("cotizador-submit");
	By grillaResultados = By.id("cotizador-result");
	By btnSeguro = By.id("menu-item-30907");
	
	public boolean resultados(String busqueda) {
		
		boolean rtdo = false;
		
		WebElement grilla = driver.findElement(grillaResultados);
		
		List<WebElement> columnsList = grilla.findElements(By.xpath("//table/tbody/tr/td[2]"));
		
				for (WebElement column : columnsList) {
					String texto = column.getText();
                    if(column.getText().contains("$")) {
                    	rtdo = SaldoMayoraCero(column);            
                    	} else {
                 	   rtdo=false;
                 	   break;
                    }                               	
	}

		return rtdo;
	}
	
	public boolean SaldoMayoraCero(WebElement column) {
		boolean Ban=false;
		double saldoAct = 0;
		do {
			String saldoActual = column.getText();
			String separador = Pattern.quote("$");
			String[] parts = saldoActual.split(separador);
			saldoActual = parts[1].replace(".", "");
			saldoAct = Double.parseDouble(saldoActual);
		} while (saldoAct<=0);
		Ban=true;
		return Ban;
	}
	
	
	public void clickSeguros (){
		driver.findElement(btnSeguro).click();	
	}
	
	public void clickHogar() {
		
	}
	
	public void clickCotizar() {
		
	}
	public void Registro() throws InterruptedException {
		Base base = new Base();
		waitForPageLoaded();
		driver.findElement(cotizarBtnLocator).click();
		waitForPageLoaded();
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(cotizarBtnLocator);
		
		
			driver.findElement(usernameLocator).sendKeys("Roxana Rios");
			 WaitSecond(1);
			driver.findElement(telefonoLocator).sendKeys("153277656");
			 WaitSecond(1);
			driver.findElement(mailLocator).sendKeys("roxanarios@hotmail.com");
			Selectdroptdown("Casa");
			WaitSecond(1);
			Selectdpn("30 a 40 m2");
			WaitSecond(1);
			SelectdpnUbicacion("CABA");
			WaitSecond(1);
			
			System.out.println("antes del click");
			action.moveToElement(element).click().perform();
			System.out.println("despues del click");
			WaitSecond(7);
			
		}

	public void Goto() {
		driver.get("https://www.mercantilandina.com.ar/seguros-personales/hogar/");
	}
	
}
