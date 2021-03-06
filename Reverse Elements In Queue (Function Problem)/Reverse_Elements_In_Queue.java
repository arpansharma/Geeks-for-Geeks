package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Arpan Sharma on 17-09-2017.
 */
public class Reverse_Elements_In_Queue {
    public static  void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> a = new LinkedList<Integer>();

        int n = br.read() - 48;
        int dump = br.read();
        int k = (int)br.read() - 48;
        dump = br.read();

        String input = br.readLine();
        String array[] = input.split(" ");

        for(int i = 0; i < array.length; ++i)
            a.add(Integer.parseInt(array[i]));

        List<Integer> num = new ArrayList<Integer>(a);

        int end = k-1;
        for(int i = 0; i < k/2; ++i)
        {
            int t = num.get(i);
            num.set(i, num.get(end));
            num.set(end, t);
            --end;
        }
        a = new LinkedList<Integer>(num);
        System.out.println(a);
    }
}
