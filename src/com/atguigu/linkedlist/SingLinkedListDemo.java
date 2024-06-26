package com.atguigu.linkedlist;

public class SingLinkedListDemo {
    public static void main(String[] args){
        HeroNode hero1=new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero5=new HeroNode(2,"卢","麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"李逵","黑旋风");
        HeroNode hero6=new HeroNode(5,"李逵","黑旋风");
        SingLinkedList singLinkedList = new SingLinkedList();
        singLinkedList.add(hero1);
        singLinkedList.add(hero4);
        singLinkedList.add(hero4);
        singLinkedList.add(hero2);
        singLinkedList.add(hero3);
        singLinkedList.add(hero2);
        singLinkedList.list();
        singLinkedList.update(hero5);
        singLinkedList.update(hero6);
        singLinkedList.list();
        singLinkedList.delete(5);
        singLinkedList.list();
        singLinkedList.delete(1);
        singLinkedList.delete(4);
        System.out.println();
        singLinkedList.list();
    }
}
class SingLinkedList{
    //初始化头节点，不存放具体数据
    private HeroNode head=new HeroNode(0,"","");
    //链表添加节点
    public void add(HeroNode heroNode){
        HeroNode p=head;
        while(true){
            if(p.next==null){
                p.next=heroNode;
                break;
            }
            if(p.next.no==heroNode.no){
                System.out.printf("no=%d的英雄已存在\n",heroNode.no);
                break;
            }else if(p.next.no>heroNode.no){
                heroNode.next=p.next;
                p.next=heroNode;
                break;
            }
            p=p.next;
        }
    }
    //链表显示数据
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode p=head.next;
        while(true){
            if(p==null){
                break;
            }
            System.out.println(p);
            p=p.next;
        }
    }
    //链表修改节点数据
    public void update(HeroNode heroNode){
        HeroNode p=head;
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        while(true){
            if(p.next==null){
                System.out.printf("不存在no=%d的英雄\n",heroNode.no);
                break;
            }
            if(p.next.no==heroNode.no){
                heroNode.next=p.next.next;
                p.next=heroNode;
                break;
            }
            p=p.next;
        }
    }
    //删除节点
    public void delete(int no){
        HeroNode p=head;
        if(head.next==null){
            System.out.println("链表为空，无法删除");
        }
        while(true){
            if(p.next==null){
                System.out.printf("不存在no=%d的英雄\n",no);
                break;
            }
            if(p.next.no==no){
                p.next=p.next.next;
                break;
            }
            p=p.next;
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点
    //构造器
    public HeroNode(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

    //为了显示，重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + '\'' + '}';
    }
}
