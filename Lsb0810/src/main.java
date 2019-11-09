
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.imageio.ImageIO;




public class main {

	
	
	public void runm(String filepath,String newpath,String key,String bitler,String message,String sifrenmis) {
		
		Md5 md=new Md5();
	
		 int width = 0 ;
		 int height =0;
		 File file = new File(filepath);
		 BufferedImage bimg;
		try {
			bimg = ImageIO.read(file);
		      width   = bimg.getWidth();
			    height     = bimg.getHeight();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	        // Using java.io.FileInputStream
	        byte[] bArray = readFileToByteArray(file);
	        md.basla(bArray, key, sifrenmis, message, bitler,width,height);
	    	//md.basla(bArray);
	    
	    	
	        
	        
	        BufferedImage image = null;
			try {
				image = ImageIO.read( new ByteArrayInputStream( bArray ) );
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
				ImageIO.write(image, "BMP", new File("D:\\NY-Files\\Desktop\\"+newpath+".BMP"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	       
		
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
	  
	
	  private static int tekcift(Byte sayi) {
		  
		  if ((sayi%2)==0) return 0;
		  
		  else return 1;
		  
			  
		 
	  }
	
	


}
