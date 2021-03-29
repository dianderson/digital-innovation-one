import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EntrevistaEmbaracosa {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //insira sua solução aqui

        String prefix, sulfix, palavra = st.nextToken();

        while (palavra != null) {
            int indexMax = 0;
            for (int i = 0; i < palavra.length() / 2; i++) {
                prefix = palavra.substring(0, (palavra.length() + 1) / 2 + i);
                sulfix = palavra.substring(prefix.length(), palavra.length());

                if (prefix.endsWith(sulfix)) {
                    indexMax = prefix.length();
                    System.out.println(palavra.substring(0, indexMax));
                }
            }
            if (indexMax == 0) {
                System.out.println(palavra);
            }
            palavra = br.readLine();
        }
    }
}
