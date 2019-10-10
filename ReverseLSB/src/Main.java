import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		String key="nevzat";
		String sifrenmis="321b7d9f760e98972c830fd02384d1b5ceff8cacfda1e00b3b247102085ecedc";
		 File file = new File("D:\\NY-Files\\Desktop\\denemx.BMP");
	
			String [] sifredizi=sifrenmis.split("");
		
			ArrayList<Integer> kullanilan=new ArrayList<Integer>();
			ArrayList<String> degerler=new ArrayList<String>();
	        // Using java.io.FileInputStream
	        byte[] bArray = readFileToByteArray(file);
	        
	    	int count=0;
			while(true) {
			
			
			for(int i=0;i<sifrenmis.length();i++) {
				  
				  char a=sifredizi[i].charAt(0);
				int ascii=(int)a;
				System.out.println(sifredizi[i]+"Degerler"+ascii);
				
				while(true) {
				
				if(kullanilan.contains(ascii)||(ascii<100)) {// headerdan degil pixellerden yazacak

					System.out.println(ascii+"Kullanýldý Tekrar Döngü Basladý");
				

				
					
					ascii*=2;
					
				
					
					continue;
				}
				System.out.println(ascii+"Cikildi");
				break;
				}
				
				
				 
				 kullanilan.add((int) ascii);
				 System.out.println(kullanilan.get(i));
				 
				 if((bArray[kullanilan.get(i)]%2)==0) {
					System.out.println("deneme");
					degerler.add("0");
				 }
					
				 else {
					degerler.add("1");
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
			  String sonstr = "";
			for(String deger: degerler) {
				
				sonstr+=deger;
				
			}
	        System.out.println(sonstr);
	       
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
