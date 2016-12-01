package org.tj.study.file;

import org.tj.datastruct.tree.TreeNode;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by 001 on 16/8/5.
 */
public class FileUtil {
//    递归遍历文件系统所有文件 先序遍历 先处理节点  然后 左右
    static void listAllFilesFirst(File file,TreeNode<String> treeNode,FilenameFilter fileFilter){
        if (file.isFile()){
//            if (file.getName().endsWith(".pdf")){
//                System.out.println(file.getAbsolutePath()+file.getName());
            treeNode.setData(file.getAbsolutePath()+"/"+file.getName());
//                return;
//            }
        }else {
//            System.out.println(file.getAbsolutePath());
            TreeNode<String> treeNode1 = new TreeNode<>(file.getAbsolutePath());
            treeNode.setFirstChild(treeNode1);

            File[] files = file.listFiles(fileFilter);
            if (files != null){
                for (File file1:files){
                    listAllFilesFirst(file1,treeNode1,fileFilter);
                }
            }
        }
    }

    static void listAllFilesAfter(File file){
        if (file.isDirectory()){
            System.out.println(file.getAbsolutePath());
            File[] files = file.listFiles();
            if (files != null){
                for (File file1:files){
                    listAllFilesAfter(file1);
                }
            }else {
//                文件
                if (file.getName().endsWith(".pdf")){
                    System.out.println(file.getAbsolutePath()+file.getName());
                    return;
                }
            }
        }
    }

//    stat

    public static void main(String[] args) {
        FilenameFilter fileFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.startsWith(".")){
                    return false;
                }
                return true;
            }
        };
        TreeNode<String> treeNode = new TreeNode<>("/Users/fahai/Documents");
        listAllFilesFirst(new File("/Users/fahai/Documents"), treeNode,fileFilter);
        System.out.println(treeNode.getFirstChild().getData());

//        TreeSet
    }


}
