package org.tj.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.tj.util.http.HttpClientUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 001 on 16/11/14.
 */
public class FileUtil {


    public static void writeFile(String content,String fileName){
        File file = new File(fileName);
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(content.getBytes("UTF-8"));
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileContent(String fileName){
        String content = "";
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                content += line+"\r\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    public static void main(String[] args) throws IOException {
        Map<String,String> param = new HashMap<>();
        param.put("start","0");
        param.put("offset","3320");
        Map<String,String> header = new HashMap<>();
        header.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        String s = HttpClientUtil.post("https://www.zhihu.com/topic/19581716/hot", header, param, "utf-8").getBody();
        JSONArray jsonArray = JSON.parseObject(s).getJSONArray("msg");
        System.out.println(Regex.getStringSet(jsonArray.get(1).toString(), "href=\"/question/(.*?)/answer/"));


    }

}
