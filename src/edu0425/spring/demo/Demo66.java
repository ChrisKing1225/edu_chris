package edu0425.spring.demo;

public class Demo66 {
	public static void main(String[] args) {
		
		
		System.out.println(fact(5));
		System.out.println(fib(10));
		System.out.println(gcd(888,54));
		int[][] a= {{1,2,3},{4,5,6}};
		int[][] ext_a=extend_sum(extend_sum(a));
		print_2D(ext_a);
		
	}
	//**************//
	private static int fact(int n) {
		if (n == 1) {
			return 1;
		} else
			return fact(n - 1) * n;
	}
	//**************//
	private static int fib(int n) {
		if(n==1||n==2){
			return 1;
		} else
			return fib(n - 1) + fib(n - 2);
		
	}
	//**************//
	private static int gcd(int a,int b) {
		if(a%b==0) {
			return b;
		}else {
			return gcd(b,a%b);
		}
				
	}
	//**************//
	private static int[][] extend_sum(int[][] a){
		
		int [][]rs=new int[a.length+1][a[0].length+1];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				rs[i][j]=a[i][j];
				rs[i][rs[i].length-1]+=a[i][j];
				rs[rs.length-1][j]+=a[i][j];
				rs[rs.length-1][rs[i].length-1]+=a[i][j];
		}
		}
		return rs;
	}
	
	private static void print_2D(int[][] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+" ");	
	}
			System.out.println();
	}
	}
	
	
	
	
}
