package rehber;

import java.util.Scanner;

public class Main {
	public static Telefon cepTelefonumuz = new Telefon("Nokia 6630");
	
	public static String baslik = "----------------------TELEFON REHBERI----------------------";
	private static String secenekler = "0 - Rehberden Çýk \n1 - Tüm kiþileri Listele\n2 - Kiþi Ekle\n3 - Kiþi Görüntüle\n4 - Kiþi Sil\n5 - Kiþi Güncelleme1\n6 - Rehberden Çýkýþ Yapýldý";
	private static boolean cikis = false;
	public static Scanner klavyeDegeri = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
		Kisi tamer = new Kisi("Tamer", "111 444 555 55");
		Kisi yemekci = Kisi.Olustur("Lahmacuncu Zeki", "666 999 666 222 444");
		cepTelefonumuz.rehberekisiEkle(tamer);
		cepTelefonumuz.rehberekisiEkle(yemekci);
		cepTelefonumuz.rehberekisiEkle(Kisi.Olustur("ChuFeng", "66699 22 44 222"));
		

		
		acilis();
		menu();
		secim();

		
		
	}
	private static void menu() 
	{
		
		System.out.println(baslik+"\n");
		System.out.println(secenekler);
		
	}
	private static void acilis() 
	{
		System.out.println();
	}
	public static boolean sayiMi(Object degisken)
	{
		if (degisken instanceof Integer) 
		{
			return true;
			
		}
		else 
		{
			String stringDegisken = degisken.toString();
			
		
		try 
			{
			Integer.parseInt(stringDegisken);
			
			} catch (Exception sayidegil) 
			{
				System.out.println("Girilen deger Numeric bir deger deðil");
				//System.err.println(sayidegil.printStackTrace());
				// TODO: handle exception
				return false;
			}
		return true;
		
		}
	}
	
	public static void secim()
	{
		do {
			System.out.println("Lütfen klavyeden deðer giriniz...");
			String secim =klavyeDegeri.next();
			if (sayiMi(secim)!= true) 
			{
				secim();
				
			}
			else 
			{
				int secimInt = Integer.parseInt(secim);
				if (secimInt >= 0 && secimInt <=5) 
				{
					
					switch (secimInt) 
					{
					case 1:
						cepTelefonumuz.tumRehberiGoster();
						System.out.println("Listedeki Kiþiler Listelendi");
						System.out.println();
						menu();
						secim();
						break;
					case 2:
						yeniKisiEkle();								
						System.out.println();
						menu();
						secim();
						break;
					case 3:
						kisiSorgulamaisimle();
						System.out.println();
						break;
					case 4:
						kisiSilindi();
						System.out.println();
						break;
					case 5:
						kisiGuncelleme();
						break;
					case 6:
						System.out.println("Rehber'den çýkýþ yapýldý");
						System.out.println();
						cikis = true;
						break;
					default:
						System.out.println("Lütfen klavyeden geçerli bir seçim yapýnýz");
						System.out.println();
						break;
					}
				}
				else 
				{
					System.out.println("Klavyeden geçerli bir deðer giriniz");
					
				}
					

			} 
				
			}while (cikis!=true);
		
			
	}
	private static void yeniKisiEkle()
	{
		System.out.println("Kiþi Adý : ");
		String isim = klavyeDegeri.next();
		System.out.println("Kiþi Telefonu : ");
		String telefonNumarasi = klavyeDegeri.next();
		/*Kisi eklenenKisi = new Kisi(isim,telefonNumarasi);
		cepTelefonumuz.rehberekisiEkle(eklenenKisi); */ //Bu iki sutundaki yazýlanlar yerine asagýdaki tek satýr kod yazýldý 
		cepTelefonumuz.rehberekisiEkle(Kisi.Olustur(isim, telefonNumarasi)); //Kiþi class'ýndaki Olustur methodu kullanýlarak bir Kisi nesnesi cepTelefonumuz nesnesi ekleniyor
		
		
	}
	
	private static void kisiSorgulamaisimle()
	{
		System.out.println("Arama yapabilmek için Ýsim bilgisi giriniz...");
		String isim = klavyeDegeri.next();
		Kisi bulunanKisi = cepTelefonumuz.kisiSorgulaAdile(isim);
	
		if (bulunanKisi == null) 
		{
			System.out.println(isim+" isim adýnda bir kayýt bulunamadý");
		}
		else 
		{
			System.out.println("Bulunan Kiþi isim : "+bulunanKisi.getIsim()+"\n"+"Bulunan Kiþi Telefon : "+bulunanKisi.getTelefon());
		}
	}
	private static void kisiSilindi()
	{
		System.out.println("Lütfen silmek için kisi ismini giriniz");
		String isim = klavyeDegeri.next();
		Kisi silinecekKisi = cepTelefonumuz.kisiSorgulaAdile(isim);
		
		if (cepTelefonumuz.kisiSil(silinecekKisi)) 
		{
			System.out.println("Kiþi silindi");
		}
		
		/*try {
			cepTelefonumuz.kisiSil(silinecekKisi);
			System.out.println(silinecekKisi.getIsim()+" "+"isimli kisi baþarý ile silinmiþtir.");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(silinecekKisi.getIsim()+" "+"isimli kisi silinememiþtir");
			e.printStackTrace();*/
			
	}
	private static void kisiGuncelleme()
	{
		System.out.println("Güncellenecek Kiþi adýný giriniz");
		String isim = klavyeDegeri.next();
		Kisi bulunanKisi = cepTelefonumuz.kisiSorgulaAdile(isim);
		if (bulunanKisi==null) 
		{
			System.out.println("Kayýt bulunamadý");
			
		}
		else 
		{
			System.out.println("Yeni isim degeri : ");
			String yeniIsým = klavyeDegeri.next();
			System.out.println("Yeni telefon degeri : ");
			String yeniTel = klavyeDegeri.next();
			cepTelefonumuz.kisiGuncelle(bulunanKisi,Kisi.Olustur(yeniIsým, yeniTel) );
			
		}
		
	}

				

			
			


	
		

}


