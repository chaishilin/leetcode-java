import java.util.*;



class Mtest {
    public static void main(String[] args) {
        Integer result = romanToInt("III");
        System.out.println(result);
    }
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        Integer result = 0;
        Integer index = 0;
        while (true) {
            if (map.get(s.charAt(index)) <= map.get(s.charAt(index + 1))) {
                //如果字符串的当前下标代表的数字大于等于前一位的，说明是正常情况，不涉及4和9
                result += map.get(s.charAt(index));
                index += 1;
            } else {
                //否则是4或9的情况，index前移两位
                result = result + map.get(s.charAt(index)) - map.get(s.charAt(index + 1));
                index += 2;
            }
            if (index >= s.length() - 1) {
                break;
            }
        }
        return result;

    }
}