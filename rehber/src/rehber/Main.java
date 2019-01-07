package rehber;

import java.util.Scanner;

public class Main {
	public static Telefon cepTelefonumuz = new Telefon("Nokia 6630");
	
	public static String baslik = "----------------------TELEFON REHBERI----------------------";
	private static String secenekler = "0 - Rehberden ��k \n1 - T�m ki�ileri Listele\n2 - Ki�i Ekle\n3 - Ki�i G�r�nt�le\n4 - Ki�i Sil\n5 - Ki�i G�ncelleme1\n6 - Rehberden ��k�� Yap�ld�";
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
				System.out.println("Girilen deger Numeric bir deger de�il");
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
			System.out.println("L�tfen klavyeden de�er giriniz...");
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
						System.out.println("Listedeki Ki�iler Listelendi");
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
						System.out.println("Rehber'den ��k�� yap�ld�");
						System.out.println();
						cikis = true;
						break;
					default:
						System.out.println("L�tfen klavyeden ge�erli bir se�im yap�n�z");
						System.out.println();
						break;
					}
				}
				else 
				{
					System.out.println("Klavyeden ge�erli bir de�er giriniz");
					
				}
					

			} 
				
			}while (cikis!=true);
		
			
	}
	private static void yeniKisiEkle()
	{
		System.out.println("Ki�i Ad� : ");
		String isim = klavyeDegeri.next();
		System.out.println("Ki�i Telefonu : ");
		String telefonNumarasi = klavyeDegeri.next();
		/*Kisi eklenenKisi = new Kisi(isim,telefonNumarasi);
		cepTelefonumuz.rehberekisiEkle(eklenenKisi); */ //Bu iki sutundaki yaz�lanlar yerine asag�daki tek sat�r kod yaz�ld� 
		cepTelefonumuz.rehberekisiEkle(Kisi.Olustur(isim, telefonNumarasi)); //Ki�i class'�ndaki Olustur methodu kullan�larak bir Kisi nesnesi cepTelefonumuz nesnesi ekleniyor
		
		
	}
	
	private static void kisiSorgulamaisimle()
	{
		System.out.println("Arama yapabilmek i�in �sim bilgisi giriniz...");
		String isim = klavyeDegeri.next();
		Kisi bulunanKisi = cepTelefonumuz.kisiSorgulaAdile(isim);
	
		if (bulunanKisi == null) 
		{
			System.out.println(isim+" isim ad�nda bir kay�t bulunamad�");
		}
		else 
		{
			System.out.println("Bulunan Ki�i isim : "+bulunanKisi.getIsim()+"\n"+"Bulunan Ki�i Telefon : "+bulunanKisi.getTelefon());
		}
	}
	private static void kisiSilindi()
	{
		System.out.println("L�tfen silmek i�in kisi ismini giriniz");
		String isim = klavyeDegeri.next();
		Kisi silinecekKisi = cepTelefonumuz.kisiSorgulaAdile(isim);
		
		if (cepTelefonumuz.kisiSil(silinecekKisi)) 
		{
			System.out.println("Ki�i silindi");
		}
		
		/*try {
			cepTelefonumuz.kisiSil(silinecekKisi);
			System.out.println(silinecekKisi.getIsim()+" "+"isimli kisi ba�ar� ile silinmi�tir.");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(silinecekKisi.getIsim()+" "+"isimli kisi silinememi�tir");
			e.printStackTrace();*/
			
	}
	private static void kisiGuncelleme()
	{
		System.out.println("G�ncellenecek Ki�i ad�n� giriniz");
		String isim = klavyeDegeri.next();
		Kisi bulunanKisi = cepTelefonumuz.kisiSorgulaAdile(isim);
		if (bulunanKisi==null) 
		{
			System.out.println("Kay�t bulunamad�");
			
		}
		else 
		{
			System.out.println("Yeni isim degeri : ");
			String yeniIs�m = klavyeDegeri.next();
			System.out.println("Yeni telefon degeri : ");
			String yeniTel = klavyeDegeri.next();
			cepTelefonumuz.kisiGuncelle(bulunanKisi,Kisi.Olustur(yeniIs�m, yeniTel) );
			
		}
		
	}

				

			
			


	
		

}


