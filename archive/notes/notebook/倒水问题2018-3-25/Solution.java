package com.ilovewl;


/**
 * 因为这里倒水只能是一个水杯倒满再往另一个水杯加水，另一个水杯满了再倒掉，直到符合条件之后停止
 * @author MrBread
 *
 */
public class Solution{
	 static int a=4, b=3 ,c=5 ;
	public static void main(String args[]) {
		
		int cnt=10;
		Point[] result= new Point[1000];
		int x=0,y=0;//x是a升水杯的当前水量，y是b升水杯的当前水量，默认为0
		int i=0;
		while(cnt--!=0) {
			result[i++]=new Solution().new Point(x,y);
			if(x + y== c) {
				//如果a水杯加上b水杯的水量刚好等于c,就满足条件，可以退出
				break;
			}
			if(x==0) {
				//a水杯如果没水，装满
				x=a;
				continue;
			}
			if(y==b) {
				//b水杯如果满了，则倒掉
				y=0;
				continue;
			}
			int tmp=y;
			y+=x;  //把a中的水倒入b水杯
			if(y>b) {
				//b水杯装满，y最大等于b
				y=b;
			}
			x=x-(b-tmp); //a水杯倒入b水杯后剩余量
			if(x<0) {
				//小于0,则重置于0
				x=0;
			}
		}
		for(Point point:result) {
			if(point==null) {
				break;
			}
			System.out.println(point);
		}
	}
	
	//存储每次3升水杯和4升水杯的水量的一个类
	class Point{
		int x;
		int y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
		public String toString() {
			return "("+x+" , "+y+")";
		}
	}
}