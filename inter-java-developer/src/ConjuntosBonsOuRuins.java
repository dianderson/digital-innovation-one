import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ConjuntosBonsOuRuins {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //insira sua solução aqui
        ArrayList<String> grupo = new ArrayList<>();
        String entrada = st.nextToken();

        while (!entrada.equals("0")) {
            try {
                Integer.parseInt(entrada);
                if (!grupo.isEmpty()) {
                    searchPrefix(grupo);
                    grupo.clear();
                }
            } catch (Exception ex) {
                grupo.add(entrada);
            }
            entrada = br.readLine();
        }
        searchPrefix(grupo);
    }

    public static void searchPrefix(ArrayList<String> grupo) {
        int i = 0;
        for (String prefix : grupo) {
            for (String palavra : grupo) {
                if (palavra.indexOf(prefix) == 0) {
                    i++;
                }
            }
            if (i > 1) {
                System.out.println("Conjunto Ruim");
                return;
            }
            i = 0;
        }
        System.out.println("Conjunto Bom");
    }
}
