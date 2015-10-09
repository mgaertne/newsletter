package de.itagile.newsletter;

import static de.itagile.newsletter.Geschlecht.*;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class NewsletterRegistrator {

	static List<Person> kursTeilnehmer = Arrays.asList(
		new Person(WEIBLICH, "Test", "Person", "mg@it-agile.de"),
		new Person(MAENNLICH, "Nochein", "Test", "mgaertne@gmail.com"));
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.navigate().to("http://www.it-agile.de");
		
		NewsLetter newsLetterForm = PageFactory.initElements(driver, NewsLetter.class);
		try {
			for (Person teilnehmer: kursTeilnehmer) {
				newsLetterForm = newsLetterForm.sendForm(teilnehmer);
			}
		} finally {
			driver.quit();
		}
		
	}
	
}
