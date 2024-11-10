import java.io.*;
public class ResponseQuest1P1{
    public static int nombreDePotions(File file)throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int nbPotions = 0;
        int caractere; //entier car la méthode read() retourne le code Unicode correspondant au caractère
        while((caractere = br.read())!=-1){
            char ch = (char) caractere;
            if(ch == 'B') nbPotions++;
            else if (ch == 'C') nbPotions+=3;
        }
        return nbPotions;
    }
    public static void main(String[] args) {
        try{
            File file = new File("everybody_codes_e2024_q1_p1.txt");
            System.out.println(nombreDePotions(file));
        }
        catch(IOException e){
            e.getMessage();
        }
            
    }

}
