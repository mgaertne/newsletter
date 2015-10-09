package de.itagile.newsletter;

public class Person {
	public final Geschlecht geschlecht;
	
	public final String vorname;
	
	public final String nachname;
	
	public final String email;

	public Person(Geschlecht geschlecht, String vorname, String nachname, String email) {
		this.geschlecht = geschlecht;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}
	
}