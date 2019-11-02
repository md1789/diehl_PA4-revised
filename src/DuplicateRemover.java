import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateRemover {
    static ArrayList<String> uniqueWords = new ArrayList<String>();
    // the idea behind this is I'm going to add each string to an arraylist by first comparing what is in the list
    // if the list contains the current string, I don't want to add it
    // in other words, I'm only adding the string if the list does not contain it
    public void remove(String dataFile) {
        //BufferedReader br = null;
        String str;
        int i = 0;
        int count = 0;
        // i have to reset it for each line so that it only considers duplicates per line
        //int count = 0;
        try {
            FileReader reader = new FileReader(dataFile);
            Scanner scnr = new Scanner(reader);
            while (scnr.hasNext()) {
                str = scnr.next();
                count++;
                //System.out.println(str);
                if (!(uniqueWords.contains(str))) {
                    if (Character.isUpperCase(str.charAt(0)) && (count > 1)) {
                        uniqueWords.add("\n");
                        uniqueWords.add(str);
                        uniqueWords.add(" ");
                    }
                    else {
                        uniqueWords.add(str);
                        uniqueWords.add(" ");
                    }
                }
                else {
                    continue;
                }

            }
            /*for (int j = 0; j < uniqueWords.size(); j++){
                System.out.println(uniqueWords.get(j));
            }*/
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
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < uniqueWords.size(); i++){
                writer.write(uniqueWords.get(i));
            }
            //writer.flush();
            writer.close();
        }
        catch (IOException ex) {
            System.out.printf("Error: cannot write to file %s", ex);
            return;
        }
    }
}
