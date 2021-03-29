import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AbreviandoPostsDoBlog {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //insira sua solução aqui

        ArrayList<String> frase = new ArrayList<>();
        while (st.hasMoreTokens()) {
            frase.add(st.nextToken());
        }

        while (!frase.get(0).equals(".")) {
            processar(frase);
            frase.clear();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                frase.add(st.nextToken());
            }
        }
    }

    public static void processar(ArrayList<String> frase) {
        StringBuilder fraseAbreviada = new StringBuilder();
        Map<String, Integer> palavrasSubstituir = new HashMap<>();
        Map<Character, Object[]> iniciaisUsadas = new TreeMap<>();
        for (String palavra : frase) {
            if (palavra.length() > 2 && !palavrasSubstituir.containsKey(palavra)) {
                palavrasSubstituir.put(palavra, palavra.length() - 2);
            } else if (palavra.length() > 2) {
                palavrasSubstituir.put(palavra, palavrasSubstituir.get(palavra) + palavra.length() - 2);
            }
        }

        if (palavrasSubstituir.isEmpty()) {
            return;
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
            if (iniciaisUsadas.containsKey(palavra.charAt(0)) && palavra.equals(iniciaisUsadas.get(palavra.charAt(0))[1])) {
                fraseAbreviada.append(palavra.charAt(0)).append(".").append(" ");
            } else {
                fraseAbreviada.append(palavra).append(" ");
            }
        }

        System.out.println(fraseAbreviada);
        System.out.println(iniciaisUsadas.size());

        for (Character j : iniciaisUsadas.keySet()) {
            System.out.println(j + ". = " + iniciaisUsadas.get(j)[1]);
        }
    }
}
