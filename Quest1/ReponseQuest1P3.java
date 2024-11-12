import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResponseQuest1P3 {

    public static int intialisePotions(char ch) {
        if (ch == 'A') return 0;
        else if (ch == 'B') return 1;
        else if (ch == 'C') return 3;
        else if (ch == 'D') return 5;
        else return 0;
    }

    public static int nombreDePotions(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int nbPotions = 0;

        int caractere1 = br.read();
        int caractere2 = br.read();
        int caractere3 = br.read();

        while (caractere1 != -1) {
            char ch1 = (char) caractere1;
            char ch2 = 'x'; 
            char ch3 = 'x'; 


            if (caractere2 != -1) {
                ch2 = (char) caractere2;
            }
            if (caractere3 != -1) {
                ch3 = (char) caractere3;
            }

            int groupSize = 0;
            if (ch1 != 'x') groupSize++;
            if (ch2 != 'x') groupSize++;
            if (ch3 != 'x') groupSize++;

            if (groupSize == 1) {
                if (ch1 != 'x') nbPotions += intialisePotions(ch1);
                else if (ch2 != 'x') nbPotions += intialisePotions(ch2);
                else if (ch3 != 'x') nbPotions += intialisePotions(ch3);
            } else if (groupSize == 2) {
                if (ch1 != 'x') nbPotions += intialisePotions(ch1);
                if (ch2 != 'x') nbPotions += intialisePotions(ch2) + 1;
                if (ch3 != 'x') nbPotions += intialisePotions(ch3) + 1;
            } else if (groupSize == 3) {
                nbPotions += intialisePotions(ch1) + 2;
                nbPotions += intialisePotions(ch2) + 2;
                nbPotions += intialisePotions(ch3) + 2;
            }

            caractere1 = br.read();
            caractere2 = br.read();
            caractere3 = br.read();
        }

        br.close(); 
        return nbPotions;
    }


    public static void main(String[] args) {
        File file = new File("Quest1/everybody_codes_e2024_q1_p3.txt");
        try {
            System.out.println("Nombre de potions nécessaires : " + nombreDePotions(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
