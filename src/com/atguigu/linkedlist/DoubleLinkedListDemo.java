package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}
class DoubleLinkedList{
    HeroNodee head=new HeroNodee(0,"","");
}
class HeroNodee{
    int no;
    String name;
    String nickname;
    HeroNodee next;
    HeroNodee pre;
    //构造器
    public HeroNodee(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "HeroNodee{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + '\'' +  '}';
    }
}
