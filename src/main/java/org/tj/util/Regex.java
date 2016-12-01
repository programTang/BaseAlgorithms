package org.tj.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 001 on 16/11/3.
 */
public class Regex {

    public static void main(String[] args) {
//        String str = "<link itemprop=\"url\" href=\"/question/22619910/answer/39843878\">";
        String str = "<div class=\"zm-item-meta answer-actions clearfix js-contentActions\">\n" +
                "<div class=\"zm-meta-panel\">\n" +
                "\n" +
                "<a itemprop=\"url\" class=\"answer-date-link meta-item\" data-tooltip=\"s$t$发布于 2015-04-01\" target=\"_blank\" href=\"/question/29210750/answer/43562452\">编辑于 2015-04-02</a>\n" +
                "\n" +
                "<a href=\"#\" name=\"addcomment\" class=\"meta-item toggle-comment js-toggleCommentBox\">\n" +
                "<i class=\"z-icon-comment\"></i>143 条评论</a>\n" +
                "\n" +
                "\n" +
                "<a href=\"#\" class=\"meta-item zu-autohide js-thank\" data-thanked=\"false\"><i class=\"z-icon-thank\"></i>感谢</a>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<a href=\"#\" class=\"meta-item zu-autohide js-share\"><i class=\"z-icon-share\"></i>分享</a>\n" +
                "\n" +
                "<a href=\"#\" class=\"meta-item zu-autohide js-collect\"><i class=\"z-icon-collect\"></i>收藏</a>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<span class=\"zg-bull zu-autohide\">&bull;</span>\n" +
                "\n" +
                "<a href=\"#\" class=\"meta-item zu-autohide js-noHelp\">没有帮助</a>\n" +
                "\n" +
                "<span class=\"zg-bull zu-autohide\">&bull;</span>\n" +
                "<a href=\"#\" class=\"meta-item zu-autohide js-report\">举报</a>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<meta name=\"copyrightStatus\" content=\"2\">\n" +
                "<meta name=\"disableCopyAvatar\" content=\"https://pic2.zhimg.com/69ec8d436acb82eaf8e55e07c92c16e9_s.jpg\">\n" +
                "\n" +
                "<span class=\"zg-bull\">&bull;</span>\n" +
                "\n" +
                "\n" +
                "<a href=\"/copyright/apply?answer=43562452\" target=\"_blank\" class=\"meta-item copyright\">申请转载</a>\n" +
                "\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>";
//        String reg = "发布于 (.*?)</a>";
//        String reg = "编辑于 (.*?)</a>";
        String reg = "comment\"></i>(.*?) 条评论";
        System.out.println(getString(str, reg));
    }

    public static String getString(String str,String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        ArrayList<String> strs = new ArrayList<String>();
        while (m.find()) {
            strs.add(m.group(1));
        }
        return strs.isEmpty()?"":strs.get(0);
    }

    public static List getStringArray(String str,String reg){
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        ArrayList<String> strs = new ArrayList<String>();
        while (m.find()) {
            strs.add(m.group(1));
        }
        return strs;
    }

    public static Set getStringSet(String str,String reg){
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        Set<String> strs = new HashSet<>();
        while (m.find()) {
            strs.add(m.group(1));
        }
        return strs;
    }

    public static String getNumber(String str){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }


}
