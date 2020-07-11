package edu0425.spring.demo;

import java.util.Stack;

public class Demo0627 {

	public static void main(String[] args) {
		int[] a = {1,3,3,4,4,6,7};
		moveArray(a,3);
		findNums(a);
		findNums2(a);
		int[] b = {2,7,11,9};
		getTwoSum(b,9);
		String edu = "13+52-*6/";
		System.out.println("13+52-*6/的结果是:"+rpn(edu));
		System.out.println(calcT(1,5));
		System.out.println(calcT(2,5));
		System.out.println(calcT(3,5));
		NodeDemo node = new NodeDemo(5);
		node.insert(10);
		node.insert(15);
		node.insert(11);
		node.insert(12);
		node.insert(8);
		node.insert(3);
		node.inorder();
	}
	
	private static void moveArray(int[] a, int k) {
		//数组移位
		while (k>0) {
			for(int i=1;i<a.length;i++) {
				int temp=a[0];
				a[0]=a[i];
				a[i]=temp;
			}
			k--;
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"");
		}
		System.out.println();
	}
	
	private static void findNums(int[] a) {
		int k=a.length;
		while(k>0) {
			int cnt=0;
			for(int i=0;i<a.length;i++) {
				if(a[i]==k) {
					cnt=cnt+1;
				}
			}
			if(cnt==0) {
				System.out.println(k);
			}
			k--;
		}
	
	}
	
	private static void findNums2(int[] nums) {
		for(int i= 0; i<nums.length;i++) {
			if(nums[Math.abs(nums[i])-1]>=0) {
				nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i]-1)];
			}
		}
		for(int j=0 ;j < nums.length;j++) {
			if(nums[j] > 0) {
				System.out.println(j+1);
			}
		}
	}
	
	private static void getTwoSum(int [] nums,int target) {
		int[] result = new int[2];
		for(int i=0;i<nums.length-1;i++) {
			for(int j=1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					result[0]=i;
					result[1]=j;
					break;
				}
			}
			
		}
	System.out.println(result[0]+","+result[1]);
	}
	
	
	private static int rpn(String edu) {
		Stack<Integer> s= new Stack<Integer>();
		char[] c = edu.toCharArray();
		int size=c.length;
			for(int i=0;i<size;i++) {
			if(isNum(c[i])) {
				int num=Character.getNumericValue(c[i]);
				s.push(num);
				System.out.println(num);
			}else {
				int x=0;
				int y=0;
				switch(c[i]) {
				case'+':
					x=s.pop();
					y=s.pop();
					s.push(x+y);
					break;
				case'-':
					x=s.pop();
					y=s.pop();
					s.push(y-x);
					break;
				case'*':
					x=s.pop();
					y=s.pop();
					s.push(y*x);
					break;
				case'/':
					x=s.pop();
					y=s.pop();
					s.push(y/x);
					break;
				default:
					break;
				}
			}
		}
			
		return (int)s.pop();
	}

	private static boolean isNum(char c) {
		if(c < 48 || c >57) 
			return false;
			return true;
			
	}
	
	private static final int[] C= {1,2,4,7};

	private static int calcT(int n,int m){
		if(n < 0 || m <= 0) {
			return 0;
		}
		int count =0;
		if(m>=C[n]) {
			 count=m/C[n];
			 if(m%C[n] !=0) {
				 count+=calcT(n-1,m%C[n]);
			 }
		 }else {
			 return calcT(n-1,m);
		 }
		 return count;
	}
	
		

	
}
