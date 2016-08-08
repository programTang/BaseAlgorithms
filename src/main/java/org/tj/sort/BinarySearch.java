package org.tj.sort;

/**
 * Created by 001 on 16/8/4.
 */
public class BinarySearch {
//二分查找  针对以排序的数组  时间复杂度为log(n)
//    递归查找
    static int binarySearchByRecursion(int [] array ,int begin,int end,int value){

        if (begin == end){
            return -1;
        }else if (array[(begin+end)/2] != value){
            return array[(begin+end)/2] > value ? binarySearchByRecursion(array,begin,(begin+end)/2,value):binarySearchByRecursion(array,(begin+end)/2+1,end,value);
        }else{
            return (begin+end)/2;
        }
    }

//    循环
    static int binarySearchByLoop(int[] array,int value){

        int start = 0;
        int end = array.length;
        for (int i = 0;i< Math.log(array.length);i++){
            int tmp = array[(start+end)/2];
            if (start == end){
                return -1;
            }else if (tmp == value){
                return (start+end)/2;
            }else if (tmp > value){
                end = (start+end)/2;
            }else {
                start = (start+end)/2+1;
            }
        }
        System.out.print("no execution");
        return -1;
    }

//    改进
    static int binarySearchByLoop2(int[] array,int value){
        int start = 0,end = array.length;
        while (start<=end){
            int tmp = array[(start+end)/2];
            if (tmp == value){
                return (start+end)/2;
            }else if (tmp>value){
                end = (start+end)/2;
            }else {
                start = (start+end)/2+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []array = {1,2,7,8,9,32,92,123,431};
//        int index = binarySearchByLoop(array,9);
        int index = binarySearchByLoop2(array,9);
//        int index = binarySearchByRecursion(array,0,9,31);
        System.out.println(index);
//        System.out.println(index+":" + array[index]);
//        System.out.println(9/2);
    }

}
