import java.io.*;
import java.util.*;
public class DuplicateCounter {
    static HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
    public void count (String dataFile) {
        String line;
        int count = 0;
        try {
            FileReader reader = new FileReader(dataFile);
            Scanner scnr = new Scanner(reader);
            while (scnr.hasNext()) {
                line = scnr.next();
                if (wordCounter.containsKey(line)) {
                    count = wordCounter.get(line);
                    wordCounter.put(line, ++count);
                }
                else {
                    wordCounter.put(line, 1);
                }
            }
            reader.close();
        }
        catch (IOException ex) {
            System.out.printf("Error: cannot open %s", ex);
            return;
        }
    }

    public void write (String outputFile) {
        File file = new File(outputFile);

        try {
            FileWriter writer = new FileWriter(outputFile);
            for(Map.Entry<String,Integer> m :wordCounter.entrySet()){
                writer.write(m.getKey()+" = "+ m.getValue() + " ");
            }
            writer.flush();
            writer.close();
        }
        catch (IOException ex) {
            System.out.printf("Error: cannot write to file %s", ex);
            return;
        }
    }
}
