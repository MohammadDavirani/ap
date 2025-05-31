package exercises.ex5;

import java.util.ArrayList;
import java.util.List;

public class Main_EX5 {

    private ArrayList<Integer> counter;
    private ArrayList<String> url;

    public Main_EX5() {
        this.url = new ArrayList<>();
        this.counter = new ArrayList<>();
    }

    public void add(String address){
        for (int i = 0; i < url.size(); i++) {
            if (url.get(i).equalsIgnoreCase(address)) {
                counter.set(i, counter.get(i) + 1);
                return;
            }
        }
        url.add(address);
        counter.add(1);
    }

    public List<String> getTop(int k) {
        List<String> result = new ArrayList<>();
        List<String> urlCopy = new ArrayList<>(url);
        List<Integer> counterCopy = new ArrayList<>(counter);

        while (k > 0 && !counterCopy.isEmpty()) {
            int max = counterCopy.get(0);
            int maxIndex = 0;

            for (int i = 1; i < counterCopy.size(); i++) {
                if (counterCopy.get(i) > max) {
                    max = counterCopy.get(i);
                    maxIndex = i;
                }
            }

            result.add(urlCopy.get(maxIndex) + " => " + counterCopy.get(maxIndex));

            urlCopy.remove(maxIndex);
            counterCopy.remove(maxIndex);

            k--;
        }

        return result;
    }
}