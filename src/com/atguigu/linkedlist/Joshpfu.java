package com.atguigu.linkedlist;

public class Joshpfu {
    public static void main(String[] args) {
        //测试
        CircleSingLinkedList circleSingLinkedList=new CircleSingLinkedList();
        circleSingLinkedList.addChild(25);
        circleSingLinkedList.showChild();
        circleSingLinkedList.countChild(2,1,5);

    }
}
class CircleSingLinkedList{
    //创建一个first节点，当前没有编号
    private Child first=new Child(-1);
    //添加小孩节点，构成一个环形链表
    public void addChild(int nums){
        //数据校验
        if(nums<1){
            System.out.println("小孩数量不正确");
            return;
        }
        Child cur=null;//辅助指针，帮助构建环形链表
        //使用循环创建环形链表
        for(int i=1;i<=nums;i++){
            //根据编号，创建小孩节点
            Child child=new Child(i);
            //如果是第一个小孩
            if(i==1){
                first=child;
                first.setNext(first);//构成环
                cur=first;//使cur指向第一个小孩
            }else{
                cur.setNext(child);
                child.setNext(first);
                cur=child;
            }
        }
    }
    //遍历当前环形链表
    public void showChild(){
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        Child p=first;
        while(true){
            System.out.printf("小孩的编号是%d\n",p.getNo());
            if(p.getNext()==first){//说明指针已遍历一圈
                break;
            }
            p=p.getNext();
        }
    }
    //根据用户输入，计算出小孩出圈顺序
    public void countChild(int count,int startNo,int nums){
        //对数据进行校验，如果开始节点大于开始时总节点数量，
        //或链表为空，或开始节点小于1，则说明参数有误
        if(startNo<1 || startNo>nums || first==null){
            System.out.println("输入数据有误，请重新输入~~");
            return;
        }
        //创建辅助指针
         Child helper=first;
        while(true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
        for(int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }
        while(true){
            if(helper==first){
                //说明只剩一个节点
                break;
            }
            //令first和helper同时移动count-1次
            for(int j=0;j<count-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            //此时first指向需要出圈的节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号是%d\n",first.getNo());
    }


}
//先定义一个小孩类
class Child{
    private int no;
    private Child next;
    public Child(int no){
        this.no=no;
    }

    @Override
    public String toString() {
        return "Child{" + "no=" + no +  '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Child getNext() {
        return next;
    }

    public void setNext(Child next) {
        this.next = next;
    }
}
