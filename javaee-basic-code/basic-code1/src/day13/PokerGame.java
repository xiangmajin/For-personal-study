package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {
    //牌盒
    static ArrayList<String> list = new ArrayList<>();
    //牌的价值
    static HashMap<String, Integer>  map = new HashMap<>();
    //准备牌
    static {
        String[] colors = {"♥", "♠", "♦", "♣"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for(String color : colors) {
            for(String number : numbers) {
                list.add(color + number);
            }
        }
        list.add(" 小王");
        list.add(" 大王");
        //指定牌的价值
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("2", 15);
        map.put("小王", 50);
        map.put("大王", 100);


    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);
        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            //发底牌
            if (i <= 2) {
                lord.add(list.get(i));
                continue;
            }
            //发牌
            if (i % 3 == 0) {
                player1.add(list.get(i));
            } else if (i % 3 == 1) {
                player2.add(list.get(i));
            } else if (i % 3 == 2) {
                player3.add(list.get(i));
            }
        }
        //排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);
        //看牌
        System.out.println("底牌：" + lord);
        System.out.println("玩家1：" + player1);
        System.out.println("玩家2：" + player2);
        System.out.println("玩家3：" + player3);
    }
    public void order(ArrayList<String> list) {
        Collections.sort(list,new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String color1 =o1.substring(0,1);
                int value1 = getValue(o1);
                String color2 =o2.substring(0,1);
                int value2 = getValue(o2);
                int i=value1 - value2;
                return i==0?color1.compareTo(color2):i;}
        });
    }
    public int getValue(String card) {
        String number = card.substring(1);
        if(map.containsKey(number)) {
            return map.get(number);
        }else{
            return  Integer.parseInt(number);
        }
    }

}
