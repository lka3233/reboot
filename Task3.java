public class Task3{
	public static void main(String[] args){
		String s ="sdfdsf,srwe14,7854,,dgd,afrfg6789421,afasd234,1235zcpoyudnvode..,10";
		char symbol = ',';
		System.out.println("Count of " + "\"" + symbol + "\"" + " is " + counter(s,symbol));
		System.out.println("Count of " + "\"" + symbol + "\"" + " is " + counter2(s,symbol));
		
	}
	public static int counter(String s, char symbol){
		int count = 0;
		int startIndex = s.indexOf(symbol, 0);
		while (startIndex > -1){
			count++;
			System.out.println(startIndex + 1);
			startIndex = s.indexOf(symbol, startIndex+1);
		}
		return count;
	}
	public static int counter2(String s, char symbol){
		char[] arr = s.toCharArray();
		int count = 0;
		int i = 1;
		for (char ch : arr){
			if (ch == symbol){
				System.out.println(i);
				count++;
			}
			i++;
		}
		return count;
	}
}