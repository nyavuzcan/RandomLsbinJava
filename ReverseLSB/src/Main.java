import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	public static String basla(String key,String sifrenmis,String path) {
		
		//String key="test";
		//String sifrenmis="9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08";
		 File file = new File(path);
	
			String [] sifredizi=sifrenmis.split("");
		
			ArrayList<Integer> kullanilan=new ArrayList<Integer>();
			ArrayList<String> degerler=new ArrayList<String>();
	        // Using java.io.FileInputStream
	        byte[] bArray = readFileToByteArray(file);
	        
	    	int count=0;
	    	int i=0;
			while(true) {
			
			
			
				  
				  char a=sifredizi[i].charAt(0);
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
				if(kullanilan.contains(ascii)||(ascii<200)) {// headerdan degil pixellerden yazacak

					System.out.println(ascii+"Kullanýldý Tekrar Döngü Basladý");
				
					
					ascii*=2;
				
				
					continue;
				}
				System.out.println(ascii+"Cikildi");
				break;
				}
				
				
				 
				 kullanilan.add((int) ascii);
				 System.out.println(kullanilan.get(i));
				 
				 if((bArray[ascii]%2)==0) {
					System.out.println("Alýnmasi gerekn 0: "+kullanilan.get(count));
					degerler.add("0");
				 }
					
				 else {
						System.out.println("Alýnmasi gerekn 1: "+kullanilan.get(count));
					degerler.add("1");
				 }
				
		        	count++;
		        	i++;
		        
		      
			if(count==160) {
				
			System.out.println("ÇIKIIIÞ");
				break;
			}
	    		
			}
			  String sonstr = "";
			for(String deger: degerler) {
				
				sonstr+=deger;
				
			}
	       return  sonstr;
	       
	}
	 private static byte[] readFileToByteArray(File file){
	        FileInputStream fis = null;
	        // Creating a byte array using the length of the file
	        // file.length returns long which is cast to int
	        byte[] bArray = new byte[(int) file.length()];
	        try{
	            fis = new FileInputStream(file);
	            fis.read(bArray);
	            fis.close();        
	            
	        }catch(IOException ioExp){
	            ioExp.printStackTrace();
	        }
	        return bArray;
	    }

}
