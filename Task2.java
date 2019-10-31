public class Task2{
	public static void main(String[] args){
		String s = "Is this a real life, or its just fantasy";
		System.out.println(revert(s));
	}
	public static String revert(String s){
		String[] splitArr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = splitArr.length - 1; i >= 0; i--){
			char comma = splitArr[i].charAt(splitArr[i].length() - 1);
			if ((comma >32) && (comma < 48)){
				splitArr[i] = splitArr[i].substring(0, splitArr[i].length() - 1);
				splitArr[i+1] = splitArr[i+1] + comma;
			}				
		}
		for (int i = splitArr.length - 1; i >= 0; i--){
			sb.append(splitArr[i]+" ");
		}
		return sb.toString();
	}
}