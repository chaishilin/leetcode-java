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
                //����ַ����ĵ�ǰ�±��������ִ��ڵ���ǰһλ�ģ�˵����������������漰4��9
                result += map.get(s.charAt(index));
                index += 1;
            } else {
                //������4��9�������indexǰ����λ
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