package StringArrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母,例如ac
 * 输出描述:
 * [ac, ca]
 *
 * User:Mr.Du
 * Date:2019-07-01
 * Time:13:04
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = String.valueOf(chars);
        while(s != null){
            list.add(s);
            s = getStr(s);
        }
        System.out.println(list);
    }

    public static String getStr(String s){
        int index = getIndex(s);
        if(index == -1) return null;
        for(int i = s.length()-1;i>index;i--){
            if(s.charAt(i)>s.charAt(index)){
                //交换
                s = swap(s,i,index);
                break;
            }
        }
        //逆转
        return reverse(s,index+1,s.length()-1);
    }


    public static  int getIndex(String s){
        for(int i = s.length()-1;i>0;i--){
            if(s.charAt(i)>s.charAt(i-1))
                return i-1;
        }
        return -1;
    }

    public static String swap(String s,int i,int j){
        char[] chars = s.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return new String(chars);
    }

    public static String reverse(String s,int i,int j){
        char[] chars = s.toCharArray();
        while(i<=j){
            char tmp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = tmp;
        }
        return new String(chars);
    }
}
