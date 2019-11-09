import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Entropy {
	
	public Entropy() {
		
	}
	public Entropy(byte[] bArray) {
		
		Map<Byte, Integer> map = new HashMap<Byte,Integer>();
		
		byte byt;
		for(int i=0; i<bArray.length; i++) {
			
			byt=bArray[i];
			Integer countForByte=0;
			
			if(map.containsKey(byt)) {
				
				countForByte=map.get(byt);
				
				countForByte++;
			}
			else {
				countForByte=1;
			}
			
			map.put(byt, countForByte);
			
			
		}
		
		
		  double toplam =0;
		  double olasilik=0;
		for (Entry<Byte, Integer> entry : map.entrySet()) {
		  //  System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		   olasilik= entry.getValue().doubleValue()/bArray.length;

		  toplam+=  olasilik* log2(olasilik);
		  
		    
		}
		toplam*=-1;
		System.out.println("ENTROPY *****:"+toplam);
		
	}
	
	
	public static int log2(double olasilik)
	{
	    return (int) (Math.log(olasilik) / Math.log(2));
	}
	
	
}
