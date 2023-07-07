package aaa;

import aaa.util.ConnectionTwo;

import java.io.*;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        List<String> list =readFileMethod("text.txt");
        System.out.println(list);
        for(String str : list){
            System.out.println(str.charAt(0));
            String[] strList = str.split(" / ");
            if(str.charAt(0)=='1'){
                try (var open = ConnectionTwo.open();
                     var preparedStatement = open.prepareStatement("insert into jiedovuy.public.commands(name,explanation,technology_id,theme_id) values (?,?,?,?);");) {
                    preparedStatement.setString(1,strList[1]);
                    preparedStatement.setString(2,strList[2]);
                    preparedStatement.setInt(3,1);
                    preparedStatement.setInt(4,Integer.parseInt(strList[3]));
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(str.charAt(0)=='2'){
                try (var open = ConnectionTwo.open();
                     var preparedStatement = open.prepareStatement("insert into jiedovuy.public.themes(name) values (?);");) {
                    preparedStatement.setString(1,strList[1]);
                    System.out.println(strList[1]);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static List<String> readFileMethod(String fileName)  {
        List<String> list = new ArrayList<>();
        var file = new File(fileName);
        try {
//            var fileWriter = new FileWriter(file);
//            fileWriter.write("sadfssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssaf");
//            fileWriter.flush();
            var fileReader = new FileReader(file);
            var bufferedReader = new BufferedReader(fileReader);
            String s ;

            while ((s=bufferedReader.readLine())!=null){

                list.add(s);
            }

            bufferedReader.close();
            fileReader.close();
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
