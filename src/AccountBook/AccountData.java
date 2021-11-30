package AccountBook;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountData {

    public void makeDataFile() throws IOException {

        String directory = "data\\accountbook.csv";
        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        bw.flush();
        bw.close();

    }

    public void dataWrite(List<String> dataArr) throws IOException {

        String directory = "data\\accountbook.csv";
        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for(int i = 0; i < dataArr.size(); i++){
            bw.write(dataArr.get(i));
            if(i<dataArr.size()-1){
                bw.write(",");
            }
        }
        bw.newLine();

        bw.flush();
        bw.close();

        JOptionPane.showMessageDialog(null,"저장이 완료되었습니다.");
    }

    public List<List<String>> dataRead() throws IOException{

        List<List<String>> arrs = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        List<String> data;
        String line = "";
        String directory = "data\\accountbook.csv";
        ArrayList<String> pi = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));

        while(true){
            line = br.readLine();
            arr.add(line);
            if(line == null) break;
        }

        for(int i = 0; i < arr.size()-1; i++){
            data = Arrays.asList(arr.get(i).split(","));
            arrs.add(data);
        }

        return arrs;
    }

}
