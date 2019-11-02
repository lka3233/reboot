public class Task4{
	public static void main(String[] args){
		String s = "2 + 2 * 2 + 9";
		calc(s);
	}
	
	public static void calc(String s){
		//разбиваем строку на символы
		String[] splitArr = s.split(" ");
		//если сложные вычисления зовем большой калькулятор
		if (splitArr.length > 3)
			bigCalc(splitArr);
		else {
		//второй элемент массива - операция, первый и третий-целые числа
		//свитч на операцию
			switch (splitArr[1]){
				case "+":
					int res = Integer.parseInt(splitArr[0])+Integer.parseInt(splitArr[2]);
					System.out.println(res);
					break;
				case "-":
					res = Integer.parseInt(splitArr[0])-Integer.parseInt(splitArr[2]);
					System.out.println(res);
					break;
				case "*":
					res = Integer.parseInt(splitArr[0])*Integer.parseInt(splitArr[2]);
					System.out.println(res);
					break;
			//если деление-результат будет типа дабл
				case "/":
					double resD = Double.parseDouble(splitArr[0])/Double.parseDouble(splitArr[2]);
					System.out.println(resD);
					break;
			}
		}
	}
	
	public static void bigCalc(String[] splitArr){
		int bufPos = 0;
		//обработка приоритетов
		for (int i = 0; i < splitArr.length; i++){
			if (splitArr[i].equals("/") || splitArr[i].equals("*"))
				if (splitArr[i].equals("/")){
					splitArr[bufPos]= String.valueOf(Double.parseDouble(splitArr[bufPos]) / Double.parseDouble(splitArr[i + 1]));
					i++;
				} else{
					splitArr[bufPos]= String.valueOf(Double.parseDouble(splitArr[bufPos]) * Double.parseDouble(splitArr[i + 1]));
					i++;
				}
			else
				bufPos = i;
		}
		//обработка неприоритетов
		bufPos = 0;
		for (int i = 0; i < splitArr.length; i++){
			if (splitArr[i].equals("+") || splitArr[i].equals("-"))
				if (splitArr[i].equals("+")){
					splitArr[bufPos]= String.valueOf(Double.parseDouble(splitArr[bufPos]) + Double.parseDouble(splitArr[i + 1]));
					i++;
				} else{
					splitArr[bufPos]= String.valueOf(Double.parseDouble(splitArr[bufPos]) - Double.parseDouble(splitArr[i + 1]));
					i++;
				}
		}
		System.out.println(splitArr[0]);
	}
}