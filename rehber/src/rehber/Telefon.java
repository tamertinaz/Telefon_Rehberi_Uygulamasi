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
		if (kisiBulIsmeGore(yeniKisi.getIsim())>=0)//isim ile sorgulandýðunda kayýt bulunununca  telefonRehber ArrayList'inde index(i) degerini alýyor yani index var oldugu sürece -1 degerini almayacagýndan kisiBulIsmeGore methodundan dönen index bilgisinin 0>= kosulu ile dogrulugunu sorguluyor 
		{
			System.out.println(yeniKisi.getIsim()+" rehberde ayný isimde kisi var olduðundan kayýt yapýlmadi");
			return false;
					
		}
		else 
		{
			this.telefonRehber.add(yeniKisi);
			System.out.println("Kiþi eklendi");
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
				System.out.println(telefonRehber.get(i).getIsim()); //bulunan kiþiyi yazdýr
				return i; //isim ile arama sonucunda kayýt bulundu ve bu kaydýn index'ini geri gönderdemek
				
			}
			
		}
		System.out.println("Kiþi bulunamadý");
		return -1; //bu Telefon Rehberinde aranýlan isim'de bir kayýt yok demek
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
			System.out.println("Güncellenecek kiþi bulunamadý");
			return false;
		}
		telefonRehber.set(eskiKisiposition, yeniKisi);
		System.out.println("Güncelleme öncesi kisi : "+eskiKisi.getIsim()+"\n"+eskiKisi.getTelefon());
		System.out.println("Güncelleme Sonrasý kisi : "+yeniKisi.getIsim()+"\n"+yeniKisi.getTelefon());
		return true;
	}

	public void tumRehberiGoster()
	{
		System.out.println(Main.baslik);
		if (telefonRehber.size() == 0) 
		{
			System.out.println("Kayýtlý Kiþi Yok\n+\n");
		}
		for (int i = 0; i < this.telefonRehber.size(); i++) 
		{
			System.out.println((i+1)+" : "+telefonRehber.get(i).getIsim()+" - "+" "+telefonRehber.get(i).getTelefon());
			
		}
	}
	
	

}
 