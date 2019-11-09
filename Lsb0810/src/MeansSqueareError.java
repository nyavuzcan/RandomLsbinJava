import java.lang.Math.*;
public class MeansSqueareError {
	
	public MeansSqueareError() {
		
	}
	
	public MeansSqueareError(int height,int width, int degisen) {
		double a=degisen;
	double b=width*degisen;
				System.out.println("MEAN SQUARE ERROR ****"+a/b);
	
				
	 double ms=a/b;
	 double psnr=10*(java.lang.Math.log10((255*255)/ms));
	 System.out.println("PSNR: **** "+psnr+"DESIBEL");
	 
	}
	

}
