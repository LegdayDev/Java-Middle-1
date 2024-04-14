package lang.wrapper.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGenerator {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> lottoList = new ArrayList<>();
        while (true) {
            int randomNum = random.nextInt(45) + 1; // 1 ~ 45

            if(!lottoList.contains(randomNum)) lottoList.add(randomNum);

            if(lottoList.size()==6) break;
        }
        System.out.println(lottoList);
    }
}
