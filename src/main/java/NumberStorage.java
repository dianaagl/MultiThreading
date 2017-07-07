import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Диана on 07.07.2017.
 */
public class NumberStorage {
    NumberStorage(){

    }
    Map<Integer,String> numbers = new TreeMap<>();
    public void addNumber(String number){
        int intNum = NumberParse.Number.parseToInt(number);

        numbers.put(intNum,number);
        System.out.print("add "+ intNum);
    }
    public String removeNumber(){
        Integer smallestNumber= (Integer) numbers.keySet().toArray()[0];
        int intNum = NumberParse.Number.parseToInt(numbers.get(smallestNumber));
        String smallestNumStr = numbers.get(intNum);
        numbers.remove(intNum);
        return smallestNumStr;
    }
}
