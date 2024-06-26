package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建一个环形队列
        Scanner scan=new Scanner(System.in);
        System.out.println("输入要创建的队列大小:");
        int size=scan.nextInt();
        CircleArrayQueue circlearrayQueue=new CircleArrayQueue(size+1);
        char key = ' ';
        boolean t=true;
        while(t){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("g(get):取出数据");
            System.out.println("a(add):添加数据");
            System.out.println("h(head):查看头数据");
            key=scan.next().charAt(0);
            switch (key){
                case 's':
                    circlearrayQueue.showQueue();
                    break;
                case 'e':
                    t=false;
                    break;
                case 'g':
                    try{
                        System.out.printf("取出的数据是：%d\n",circlearrayQueue.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输入要加入队列的值");
                    int num=scan.nextInt();
                    circlearrayQueue.addQueue(num);
                    break;
                case 'h':
                    try{
                        System.out.printf("头数据是:%d\n",circlearrayQueue.getfront());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        System.out.println("程序退出");
        scan.close();
    }

}
//使用数组模拟队列-编写一个ArrayQueue类
class CircleArrayQueue{
    private int maxsize;//队列最大容量
    //
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数据模拟队列

    //创建队列的构造器
    public CircleArrayQueue(int arrmaxsize){
        maxsize=arrmaxsize;
        arr=new int[maxsize];
        front=0;//指向队列头部，分析出front是指向队列第一个数据的位置
        rear=0;//指向队列尾，即队列最后一个数据的下一个位置
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxsize==front;
    }
    //判断队列是否空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能添加数据~~");
            return;
        }
        arr[rear]=n;//赋值并将队列尾后移
        rear=(rear+1)%maxsize;
    }
    //获取队列数据，即出队列
    public int getQueue(){
        if(isEmpty()){
            //通过抛出异常结束方法
            throw new RuntimeException("队列为空，无法取数据~~");
        }
        int value=arr[front];
        front=(front+1)%maxsize;
        return value;
    }
    public void showQueue(){
        //判断队列是否空
        if(isEmpty()){
            System.out.println("队列为空，没有数据~~");
            return;
        }
        //遍历
        for(int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxsize,arr[i%maxsize]);
        }
    }
    //求出当前队列有效数据
    public int size(){
        return (rear+maxsize-front)%maxsize;
    }
    //获取显示队列的头数据，但不取出队列
    public int getfront(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front];
    }
}
