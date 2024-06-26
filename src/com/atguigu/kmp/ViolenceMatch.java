package com.atguigu.kmp;

public class ViolenceMatch {
    public static void main(String[] args) {
        //测试暴力算法
        String str1="abcdabdabcacbcd";
        String str2="abca";
        System.out.printf("首次出现位置是%d\n",violenceMatch(str1,str2));
    }
    //暴力匹配算法实现
    public static  int violenceMatch(String str1,String str2){
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();

        int slen1=s1.length;
        int slen2=s2.length;

        int i=0;//指向s1
        int j=0;//指向s2

        while( i < slen1 && j < slen2 ){//保证匹配时不越界
            if(s1[i]==s2[j]){//匹配到相同字符
                i++;
                j++;
            }else{
                i=i-(j-1);
                j=0;
            }
        }
        if(j==slen2){
            return i-j;
        }else{
            return -1;
        }
    }
}
