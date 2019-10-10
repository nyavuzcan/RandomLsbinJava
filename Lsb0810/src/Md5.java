import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Md5 {
	
	
	public static void basla( byte[] bArray) {
		String key="testSHA256";
		String sifrenmis="321b7d9f760e98972c830fd02384d1b5ceff8cacfda1e00b3b247102085ecedc";
		String nevzt="321b7d9f760e98972c830fd02384d1b5ceff8cacfda1e00b3b247102085ecedc";
		String sifrelenecek="Hello World";
		String bitler="0110100001100101011011000110110001101111001000000111011101101111011100100110110001100100";
		
		//93 bit
		String [] sifrelenecekdizi=sifrelenecek.split("");
		String [] sifredizi=sifrenmis.split("");
		String [] bitdizi=bitler.split("");
		ArrayList<Integer> kullanilan=new ArrayList<Integer>();
		
		
		
		int count=0;
		while(true) {
		
		
		for(int i=0;i<1111;i++) {
			  
			  char a=sifredizi[i].charAt(0);
			int ascii=(int)a;
			System.out.println(sifredizi[i]+"Degerler"+ascii);
			
			while(true) {
			
			if(kullanilan.contains(ascii)||(ascii<100)) {

				System.out.println(ascii+"Kullanýldý Tekrar Döngü Basladý");
			

			
				
				ascii*=2;
				
			
				
				continue;
			}
			System.out.println(ascii+"Cikildi");
			break;
			}
			
			
		
			 kullanilan.add((int) ascii);
			 
			int xa= Integer.valueOf(bitdizi[count]);
			 System.out.println("SAYÝMÝZ: "+xa);
	        	if((xa==0)&& (tekcift(bArray[ kullanilan.get(i) ] )==0) ) {
	        		System.out.println("Sayý 0 ---> Kolon 0 Býraktýk");
	        	}
	        	
	        	else if((xa==0)&&(tekcift(bArray[ kullanilan.get(i) ] )!=0)) {
	        		bArray[kullanilan.get(i)]-=1;
	        		System.out.println("Sayý 0 ---> Kolon: 1  1 Azalttýk");
	        	}
	        	
	        
	        	else if((xa==1)&&(tekcift(bArray[ kullanilan.get(i) ] )==1)) {
	        		System.out.println("Sayý 1 ---> Sayý 1 0 býraktýk");
	        	}
	        	else if((xa==1) && (tekcift(bArray[ kullanilan.get(i) ] )!=1)) {
	        		System.out.println(" DEGÝSTÝRÝLMEDEN ONCE"+bArray[kullanilan.get(i)]);
	        		
	        		
	        		bArray[kullanilan.get(i)]+=1;
	        	
	        		System.out.println("Sayý 1 ---> Sayý 0 1 Arttýrdýk");
	        	}
	        	count++;
	        	
	        	if(count==64) {
	    			
	    		//	System.out.println("ÇIKIIIÞ");
	    			break;
	    		}
	        }
		if(count==64) {
			
		//System.out.println("ÇIKIIIÞ");
			break;
		}
    		
		}
		  
		  
	
		  
		  
		//for(int z=0;z<kullanilan.size();z++) {
		//	System.out.println(kullanilan.get(z));
	//	}
		 
	}
  private static int tekcift(Byte sayi) {
		  
		  if ((sayi%2)==0) return 0;
		  
		  else return 1;
		  
			  
		 
	  }
	


}
