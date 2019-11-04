public class Task5{
	public static void main(String[] args){
		String s ="AZ334";
		toR1C1Format(s);
	}
	public static void toR1C1Format(String s){
		char[] cArr = s.toCharArray();
		char[] columnCharArr = getColumnCharArr(cArr);
		int column = findColumnsNumber(columnCharArr);
		int row = findRowsNumber(cArr, columnCharArr.length);
		System.out.println("rows = " + row + " columns = " + column);
	}
	
	public static char[] getColumnCharArr(char[] cArr){
		int columnCount = countColumns(cArr);
		char[] resArr = new char[columnCount];
		for (int i = 0; i < columnCount; i++){
			resArr[i] = cArr[i];
		}
		return resArr;

	}
	
	public static int countColumns(char[] cArr){
		int count = 0;
		for (char c : cArr){
			if (c > 64 && c < 91)
				count++;
		}
		return count;
	}

	public static int findColumnsNumber(char[] columnCharArr){
		switch (columnCharArr.length){
			case 1:
				return calculate(columnCharArr[0]);
			case 2:
				return 26*calculate(columnCharArr[0]) + calculate(columnCharArr[1]);
			case 3:
				return 26 * 26 * calculate(columnCharArr[0]) + 26 * calculate(columnCharArr[1]) + calculate(columnCharArr[2]);
			default:
				return -1;
		}
	}
	
	public static int calculate (char ch){
		return ch - 64;
	}

	public static int findRowsNumber (char[] cArr, int columnsArrSize){
		StringBuilder sb = new StringBuilder();
		for (int i = columnsArrSize; i < cArr.length; i++ ){
			sb.append(cArr[i]);
		}
		return Integer.parseInt(sb.toString());
	}	
}