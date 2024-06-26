package com.atguigu.dynamic;


public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w={1,4,3};//物品的重量
        int[] v={1500,3000,2000};//物品的价值
        int b=4;//背包的容量
        int n=v.length;//物品的数量
        int[][] val=new int[n+1][b+1];//val[i][j]表示当容量为j时前i个物品的最大价值
        for(int i=1;i<val.length;i++){
            for(int j=1;j<val[0].length;j++){
                if(w[i-1]>j){
                    val[i][j]=val[i-1][j];
                }else{
                    val[i][j]=Math.max(val[i-1][j-w[i-1]]+v[i-1],val[i-1][j]);
                }
            }
        }

    }
}
