package rehber;

public class Kisi {
	private String isim;
	private String telefon;
	
	
	public static Kisi Olustur(String ad, String tel)
	{
		return new Kisi(ad, tel);
	}
	
	
	public Kisi(String isim, String telefon) {
		this.isim = isim;
		this.telefon = telefon;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
}
