package org.tj.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.tj.util.FileUtil;
import org.tj.util.Regex;
import org.tj.util.http.HttpClientUtil;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 001 on 16/11/3.
 */
public class Spider implements Runnable{

    int topic_id;
    int count = 0;

    JdbcTemplate jdbctemplate = null;
    Logger logger = org.slf4j.LoggerFactory.getLogger(Spider.class);

    public static void main(String[] args) throws ParserException, IOException {

//        System.setProperty("http.proxyHost","117.90.6.123");
//        System.setProperty("http.proxyPort","9000");

        new Thread(new Spider(19561847),"线程1").start();
        new Thread(new Spider(19550447),"线程2").start();
        new Thread(new Spider(20011035),"线程3").start();
        new Thread(new Spider(19550581),"线程4").start();
//
//

//        new Spider(1).processAnswersWithOffset(41799510,8340);
//        new Spider(1).processAnswersWithOffset(31525003,20);
//        processAnQuestion(40670391);
    }

    public Spider(int topic_id){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/zhihu?autoReconnect=true&rewriteBatchedStatements=TRUE");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        jdbctemplate = new JdbcTemplate(dataSource);
        jdbctemplate.execute("set names utf8mb4");
        this.topic_id = topic_id;
    }


    public void processAnTopic() throws IOException, ParserException {
        float offset = 3351.5f;
        while (pickQuestions(topic_id,offset)){
            offset+=0.5;
            logger.info(" 处理分类: "+topic_id+" ,偏移量: "+offset);
        }
    }

    boolean pickQuestions(int topic_id,float offset) throws IOException, ParserException {
        Map<String,String> param = new HashMap<>();
        param.put("start","0");
        param.put("offset",offset+"");
        Map<String,String> header = new HashMap<>();
        header.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        String s = HttpClientUtil.post("https://www.zhihu.com/topic/"+topic_id+"/hot", header, param, "utf-8").getBody();
//        System.out.println(s);
        JSONArray jsonArray = JSON.parseObject(s).getJSONArray("msg");
        if (jsonArray.get(0).equals("0")){
            return false;
        }else {
            Set<String> set = Regex.getStringSet(jsonArray.get(1).toString(), "href=\"/question/(.*?)/answer/");
            logger.info(" 本次偏移量问题："+set);
            for (String question_id:set){
                processAnQuestion(Integer.parseInt(question_id));
            }
            return true;
        }
    }

    synchronized boolean dealThisQuestion(int question_id){
        if (jdbctemplate.queryForObject("select count(*) from question where id = ?",new Object[]{question_id},Integer.class) != 0){
            return true;
        }
        return false;
    }



    void processAnQuestion(int question_id) throws ParserException, IOException {
        if (dealThisQuestion(question_id)){
            logger.info(question_id+" 问题已处理，处理下一个问题。。。");
            return;
        }
//                String s = FileUtil.getFileContent("txt/38992723.txt");
        String s = HttpClientUtil.sendGet("http://www.zhihu.com/question/"+question_id).getBody();
//        int question_id = Integer.parseInt(Regex.getString(new Parser(s).extractAllNodesThatMatch(new HasAttributeFilter("name","apple-itunes-app")).toHtml(),"questions/(.*?)\""));
        logger.info("开始处理新问题: "+question_id);
        String title = new Parser(s).extractAllNodesThatMatch(new HasAttributeFilter("class","zm-item-title")).elementAt(0).getChildren().elementAt(1).toPlainTextString();
        String content = Regex.getString(new Parser(s).extractAllNodesThatMatch(new HasAttributeFilter("id", "zh-question-detail")).toHtml(), "content\">(.*?)</div");
        int answer_nums = getNumber(Regex.getString(new Parser(s).extractAllNodesThatMatch(new HasAttributeFilter("id", "zh-question-answer-num")).toHtml(), "wer-num\">(.*?) 个回答"));
        int follows = getNumber(Regex.getNumber(new Parser(s).extractAllNodesThatMatch(new HasAttributeFilter("class", "zm-side-section-inner zg-gray-normal")).elementAt(0).toPlainTextString()));
        addQuestion(question_id,title,content,follows,answer_nums);
        logger.info("开始处理标签。。。");
        addTags(new Parser(s).extractAllNodesThatMatch(new HasAttributeFilter("class", "zm-item-tag")), question_id);
        logger.info("共有" + answer_nums + "个回答，开始处理回答。。。");
        processAnswers(question_id);
    }

    void processAnswers(int question_id) throws IOException, ParserException {
        int offset = 0;
//        offset = 1390;
        while (process20Answers(question_id,offset)){
            offset+=10;
            try {
                int sleep = ((int)(Math.random()*5))*1000;
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    void processAnswersWithOffset(int question_id,int offset) throws IOException, ParserException {
//        offset = 1390;
        logger.info("处理上次异常中断抓取，问题: "+question_id+" ,偏移量: "+offset);
            while (process20Answers(question_id,offset)){
                offset+=10;
                try {
                    int sleep = ((int)(Math.random()*5))*1000;
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

    boolean process20Answers(int question_id,int offset) throws IOException, ParserException {
        logger.info(" question_id: "+question_id+ " 偏移量: "+offset);
        Map map = new HashMap<>();
        map.put("method","next");
        map.put("params","{\"url_token\":"+question_id+",\"pagesize\":10,\"offset\":"+offset+"}");
        Map<String,String> header = new HashMap<>();
        header.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        JSONObject jsonObject = JSON.parseObject(HttpClientUtil.post("https://www.zhihu.com/node/QuestionAnswerListV2", header, map, "utf-8").getBody());
        JSONArray jsonArray = null;
        try{
            jsonArray = jsonObject.getJSONArray("msg");
        }catch (NullPointerException e){
            e.printStackTrace();
            logger.info("获取失败,线程休眠10s, 重新进行抓取,offset: "+offset);
            try {
                count++;
                if (count>10){
                    jdbctemplate.update("insert into bad_question(question_id,offset)values (?,?)",new Object[]{question_id,offset});
                    return false;
                }
                Thread.sleep(50000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            processAnswersWithOffset(question_id,offset);
            return false;
        }
        if (jsonArray.size()==0){
            return false;
        }else {
            for (int i=0,j=jsonArray.size();i<j;i++){
                try{
                    processAnAnswer(question_id,jsonArray.get(i).toString());
                }catch (NullPointerException e){
                    e.printStackTrace();
                    logger.info(" 出现异常，休眠10s，questio_id:"+question_id+" ,offset: "+offset);
                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    processAnswersWithOffset(question_id,offset);

                }
            }
        }
        return true;
    }






    void  processAnAnswer(int question_id,String html) throws ParserException {

        Parser parser = new Parser(html);
        NodeIterator nodeIterator = parser.elements();
        int count = 0;
        while (nodeIterator.hasMoreNodes()){
            count++;
            Node node = nodeIterator.nextNode();
            NodeList nodeList = node.getChildren();

            int answer_id = Integer.parseInt(Regex.getString(nodeList.elementAt(1).toHtml(), "answer/(.*?)\">"));
            int up = getNumber(Regex.getString(nodeList.elementAt(9).toHtml(), "\"count\">(.*?)</"));

            Node node11 = nodeList.elementAt(11);
            String user_head_img = Regex.getString(node11.toHtml(),"src=\"(.*?)\"");
            String user_href = Regex.getString(node11.toHtml(),"/people/(.*?)\"");
            String user_sign = Regex.getString(node11.toHtml(),"title=\"(.*?)\"");

            Node node13 = nodeList.elementAt(13);
            String user_name = Regex.getString(node13.toHtml(),"author-name=\"(.*?)\"");
//添加用户
            user_href = addUser(user_name,user_sign,user_href,user_head_img);
            Node node17 = nodeList.elementAt(17);
            String answer_desc = Regex.getString(node13.toHtml(),"clearfix\">\n(.*?)\n");
            String update_time = Regex.getString(node17.toHtml(),"编辑于 (.*?)</a>");
            String create_time = "";
            if ("".equals(update_time)){
                create_time = Regex.getString(node17.toHtml(),"发布于 (.*?)</a>");
            }else {
                create_time = Regex.getString(node17.toHtml(),"发布于 (.*?)\" target=");
            }
            String comments_str = Regex.getString(node17.toHtml(),"comment\"></i>(.*?) 条评论");
            int comments = comments_str.equals("")?0:Integer.parseInt(comments_str);

            addAnswer(answer_id,up,user_href,answer_desc,create_time,update_time,comments,question_id);
        }

    }


    void addTags(NodeList tags,int question_id){
        for (int i=tags.size()-1;i>=0;i--){
            int id = Integer.parseInt(getAttribute(tags.elementAt(i), "href").substring(7));
            String name = tags.elementAt(i).toPlainTextString().replace("\n", "").replace(" ", "");
            jdbctemplate.update("insert into topic(id,name)values (?,?) on duplicate key update id = ?", new Object[]{id, name.replace("\n", "").replace(" ", ""), id});
            try{
                jdbctemplate.queryForMap("select * from question_topic where question_id = ? and topic_id = ?",new Object[]{question_id,id});
            }catch (DataAccessException e){
                jdbctemplate.update("insert into question_topic(question_id,topic_id)values (?,?)",new Object[]{question_id,id});
            }
        }
    }

    public void addQuestion(int id,String title,String desc,int follows,int answers){
        jdbctemplate.update("insert into question(id,title,content,follows,answers)values (?,?,?,?,?)on duplicate key update id = ?",new Object[]{id,title,desc,follows,answers,id});
    }

    public String addUser(String name,String sign,String href,String headimg){
        if ("".equals(href)){
            try {
                href = jdbctemplate.queryForObject("select href from user where name = ?",new Object[]{name},String.class);
            }catch (DataAccessException e){
                href = UUID.randomUUID().toString();
            }
        }
        jdbctemplate.execute("set names utf8mb4");
        jdbctemplate.update("insert into user(name,sign,href,head_img) values(?,?,?,?)on duplicate key update href = ? ;",new Object[]{name,sign,href,headimg,href});
        return href;
    }

    public void addAnswer(int id,int up,String href,String content,String create_time,String update_time,int comments,int question_id){
        jdbctemplate.update("insert into answer(id,up,user_id,content,create_time,update_time,comments,question_id)values (?,?,?,?,?,?,?,?)on duplicate key update id = ?",new Object[]{
                id,up,href,content,create_time,update_time,comments,question_id,id
        });
    }


    public String getAttribute(Node node,String attr){
        return Regex.getString(node.toHtml(),attr+"=\"(.*?)\"");
    }

    public int getNumber(String num){
        if (num.contains("K")){
            return Integer.parseInt(num.split("K")[0])*1000;
        }else {
            return Integer.parseInt(num);
        }
    }

    @Override
    public void run() {
        try {
            processAnTopic();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}
