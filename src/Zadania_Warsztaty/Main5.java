package Zadania_Warsztaty;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) throws IOException {

        writeToFile();
        filtrFiles();

    }

    private static void filtrFiles() throws IOException {
        String [] wykluczone = {"ponieważ", "gdybyś", "oraz", "chwila", "masz", "wiadomości"};
        File plik = new File("popular_words.txt");
        Scanner skan = new Scanner(plik);

        while(skan.hasNextLine()){
            String [] tmp = skan.nextLine().replaceAll("[,\\.\\?\\!]","").split(" ");
            FileWriter toWrite2 = new FileWriter("filtered_popular_words.txt", true);
            for(int i = 0; i < tmp.length; i++){
                FileWriter toWrite = new FileWriter("filtered_popular_words.txt", true);
                boolean checkIf = true;
                for(int j = 0; j < wykluczone.length; j++){
                    if(tmp[i].equals(wykluczone[j])){
                        checkIf = false;
                    }
                }
                if(checkIf){
                   toWrite.append(tmp[i]+" ");
                   toWrite.close();
                }
            }
            toWrite2.append("\n");
            toWrite2.close();
        }
    }

    private static void writeToFile() {

        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");

            FileWriter file = new FileWriter("popular_words.txt");
            for (Element elem : links) {
                file.append(elem.text()+"\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
