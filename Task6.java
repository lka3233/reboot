class Task6{
	public static void main(String[] args){
		String s1 = "hello";
		String s2 = "world";
		String result = concatIgnoreDouble(s1,s2);
		System.out.println(result);
	}
	
	public static String concatIgnoreDouble(String s1, String s2){
		//чистим задвоение в строках
		String clrS1 = clearString(s1);
		String clrS2 = clearString(s2);
		//сравниваем вторую с первой, если совпадают-не добавляем
		return concatination(clrS2, clrS1);
	}
	
	public static String clearString(String s){
		char[] charArr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = charArr.length-1; i >= 0; i--){
			if (s.indexOf(charArr[i]) == i)
				sb.insert(0, charArr[i]);
		}
		return sb.toString();
	}
	
	public static String concatination(String s2, String s1){
		char[] chS2 = s2.toCharArray();
		StringBuilder sb = new StringBuilder(s1);
		for (char ch : chS2){
			if (s1.indexOf(ch) == -1)
				sb.append(ch);
		}
		return sb.toString();
	}
}