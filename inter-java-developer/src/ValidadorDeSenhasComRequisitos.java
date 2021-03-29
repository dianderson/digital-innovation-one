import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValidadorDeSenhasComRequisitos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //insira sua resolução aqui
        String entrada = st.nextToken();

        while (entrada != null) {
            if (verificar(entrada)) {
                System.out.println("Senha valida.");
            } else {
                System.out.println("Senha invalida.");
            }
            entrada = br.readLine();
        }
    }

    private static boolean verificar(String input) {
        String specialChars = " ~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        char currentCharacter;
        boolean numberPresent = false;
        boolean upperCasePresent = false;
        boolean lowerCasePresent = false;
        boolean specialCharacterNotPresent = true;

        if (input.length() < 6 || input.length() > 32) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            currentCharacter = input.charAt(i);
            if (Character.isDigit(currentCharacter)) {
                numberPresent = true;
            } else if (Character.isUpperCase(currentCharacter)) {
                upperCasePresent = true;
            } else if (Character.isLowerCase(currentCharacter)) {
                lowerCasePresent = true;
            } else if (specialChars.contains(String.valueOf(currentCharacter))) {
                specialCharacterNotPresent = false;
            }
        }
        return numberPresent && upperCasePresent && lowerCasePresent && specialCharacterNotPresent;
    }
}
