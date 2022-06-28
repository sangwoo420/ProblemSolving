import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1076_저항 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        map.put("black",0);
        map.put("brown",1);
        map.put("red",2);
        map.put("orange",3);
        map.put("yellow",4);
        map.put("green",5);
        map.put("blue",6);
        map.put("violet",7);
        map.put("grey",8);
        map.put("white",9);
        String s = "";
        s += map.get(input.readLine());
        s += map.get(input.readLine());
        long answer = (long) (Long.parseLong(s) * Math.pow(10, map.get(input.readLine())));
        System.out.println(answer);
    }
}
