package com.zhk.recursion;

import com.sun.tools.javah.Gen;

import java.util.ArrayList;
import java.util.List;
//leetcode 22
public class GenerateParenthesis {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
      generator(0,0,n,"");
      return  res;
    }

    private void generator(int left, int right, int n, String s) {
        //terminator
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        //drill down
        if (left < n) {
            generator(left +1, right, n, s + "(");
        }
        if (left > right) {
            generator(left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        gp.generateParenthesis(3);
    }
}
