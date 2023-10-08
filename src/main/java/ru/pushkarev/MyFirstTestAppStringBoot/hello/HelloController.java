package ru.pushkarev.MyFirstTestAppStringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {

    private ArrayList<String> list;

    private HashMap<Integer, String> map;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "element") String element){
        if(list == null){
            list = new ArrayList<>();
            list.add(element);
        } else {
            list.add(element);
        }
    }

    @GetMapping("/show-array")
    public ArrayList<String> updateArrayList(){
        return list;
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "key") Integer key, @RequestParam(value = "element") String element){
        if(map == null){
            map = new HashMap<>();
            map.put(key, element);
        } else {
            map.put(key, element);
        }
    }

    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap(){
        return map;
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght(){
        return "List size: " + list.size() + " Map size: " + map.size();
    }
}
