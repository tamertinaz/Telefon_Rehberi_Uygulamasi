package rehber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Telefon {
	private ArrayList<Kisi> telefonRehber = new ArrayList<>();
	private String telefonModeli;
	
	public Telefon(String model) {
		
		this.telefonModeli = model;
		this.telefonRehber = new ArrayList<>();
		
	}
	
	public boolean rehberekisiEkle(Kisi yeniKisi)
	{
		if (kisiBulIsmeGore(yeniKisi.getIsim())>=0)//isim ile sorguland��unda kay�t bulunununca  telefonRehber ArrayList'inde index(i) degerini al�yor yani index var oldugu s�rece -1 degerini almayacag�ndan kisiBulIsmeGore methodundan d�nen index bilgisinin 0>= kosulu ile dogrulugunu sorguluyor 
		{
			System.out.println(yeniKisi.getIsim()+" rehberde ayn� isimde kisi var oldu�undan kay�t yap�lmadi");
			return false;
					
		}
		else 
		{
			this.telefonRehber.add(yeniKisi);
			System.out.println("Ki�i eklendi");
			return true;
		}

	}
	
	public int kisiBulTelefonNumarasinaGore(Kisi kayit)//kisiBulTelefonNumarasinaGore
	{
		return this.telefonRehber.indexOf(kayit);
		
	}
	public int kisiBulIsmeGore(String ad)//kisiBulIsmeGore
	{
		for (int i = 0; i < this.telefonRehber.size(); i++) 
		{
			Kisi anlikKisi = this.telefonRehber.get(i);
			
			if (anlikKisi.getIsim().equals(ad)) 
			{				
				System.out.println(telefonRehber.get(i).getIsim()); //bulunan ki�iyi yazd�r
				return i; //isim ile arama sonucunda kay�t bulundu ve bu kayd�n index'ini geri g�nderdemek
				
			}
			
		}
		System.out.println("Ki�i bulunamad�");
		return -1; //bu Telefon Rehberinde aran�lan isim'de bir kay�t yok demek
	}
	public Kisi kisiSorgulaAdile(String isim) 
	{
		int indexDegeri =  kisiBulIsmeGore(isim);
		
		if (indexDegeri >= 0)// 
		{
			return telefonRehber.get(indexDegeri);
		}

		return null;
	}
	public boolean kisiSil(Kisi silinecekKisi) 
	{
		int position = kisiBulTelefonNumarasinaGore(silinecekKisi);
		if (position >= 0)// 
		{
			this.telefonRehber.remove(silinecekKisi);
			return true;
		}

		return false;
		
	}
	public boolean kisiGuncelle(Kisi eskiKisi, Kisi yeniKisi)
	{
		int eskiKisiposition = kisiBulTelefonNumarasinaGore(eskiKisi);
		if (eskiKisiposition<0) 
		{
			System.out.println("G�ncellenecek ki�i bulunamad�");
			return false;
		}
		telefonRehber.set(eskiKisiposition, yeniKisi);
		System.out.println("G�ncelleme �ncesi kisi : "+eskiKisi.getIsim()+"\n"+eskiKisi.getTelefon());
		System.out.println("G�ncelleme Sonras� kisi : "+yeniKisi.getIsim()+"\n"+yeniKisi.getTelefon());
		return true;
	}

	public void tumRehberiGoster()
	{
		System.out.println(Main.baslik);
		if (telefonRehber.size() == 0) 
		{
			System.out.println("Kay�tl� Ki�i Yok\n+\n");
		}
		for (int i = 0; i < this.telefonRehber.size(); i++) 
		{
			System.out.println((i+1)+" : "+telefonRehber.get(i).getIsim()+" - "+" "+telefonRehber.get(i).getTelefon());
			
		}
	}
	
	

}
 