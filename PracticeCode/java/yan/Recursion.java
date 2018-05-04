package yan;

public class Recursion {
	public static int Sum(int n) {
		if( n<=1 ) return 1;
		else return n + Sum(n-1);
	}
	public static int Fac(int n) {
		if( n<=1 ) return 1;
		else return n * Fac(n-1);
	}
	public static int Fib(int n) {
		if( n<=2 ) return 1;
		else return Fib(n-1) + Fib(n-2);
	}
	public static int MaxFac(int n1,int n2) {
		if( n1==n2 ) return n1;
		else return MaxFac( Math.abs(n1-n2), Math.min(n1, n2));
	}
	public static int Han(int n) {
		if( n==1 )return 1;
		else return Han(n-1) + 1 +Han(n-1);
	}
	public static int Han2(int n,char a,char b,char c) {
		if( n==1 ) return move(a,c);
		else return Han2(n-1,a,c,b) + move(a,c) + Han2(n-1,b,a,c);
	}
	public static int move(char a,char b) {
		System.out.println("from"+" "+a+" "+ "to"+b);
		return 1;
	}
}
