public class Task1{
	public static void main(String[] args){
		String[] input = {"Z11-120","Z12-150","Z13-200","Z11-100","Z12-0","Z13-120","Z11-125","Z12-129","Z13-070"};
		final double rashodZ11 = 12.5;
		final double rashodZ12 = 12;
		final double rashodZ13 = 11.5;
		final double priceZ11 = 46.10;
		final double priceZ12 = 47.50;
		final double priceZ13 = 48.90;
		double resZ11 = findRes(input, priceZ11, rashodZ11, "Z11");
		double resZ12 = findRes(input, priceZ12, rashodZ12, "Z12");
		double resZ13 = findRes(input, priceZ13, rashodZ13, "Z13");
		
		//расчитать общий денежный расход при нефикс. расходе
		double result = resZ11 + resZ12 + resZ13;
		System.out.println(result);
		//расчитать общий денежны расход при фикс расходе
		resZ11 = findRes(input, priceZ11, 15.0, "Z11");
		resZ12 = findRes(input, priceZ12, 15.0, "Z12");
		resZ13 = findRes(input, priceZ13, 15.0, "Z13");
		result = resZ11 + resZ12 + resZ13;
		System.out.println(result);
		//расчитать макс расход
		//расчитать мин расход
		minMax(resZ11, resZ12, resZ13);
				
	}
	public static double findRes(String[] input, double price, double rashod, String type){
		double result = 0;
		for (String inp:input){
			String[] buf = inp.split("-");
			if (buf[0].equals(type)) 
				result+=Integer.parseInt(buf[1])*price*rashod;
		}
		return result;
	}
	
		public static void minMax(double resultZ11, double resultZ12, double resultZ13){
			if ((resultZ11<resultZ12) && (resultZ11<resultZ13))
				System.out.println("Min Z11"); 
			if ((resultZ12<resultZ11) && resultZ12<resultZ13)
				System.out.println("Min Z12");
			if ((resultZ13<resultZ11) && resultZ13<resultZ12)
				System.out.println("Min Z13");
			
			if ((resultZ11>resultZ12) && (resultZ11>resultZ13))
				System.out.println("Max Z11"); 
			if ((resultZ12>resultZ11) && resultZ12>resultZ13)
				System.out.println("Max Z12");
			if ((resultZ13>resultZ11) && resultZ13>resultZ12)
				System.out.println("Max Z13");
			
		}
}
