import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResponseQuest1P2{
    public static int calculPotions(char ch){
        if(ch == 'A') return 1;
        else if(ch == 'B') return 2;
        else if (ch == 'C') return 4;
        else if (ch == 'D') return 6;
        else return 0;

    }
    public static int nombreDePotions(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int nbPotions = 0;

        int caractere = br.read(); 
        int caractere2 = br.read();

        while (caractere != -1 && caractere2 != -1) {
            char ch = (char) caractere;   
            char ch2 = (char) caractere2; 

            if (ch != 'x' && ch2 != 'x') {
                nbPotions+=calculPotions(ch);
                nbPotions+=calculPotions(ch2);

                
            } 
            else {
                if (ch == 'B' || ch2 == 'B') nbPotions++;
                if (ch == 'C' || ch2 == 'C') nbPotions += 3;
                if (ch == 'D' || ch2 == 'D') nbPotions += 5;

            }

            caractere = br.read();
            caractere2 = br.read();
        }

        br.close(); 
        return nbPotions; 
    }

    public static void main(String[] args) {
        File file = new File("everybody_codes_e2024_q1_p2.txt");
        try {
            System.out.println(nombreDePotions(file)); 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
