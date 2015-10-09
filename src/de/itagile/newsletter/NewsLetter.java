package de.itagile.newsletter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetter {
	
	@FindBy(css="[name='tx_enetoptivonewsletter_subscription[subscription][salutation]'][type='radio'][id='salutation1']")
	private WebElement maennlich;
	
	@FindBy(css="[name='tx_enetoptivonewsletter_subscription[subscription][salutation]'][type='radio'][id='salutation2']")
	private WebElement weiblich;
	
	@FindBy(css="[name='tx_enetoptivonewsletter_subscription[subscription][firstName]'][type='text']")
	private WebElement vorname;
	
	@FindBy(css="[name='tx_enetoptivonewsletter_subscription[subscription][lastName]'][type='text']")
	private WebElement nachname;
	
	@FindBy(css="[name='tx_enetoptivonewsletter_subscription[subscription][email]'][type='text']")
	private WebElement email;
	
	@FindBy(css="[type='submit'][value='Senden']")
	private WebElement newsletterBestellen;

	private WebDriver driver;
	
	public NewsLetter(WebDriver driver) {
		this.driver = driver;
	}

	public NewsLetter sendForm(Person teilnehmer) {
		if (Geschlecht.MAENNLICH.equals(teilnehmer.geschlecht)) {
			maennlich.click();
		} else {
			weiblich.click();
		}
		
		vorname.clear();
		vorname.sendKeys(teilnehmer.vorname);
		nachname.clear();
		nachname.sendKeys(teilnehmer.nachname);
		email.clear();
		email.sendKeys(teilnehmer.email);
			
		newsletterBestellen.click();
		
		PageFactory.initElements(driver, this);
		return this;
	}
}