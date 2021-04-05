package com.xiekun.algs;

public class MyRegExMatch {
    public boolean isMatch(String s, String p) {
        // if(s.length() != p.length()) return false;
        // if(s.length() == 0 && p.length() == 0) return true;
        // 第一个字符是否匹配，p 的第一个字符是 '.' 时，也是匹配的。
        if(p.isEmpty()) return s.isEmpty();
        boolean first = (!s.isEmpty()) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // 如果 p 的第二个字符是 '*' 时，可以直接去除，也可以一个一个往后匹配
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first && isMatch(s.substring(1), p));
        } else {
            return first && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new MyRegExMatch().isMatch("ab", ".*c"));
    }
}
