package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for(String el : x){
                if(el.isEmpty() || !Character.isUpperCase(el.charAt(0))){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evens = new ArrayList<>();
            for(Integer a : x){
                if(a % 2 == 0){
                    evens.add(a);
                }
            }
            x.addAll(evens);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return ()->{
            List<String> result = new ArrayList<>();
            for(String el : values){
                if(Character.isUpperCase(el.charAt(0)) && el.endsWith(".") && el.split(" ").length > 3 ){
                    result.add(el);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new HashMap<>();
            for(String s : list){
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2)->{
            var result = new ArrayList<Integer>(list1);
            result.addAll(list2);
            return result;
        };
    }
}
