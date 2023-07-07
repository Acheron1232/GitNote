package aaa;

import aaa.entity.CommandEntity;
import aaa.entity.ThemeEntity;
import aaa.util.ConnectionTwo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.*;

@Controller
public class ExampleController {
    private Map<String, String> map;
    private List<String> list = new ArrayList<>(List.of("asdsa", "sadasda", "sadasd", "sdasd"));

    @GetMapping("/")
    public String homePage(Model model) {
//        System.out.println("ONE!!!");

        try (var open = ConnectionTwo.open(); var preparedStatement = open.createStatement();
             var statement = open.createStatement();) {

            var resultSet1 = statement.executeQuery("select themes.id, themes.name from jiedovuy.public.themes inner join commands c on themes.id = c.theme_id where c.technology_id =1;");

            Map<String, List<CommandEntity>> map = new HashMap<>();

            while (resultSet1.next()) {
                Integer intg = resultSet1.getInt(1);
                String str21 = resultSet1.getString(2);
                List<CommandEntity> list = new ArrayList<>();
                var resultSet = preparedStatement.executeQuery("select name, explanation ,technology_id , theme_id from jiedovuy.public.commands where technology_id = 1;");
                while (resultSet.next()) {
                    String str = resultSet.getString(1);
                    String str1 = resultSet.getString(2);
                    Integer str2 = resultSet.getInt(3);
                    Integer str3 = resultSet.getInt(4);

                    if (str3.equals(intg)) {
                        var commandEntity = new CommandEntity(str, str1, str2, str3);
                        list.add(commandEntity);
                    }
                }
                map.put(str21, list);
            }

            model.addAttribute("themes", map);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return "index";


    }

    @GetMapping("/github")
    public String hubPage(Model model) {
        try (var open = ConnectionTwo.open(); var preparedStatement = open.createStatement();
             var statement = open.createStatement();) {

            var resultSet1 = statement.executeQuery("select themes.id, themes.name from jiedovuy.public.themes inner join commands c on themes.id = c.theme_id where c.technology_id =2 ;");

            Map<String, List<CommandEntity>> map = new HashMap<>();

            while (resultSet1.next()) {
                Integer intg = resultSet1.getInt(1);
                String str21 = resultSet1.getString(2);
                List<CommandEntity> list = new ArrayList<>();
                var resultSet = preparedStatement.executeQuery("select name, explanation ,technology_id , theme_id from jiedovuy.public.commands where technology_id = 2;");
                while (resultSet.next()) {
                    String str = resultSet.getString(1);
                    String str1 = resultSet.getString(2);
                    Integer str2 = resultSet.getInt(3);
                    Integer str3 = resultSet.getInt(4);

                    if (str3.equals(intg)) {
                        var commandEntity = new CommandEntity(str, str1, str2, str3);
                        list.add(commandEntity);
                    }
                }
                map.put(str21, list);
            }

            model.addAttribute("themes", map);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return "hub";
    }

    @GetMapping("/tests")
    public String testsPage(Model model) {
        try (var open = ConnectionTwo.open();
             var statement = open.createStatement();
        ) {
            var resultSet = statement.executeQuery("select name ,explanation from public.commands  ORDER BY RANDOM() limit 4;");
            map = new HashMap<>();
            int y = 0;
            while (resultSet.next()) {
                if (y == 4) break;
                String s1 = resultSet.getString(2);
                String s2 = resultSet.getString(1);
                list.set(y, s2);
                map.put(s1, s2);
                model.addAttribute("test%d".formatted(y), s1);
                y++;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "test";
    }

    @PostMapping("/result")
    public String resultPage(@RequestParam("text1") String text1, @RequestParam("text2") String text2,
                             @RequestParam("text3") String text3, @RequestParam("text4") String text4,
                             Model model) {
        int y = 0;
        if (text1.trim().equals(list.get(0))) y++;
        if (text2.trim().equals(list.get(1))) y++;
        if (text3.trim().equals(list.get(2))) y++;
        if (text4.trim().equals(list.get(3))) y++;
//        System.out.println(y);

        model.addAttribute("message", y);
        return "result";
    }

    @GetMapping("/credits")
    public String creditPage(Model model) {
        return "credits";
    }
}
