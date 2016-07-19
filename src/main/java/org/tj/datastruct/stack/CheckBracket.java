package org.tj.datastruct.stack;

/**
 * Created by 001 on 16/7/4.
 */
public class CheckBracket  {
//    用栈检查括号
    public static void main(String[] args) {

        boolean flag = true;

        String express = "[asd{asd((as)sa}a]";
        Stack<String> stack = new Stack<String>();
        char[] chars = express.toCharArray();
        for (char a : chars){
            if (a=='[' || a=='(' || a=='{'){
                stack.push(""+a);
            }else if (a==']' && !stack.pop().equals("[")){
                flag = false;
                break;
            }else if (a==')' && !stack.pop().equals("(")){
                flag = false;
                break;
            }else if (a=='}' && !stack.pop().equals("{")){
                flag = false;
                break;
            }
        }
        if (stack.getSize() == 0 && flag == true)
            System.out.println("yes");
    }

}
