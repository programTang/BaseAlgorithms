package org.tj.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.tj.util.FileUtil;
import org.tj.util.Regex;
import org.tj.util.http.HttpClientUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 001 on 16/11/14.
 */
public class SpiderTest {

    public static void main(String[] args) throws ParserException, IOException {

//        String s = FileUtil.getFileContent("txt/38992723.txt");
//        Parser parser = new Parser(s);
        Map map = new HashMap<>();
        map.put("method","next");
        map.put("params","{\"url_token\":38992723,\"pagesize\":20,\"offset\":220}");
        Map<String,String> header = new HashMap<>();
        header.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        String body = HttpClientUtil.post("https://www.zhihu.com/node/QuestionAnswerListV2", header, map, "utf-8").getBody();

        JSONObject jsonObject = JSON.parseObject(body);
        JSONArray jsonArray = jsonObject.getJSONArray("msg");
        System.out.println(jsonArray.size());
        System.out.println(jsonArray.get(0));
        System.out.println("/////////////////////");
        System.out.println(jsonArray.get(1));
//
    }


    public static Map getTags(NodeList tags){
        Map<Integer,String> map = new HashMap<>();

        for (int i=tags.size()-1;i>=0;i--){
            map.put(Integer.parseInt(getAttribute(tags.elementAt(i), "href").substring(7)),tags.elementAt(i).toPlainTextString());
            System.out.println(getAttribute(tags.elementAt(i),"href").substring(7));
            System.out.println(tags.elementAt(i).toPlainTextString());
        }
        return map;
    }

    public static String getAttribute(Node node,String attr){
        return Regex.getString(node.toHtml(),attr+"=\"(.*?)\"");
    }


}
