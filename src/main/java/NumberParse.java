import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Диана on 07.07.2017.
 */
public class NumberParse {
    public static class Number{


        public static int parseToInt(String numeral){
            ArrayList<String> numeralArray = new ArrayList<>();
            int number = 0;

            for(String numeralWord :numeral.split(" ")){
                numeralArray.add(numeralWord);
            }
            int wordCount = numeralArray.size() - 1;

            while(wordCount >= 0 &&
                    !compound_numerals.containsKey(numeralArray.get(wordCount))){

                if(simple_numbers.containsKey(numeralArray.get(wordCount))){
                    number += simple_numbers.get(numeralArray.get(wordCount));
                    System.out.print("simple num " + number+"\n");
                }
                else if(decades.containsKey(numeralArray.get(wordCount))){
                    number += decades.get(numeralArray.get(wordCount));
                    System.out.print("decades " + number+"\n");
                }
                wordCount--;
            }
            while (wordCount > 0){
                int nextSimpleNum = wordCount - 1;
                System.out.println(wordCount+ " " + numeralArray.get(wordCount));
                number +=
                        compound_numerals.get(numeralArray.get(wordCount))
                                *
                                simple_numbers.get(numeralArray.get(nextSimpleNum));
                wordCount-=2;

            }
            System.out.println("number = " + number);
            return number;

        }
        public static Map<String,Integer> simple_numbers = new TreeMap<>();
        public static Map<String,Integer> decades = new TreeMap<>();
        public static Map<String,Integer> compound_numerals = new TreeMap<>();

        static {
            simple_numbers.put("zero",0);
            simple_numbers.put("one",1);
            simple_numbers.put("two",2);
            simple_numbers.put("three",3);
            simple_numbers.put("four",4);
            simple_numbers.put("five",5);
            simple_numbers.put("six",6);
            simple_numbers.put("seven",7);
            simple_numbers.put("eight",8);
            simple_numbers.put("nine",9);
            simple_numbers.put("ten",10);
            simple_numbers.put("eleven",11);
            simple_numbers.put("twelve",12);
            simple_numbers.put("thirteen",13);
            simple_numbers.put("fourteen",14);
            simple_numbers.put("fifteen",15);
            simple_numbers.put("sixteen",16);
            simple_numbers.put("seventeen",16);
            simple_numbers.put("eighteen",16);
            simple_numbers.put("nineteen",16);

            decades.put("twenty",20);
            decades.put("thirty",30);
            decades.put("forty",40);
            decades.put("fifty",50);
            decades.put("sixty",60);
            decades.put("seventy",70);
            decades.put("eighty",80);
            decades.put("ninety",90);

            compound_numerals.put("hundred",100);
            compound_numerals.put("thousand",1000);
            //nine thousand nine hundred ninety nine 9999
        }


    }
}
