package AccountBook;

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

public class UserData {

    public void makeLoginFile() throws IOException {

        String directory = "data\\register.csv";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        bw.flush();
        bw.close();

    }

    public void loginWrite(List<String> loginArr) throws IOException {

        String directory = "data\\register.csv";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for(int i = 0; i < loginArr.size(); i++){
            bw.write(loginArr.get(i));
            if(i<loginArr.size()-1){
                bw.write(",");
            }
        }
        bw.newLine();

        bw.flush();
        bw.close();

    }

    public java.util.List<java.util.List<String>> loginRead() throws IOException {

        java.util.List<java.util.List<String>> arrs = new ArrayList<>();
        java.util.List<String> arr = new ArrayList<>();
        List<String> personal;
        String directory = "data\\register.csv";
        ArrayList<String> pi = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));

        while(true){
            String line = br.readLine();
            arr.add(line);
            if(line == null) break;
        }

        for(int i = 0; i < arr.size()-1; i++){
            personal = Arrays.asList(arr.get(i).split(","));
            arrs.add(personal);
        }


        return arrs;
    }
}
