import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class AbreviandoPostsDoBlog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //insira sua solução aqui

        StringBuilder fraseAbreviada = new StringBuilder();
        ArrayList<String> frase = new ArrayList<>();
        Map<String, Integer> palavrasSubstituir = new HashMap<>();
        Map<Character, Object[]> iniciaisUsadas = new HashMap<>();
        int numAbreviacoes = 0;

        while (st.hasMoreTokens()) {
            frase.add(st.nextToken());
        }
        for (String palavra : frase) {
            if (!palavrasSubstituir.containsKey(palavra)) {
                palavrasSubstituir.put(palavra, palavra.length() - 2);
            } else {
                palavrasSubstituir.put(palavra, palavrasSubstituir.get(palavra) + palavra.length() - 2);
            }
        }

        for (String palavra : palavrasSubstituir.keySet()) {
            Character inicialAtual = palavra.charAt(0);
            Integer economiaAtual = palavrasSubstituir.get(palavra);

            if (!iniciaisUsadas.containsKey(inicialAtual)) {
                iniciaisUsadas.put(inicialAtual, new Object[]{economiaAtual, palavra});
            } else {
                Integer economiaRegistrada = (Integer) iniciaisUsadas.get(inicialAtual)[0];
                if (economiaAtual > economiaRegistrada) {
                    iniciaisUsadas.put(inicialAtual, new Object[]{economiaAtual, palavra});
                }
            }
        }

        for (String palavra : frase) {
            if (palavra == iniciaisUsadas.get(palavra.charAt(0))[1]) {
                numAbreviacoes++;
                fraseAbreviada.append(palavra.charAt(0)).append(".").append(" ");
            } else {
                fraseAbreviada.append(palavra).append(" ");
            }
        }

        System.out.println(fraseAbreviada);
        System.out.println(numAbreviacoes);

        for (Character j : iniciaisUsadas.keySet()) {
            System.out.println(j + ". = " + iniciaisUsadas.get(j)[1]);
        }
    }
}
