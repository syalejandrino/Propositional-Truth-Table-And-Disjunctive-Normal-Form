import java.util.*;

public class PTT_DNF {
	
	private static boolean resA, resB, resC, resD, resE;
	
	private static String[] array = new String[16];
	private static int count = 0;
	
	public static boolean layTerms(boolean a, boolean b, boolean c, boolean d) {
		return !(a && b && !c) && (b && d);
	}
	
	public static String convert(boolean ans) {
		if (ans == true) {
			return "T";
		}else {
			return "F";
		}
	}
	
	public static String DNF(String ans) {
		
		String A, B, C, D;
		
		if(ans.equals("T")) {
			if(resA == true) {
				A = "a";
			}
			else {
				A = "!a";
			}
			if(resB == true) {
				B = "b";
			}
			else {
				B = "!b";
			}
			if(resC == true) {
				C = "c";
			}
			else {
				C = "!c";
			}
			if(resD == true) {
				D = "d";
			}
			else {
				D = "!d";
			}
			array[count] = ("(" + A + " && " + B + " && " + C + " && " + D + ")");
			count += 1;
		}
		return "none";
	}
	
	public static boolean printRes(boolean a, boolean b, boolean c, boolean d) {
		
		String finalResA = "none";
		String finalResB = "none";
		String finalResC = "none";
		String finalResD = "none";
		String finalResE = "none";
		
		resA = a;
		resB = b;
		resC = c;
		resD = d;
		resE = layTerms(resA, resB, resC, resD);
		
		finalResA = convert(resA);
		finalResB = convert(resB);
		finalResC = convert(resC);
		finalResD = convert(resD);
		finalResE = convert(resE);
		
		DNF(finalResE);
		System.out.println(finalResA + " " + finalResB + " " + finalResC + " " + finalResD + " | " + finalResE);
		return true;
	}
	
	public static void main(String[] args) {
		
		String DisRes = "";
		
		System.out.println("a b c d | e");
		System.out.println("------------");
		printRes(false,false,false,false);
		printRes(false,false,false,true);
		printRes(false,false,true,false);
		printRes(false,false,true,true);
		printRes(false,true,false,false);
		printRes(false,true,false,true);
		printRes(false,true,true,false);
		printRes(false,true,true,true);
		printRes(true,false,false,false);
		printRes(true,false,false,true);
		printRes(true,false,true,false);
		printRes(true,false,true,true);
		printRes(true,true,false,false);
		printRes(true,true,false,true);
		printRes(true,true,true,false);
		printRes(true,true,true,true);
		
		for(int i=0; i<count; i++) {
			DisRes = DisRes + array[i] + " || ";
		}
		if(!DisRes.equals("")) {
			DisRes = DisRes.substring(0, DisRes.length()-4);
			System.out.println(DisRes);
		}else {
			System.out.println("false");
		}
	}
	
	
}
