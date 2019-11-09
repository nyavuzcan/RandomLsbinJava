import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Md5 {
	
	
	public static void basla( byte[] bArray,String key,String sifrenmis, String sifrelenecek,String bitler,int width,int height) {
		//String key="testSHA256";
		//String sifrenmis="321b7d9f760e98972c830fd02384d1b5ceff8cacfda1e00b3b247102085ecedc";
		
		//String sifrelenecek="Hello World";
		//String bitler="0110100001100101011011000110110001101111001000000111011101101111011100100110110001100100";
		
		//93 bit
		String [] sifrelenecekdizi=sifrelenecek.split("");
		String [] sifredizi=sifrenmis.split("");
		String [] bitdizi=bitler.split("");
		ArrayList<Integer> kullanilan=new ArrayList<Integer>();
		
		Entropy ent=new Entropy(bArray);
		
		
		 int degisen=0;
		int kalanbitsayisi=bitdizi.length;
		int count=0;
		int i=0;
	    byte firstbyte=0;
		
		while(true) {
		
		System.out.println(bArray[25598]);
		
			  
			  char a=sifredizi[i].charAt(0);
			  System.out.println("Ý NÝN DEGERÝ: "+i+" sifredizi uzumn: "+sifredizi.length);
			int ascii=(int)a;
			System.out.println(sifredizi[i]+"Degerler"+ascii);
			
			if(i==sifredizi.length-1) {
        		System.out.println("Ý SIFIRLANIYOR ***");
        		i=0;
        		continue;
        	}
		
			while(true) {
				
				
			if(ascii>40000) {
				ascii/=2;
				ascii--;
				System.out.println("Sayý SINIRI GECTÝ");
				continue;
			}
			if(kullanilan.contains(ascii)||(ascii<200)) {
					
				System.out.println(ascii+"Kullanýldý Tekrar Döngü Basladý");
			

			
			
				ascii*=2;
				
				continue;
			}
			System.out.println(ascii+"Cikildi");
			break; //KULLANILACAK ÝNDEX BULUNDU WHILEDAN CIK
			}
			
		
		
			 kullanilan.add((int) ascii);
			 System.out.println("EKLENEN "+ascii);
			 
			int xa= Integer.valueOf(bitdizi[count]);
			 System.out.println("SAYÝMÝZ: "+xa);
	        	if((xa==0)&& (tekcift(bArray[ascii] )==0) ) {
	        		System.out.println("Sayý 0 ---> Kolon 0 Býraktýk");
	        		
	        	}
	        	
	        	else if((xa==0)&&(tekcift(bArray[ ascii ] )!=0)) {
	        		bArray[ascii]-=1;
	        		
	        		
	        		System.out.println("Sayý 0 ---> Kolon: 1  1 Azalttýk");
	        		degisen++;
	        	}
	        	
	        
	        	else if((xa==1)&&(tekcift(bArray[ ascii ] )==1)) {
	        		System.out.println("Sayý 1 ---> Sayý 1 0 býraktýk");
	        	}
	        	else if((xa==1) && (tekcift(bArray[ ascii ] )!=1)) {
	        		
	        		
	        		bArray[ascii]+=1;
	        	
	        		System.out.println("Sayý 1 ---> Sayý 0 1 Arttýrdýk");
	        		degisen++;
	        	}
	        	
	        	kalanbitsayisi--;
	        	count++;
	        	i++;
	        	System.out.println("COUNT: "+count+" BÝTSAYISI: "+kalanbitsayisi);
	        	
	        
	        	if(count==bitdizi.length) {
	    			
	        		break;
	        		//count=0;
	    	    	//i=0;
	    	
	    		}
	        	
	        	else { //1.if'in else
	        		continue;
	        	}
	        }
	 
    		
		
		  
		  
	
		  
		  
		//for(int z=0;z<kullanilan.size();z++) {
		//	System.out.println(kullanilan.get(z));
	//	}
		System.out.println(degisen);
			MeansSqueareError mse=new MeansSqueareError(height, width,degisen);
			PayloadCapacity py=new PayloadCapacity(height,width,bitdizi.length);
	}
  private static int tekcift(Byte sayi) {
		  
		  if ((sayi%2)==0) return 0;
		  
		  else return 1;
		  
			  
		 
	  }
	


}
