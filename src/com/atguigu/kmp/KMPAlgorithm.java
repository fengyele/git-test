package com.atguigu.kmp;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1="abcabbdabcacbcd";
        String str2="abcabc";
        int[] next=kmpNext(str2);
        System.out.println(kmpSearch(str1,str2,next));
    }
    //KMP搜索算法
    public static int kmpSearch(String str1,String str2,int[] next){
        //遍历str1查找str2
        int s1=str1.length();
        char[] st1=str1.toCharArray();
        int s2=str2.length();
        char[] st2=str2.toCharArray();
        int i=0;
        int j=0;
        while(i<s1&&j<s2){
            if(st1[i]==st2[j]){
                i++;
                j++;
            }else{
                i=i+1-next[j];
                j=0;
            }
        }
        if(j==s2){
            return i-j;
        }else{
            return -1;
        }
    }
    //获取一个字符串的部分匹配表
    public static int[] kmpNext(String dest){
        //创建一个数组保存匹配值
        int[] next=new int[dest.length()];
        next[0]=0;//如果字符串长度为1.部分匹配值为0
        for(int i=1,j=0;i<dest.length();i++){
            while(j>0&&dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
