package com.ilovewl;

import java.util.ArrayList;
import java.util.List;

public class Water {

	int cupCurr1 = 0; // 三升水杯当前水量
	int cupCurr2 = 0; // 四升水杯当前水量
	static int cupCapa1 = 3; // 最大容量
	static int cupCapa2 = 4;

	// 存储最后倒水过程
	static List<Point> resultList = new ArrayList<Point>();

	// 该flag数组是为了方便我们每次回溯时执行下一步时不会再考虑之前的情况
	static List<Flag> flag = new ArrayList<Flag>();
	
	// 存储所有可能的水杯状态，因为是【0，1，2，3】【0，1，2，3，4】，所以一共有20种情况
	static Point[] list = new Point[20];

	// 初始化
	public void init() {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				list[count] = new Point(i, j);
				count++;
			}
		}
		// 第一步肯定是从(0,0)开始，因为默认情况的话两个水杯的初始状态是没有水的
		resultList.add(new Point(0, 0));
	}

	// 倒水处理函数
	public void start() {
		init();
		Point curr = new Point(0, 0);
		Point next;
		label: for (int i = 0; i < 20; i++) {
			if (isOver(curr)) { // 满足条件
				// flag置零代表如果返回到上一步继续找下一步的时候这个状态已经考虑过了是不用再重复考虑
				flag.add(new Flag(curr.x,curr.y,resultList.size()-1));
				print();
				int last = resultList.size() - 1;
				resultList.remove(last); // 去除最后一个元素
				// 如果整个列表为空的话，说明已经返回到（0，0）这个状态，所有状态已经考虑过了，直接return
				if (resultList.isEmpty()) {
					return;
				}
				// 去除最后一个元素之后相当于回到上一步，准备开始倒水操作了，将此时的curr指向列表的最后一个元素
				curr = resultList.get(resultList.size() - 1);
				i = 0;
				continue label;
			}

			// 待定的下一步倒水操作
		    next = list[i];

			// 如果已经置1说明不用考虑这一步了，直接跳过，但是这里置0是为了不影响下一次回溯到上一步时还是要考虑这种情况
			if (flag.contains(new Flag(next.x,next.y,resultList.size()))) {
				continue;
			}

			// 如果倒水操作可行
			if (isCorrect(curr, next)) {
				resultList.add(next); // 将其加到列表后面
				curr = next; // 改变curr的指向
				i = 0; // 重新考虑下一步的20种可能操作
				continue label;
			} else {
				// 这里的意思是：如果我们当前这一步倒水如果遍历了所有20种下一步的倒水情况都不满足情况的话，我们继续回溯，就是删除一步，往前倒
				if (i == 19) {
					// 同理
					flag.add(new Flag(curr.x,curr.y,resultList.size()-1));
					int last = resultList.size() - 1;
					resultList.remove(last); // 去除最后一个元素
					if (resultList.isEmpty()) {
						return;
					}
					curr = resultList.get(resultList.size() - 1);
					i = 0;
					continue label;
				}
			}
		}
	}

	//
	public void printFlag() {
		for(Flag flag:flag) {
			System.out.print(flag);
		}
	}
	
	// 输出整个倒水的过程
	public void print() {
		System.out.println("****************");
		for (int i=0;i<resultList.size();i++) {
			System.out.print(resultList.get(i));
			if(i!=resultList.size()-1) {
				System.out.print("-->");
			}
		}

		System.out.println("\n****************\n\n");
	}

	// 判断当前倒水操作是否可行，curr代表现在两个杯子的水量，next代表经过一次倒水操作之后两个水杯的水量
	public boolean isCorrect(Point curr, Point next) {
		// 如果在前面出现过当前水量，说明形成了一个环，表明当前操作不可行
		if (resultList.contains(next)) {
			return false;
		} else if (next.x == cupCapa1 && next.y == cupCapa2) {
			return false;
		} else
		// 将3升水杯加满，4升水杯不变
		if (curr.x < cupCapa1 && next.x == cupCapa1 && curr.y == next.y) {
			return true;
		} else
		// 将4升水杯加满，3升水杯不变
		if (curr.y < cupCapa2 && next.y == cupCapa2 && curr.x == next.x) {
			return true;
		} else
		// 将3升水杯清空
		if (curr.x > 0 && next.x == 0 && curr.y == next.y) {
			return true;
		} else
		// 将4升水杯清空
		if (curr.y > 0 && next.y == 0 && curr.x == next.x) {
			return true;
		} else
		// 两个杯子相互倒水，肯定有一方是满的或者是空的
		if (next.x - curr.x == curr.y - next.y
				&& (next.x == cupCapa1 || next.y == cupCapa2 || next.x == 0 || next.y == 0)) {
			return true;
		}
		// 其他情况代表操作不可行
		else {
			return false;
		}
	}

	// 判断当前两个水杯的水量是否为5
	public boolean isOver(Point point) {
		return point.x + point.y == 5;
	}

	public static void main(String[] args) {
		new Water().start();
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 必须重写equals方法，否则在判断contains会出错
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj instanceof Point) {
			Point p = (Point) obj;
			return this.x == p.x && this.y == p.y;
		} else {
			return false;
		}
	}

	// 重写toString()方法，方便按我们想要的方式打印
	public String toString() {
		return "(" + x + " , " + y + ")";
	}
}

class Flag{
	int x;
	int y;
	int step;
	Flag(int x,int y,int step){
		this.x=x;
		this.y=y;
		this.step=step;
	}
	// 必须重写equals方法，否则在判断contains会出错
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj instanceof Flag) {
			Flag p = (Flag) obj;
			return this.x == p.x && this.y == p.y&& this.step ==p. step;
		} else {
			return false;
		}
	}
	public String toString() {
		return "("+x+" , "+y+" , "+step+")";
	}
}