import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EncontreAMaiorSubstring {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String entrada1, entrada2, maior, menor; //declare suas variaveis aqui
        while ((entrada1 = in.readLine()) != null) { // complete seu código
            entrada2 = in.readLine();
            if (entrada1.length() > entrada2.length()) {
                maior = entrada1;
                menor = entrada2;
            } else {
                menor = entrada1;
                maior = entrada2;
            }
            int minLength = menor.length();
            int maxS = minLength;
            boolean f = true;
            while (maxS > 0 && f) { //altere as variaveis, se achar necessario
                int diff = minLength - maxS;
                for (int i = 0; i <= diff; i++) { //complete o laco de repeticao
                    if (maior.contains(menor.substring(i, i + maxS))) {
                        f = false;
                        maxS++;
                        break;
                    }
                }
                maxS--;
            }
            System.out.println(maxS);
        }
        out.close();
    }
}
