import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Utopias
{

    private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private static final int[] coins = {1, 7, 10, 22};

    public static ArrayList<Integer> utopia(int n){

        // Base case
        for (int i : coins) if ( n == i) return new ArrayList<>(Collections.singletonList(n));

        if (map.get(n) != null){
            return map.get(n);
        }

        int min = Integer.MAX_VALUE;
        int coin = 0;
        ArrayList<Integer> minArray = new ArrayList<>();

        for (int i : coins) {
            if (n > i){
                ArrayList<Integer> temp = utopia(n - i);
                if(temp.size() < min) {
                    min = temp.size();
                    minArray = temp;
                    coin = i;
                }
            }
        }
        minArray.add(coin);
        map.put(n, minArray);
        return minArray;
    }
}
