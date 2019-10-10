
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;




public class main {

	public static void main(String[] args) {

		Md5 md=new Md5();
	
		
		
		 File file = new File("D:\\NY-Files\\Desktop\\MARBLES.BMP");
	        
	        // Using java.io.FileInputStream
	        byte[] bArray = readFileToByteArray(file);
	        
	    	md.basla(bArray);
	    
	    	
	        //for(int y=0;y<66;y++)
				//System.out.println(bArray[y]);
	      //  System.out.println(bArray.length);
	     //40byte HEADER
	      /*  for(int i=40;i<189954;i++) {
	        	if(tekcift(bArray[i])==0) {
	        		bArray[i]+=4;
	        	}
	        	else {
	        		bArray[i]-=4;
	        	}
	        	
	        }*/
	               
	        //displaying content of byte array
	      /*  for (int i = 0; i < bArray.length; i++){
	           System.out.print((char) bArray[i]);
	        }  */
	        
	        BufferedImage image = null;
			try {
				image = ImageIO.read( new ByteArrayInputStream( bArray ) );
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
				ImageIO.write(image, "BMP", new File("D:\\NY-Files\\Desktop\\denemx.BMP"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        DosyayaEkle(toBitString(bArray));
		
	    }
	//DOSYALARI BYTE SEKLÝNDE SORUNSUZ OKUDUK.
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
	 
	 // BYTETAN BIT STRINGE CEVÝRME
	 
	  public static String toBitString(final byte[] b) {
		    final char[] bits = new char[8 * b.length];
		    for(int i = 0; i < b.length; i++) {
		        final byte byteval = b[i];
		        int bytei = i << 3;
		        int mask = 0x1;
		        for(int j = 7; j >= 0; j--) {
		            final int bitval = byteval & mask;
		            if(bitval == 0) {
		                bits[bytei + j] = '0';
		            } else {
		                bits[bytei + j] = '1';
		            }
		            mask <<= 1;
		        }
		    }
		    return String.valueOf(bits);
		  }
	  
	  // DOSYAYA VERÝ EKLEME TXT FORMATI
	  private static void DosyayaEkle(String metin){
          try{
                File dosya = new File("D:\\NY-Files\\Desktop\\xcx.txt");
                FileWriter yazici = new FileWriter(dosya,true);
                BufferedWriter yaz = new BufferedWriter(yazici);
                yaz.write(metin);
                yaz.close();
                System.out.println("Ekleme Ýþlemi Baþarýlý");
          }
          catch (Exception hata){
                hata.printStackTrace();
          }
    }
	  private static int tekcift(Byte sayi) {
		  
		  if ((sayi%2)==0) return 0;
		  
		  else return 1;
		  
			  
		 
	  }

}
