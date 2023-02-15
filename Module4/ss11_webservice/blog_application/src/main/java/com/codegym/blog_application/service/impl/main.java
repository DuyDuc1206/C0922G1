package com.codegym.blog_application.service.impl;

public class main {
    boolean solution(String s) {
        char[] ch=s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if ((ch[i] == '(' && ch[i+1] ==')') || (ch[i] == '{' && ch[i+1] =='}') || (ch[i] == '[' && ch[i+1] ==']')) {
                i++;
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
