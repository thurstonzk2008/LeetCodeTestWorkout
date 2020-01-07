package com.zhk.dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> start = new HashSet<>(),
                end = new HashSet<>();
        HashSet<String> dic = new HashSet<>(wordList);
        int step = 1;


        start.add(beginWord);
        end.add(endWord);
        if (!dic.contains(endWord)) {
            return 0;
        }

        while (!start.isEmpty()) {
            step++;
            HashSet<String> tmpSet = new HashSet<>();
            dic.removeAll(start);
            for (String s : start) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (tmp == 'c') {
                            continue;
                        }
                        arr[i] = c;
                        String strTmp = new String(arr);
                        if (dic.contains(strTmp)) {
                            if (end.contains(strTmp)) {
                                return step;
                            } else {
                                tmpSet.add(strTmp);
                            }
                        }
                    }
                    arr[i] = tmp;
                }
            }
            if (tmpSet.size() < end.size()) {
                start = tmpSet;
            } else {
                start = end;
                end = tmpSet;
            }
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        HashSet<String> dic = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        int step = 1;
        if (!dic.contains(endWord)) return 0;
        while (!start.isEmpty()) {
            step++;
            HashSet<String> tmpSet = new HashSet<>();
            dic.removeAll(start);
            for (String s : start) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (tmp == c) continue;
                        arr[i] = c;
                        String strTmp = new String(arr);
                        if (dic.contains(strTmp)) {
                            if (end.contains(strTmp)) {
                                return step;
                            } else {
                                tmpSet.add(strTmp);
                            }
                        }
                    }
                    arr[i] = tmp;
                }
            }
            if (tmpSet.size() < end.size()) {
                start = tmpSet;
            } else {
                start = end;
                end = tmpSet;
            }

        }
        return 0;
    }


    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("hog");
        wordList.add("lot");
        wordList.add("hog");
        wordList.add("cog");
        String beginWord = "hit";
        String endWord = "cog";
        LadderLength ll = new LadderLength();
        int res = ll.ladderLength(beginWord, endWord, wordList);
        System.out.println("res = " + res);
    }
}
