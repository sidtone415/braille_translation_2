import java.util.HashMap;


public class BrailleChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Braille Challenge
		String s = "code";
		String s2 = "Braille";
		String s3 = "The Brown Cow";
		answerBraille(s3);
	}
	
	public static String answerBraille(String plainText){
		StringBuilder sb = new StringBuilder();
		HashMap<String,String> brailleMap = new HashMap<String,String>();
		
		buildBrailleHash(brailleMap);
		if(plainText.length()<50 && !plainText.isEmpty()){
			for(int i=0; i<plainText.length(); i++){
				if(brailleMap.get(String.valueOf(plainText.charAt(i))) != null){
					sb.append(brailleMap.get(String.valueOf(plainText.charAt(i))));
				}else{
					sb.append(brailleMap.get("up"));
					sb.append(brailleMap.get(String.valueOf(plainText.charAt(i)).toLowerCase()));
				}
			}
			//System.out.println(sb);
		}
		return sb.toString();
	}
	
	public static void buildBrailleHash(HashMap<String,String> brailleMap){
		String[] brlArr = {"100000", "110000", "100100","100110", 
				"100010","110100", "110110", "110010", "010100", "010110"};
		String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
				"o","p","q","r","s","t","u","v","x","y","z","w"};
		
		// create braille hash map
		for(int i=0; i<brlArr.length; i++){
			brailleMap.put(alpha[i], brlArr[i]);
			char[] tmpBrl = brlArr[i].toCharArray();
			tmpBrl[2] = '1';
			brailleMap.put(alpha[i+10], String.valueOf(tmpBrl));
			tmpBrl[5] = '1';
			if(i+20 < alpha.length-1){
				brailleMap.put(alpha[i+20], String.valueOf(tmpBrl));
			}else if(i+20 == 29){
				tmpBrl[2] = '0';
				brailleMap.put(alpha[alpha.length-1], String.valueOf(tmpBrl));
			}
		}
		
		// add upper case and space
		brailleMap.put(" ", "000000");
		brailleMap.put("up", "000001");
		
		return;
	}

}
