import java.util.Random;

public class ahorcado {
    public static void main(String[] args) {

        boolean exit = false;
        int errores = 0;
        boolean prueba;
        int aciertos = 0;
        char letra = 0;
        char[] historial;

        menuAhoracado();
        String aleatoria = palabraAleatoria();
        char[] palabra = new char[aleatoria.length()];
        palabra = ocultarPalabra(aleatoria);
        historial = historialLetra();
        do {
            prueba = false;
            String palabraRandom = palabraAleatoria();
            prueba = introduceLetra(palabra, aleatoria, prueba, letra, historial);
            errores = ContarError(prueba, errores);
            aciertos = contarAciertos(prueba, aciertos);
            exit = numError(errores, exit, aciertos);
        } while (!exit);
    }

    private static void menuAhoracado() {
        System.out.println("Bienvenido al ahoracado!");
        System.out.println();
        System.out.println("¿Como se juega?");
        System.out.println("Es bastante basico lo unico que tienes que hacer es adivinar la palabra, poniendo tan solo letras.");
        System.out.println();
        System.out.println("¿Como se gana o pierde?");
        System.out.println("Se gana acertando la palabra y se pierde si no aciertas la palabra y el muñeco se ha completado.");
        System.out.println();
        System.out.println("Normas:");
        System.out.println("El jugador intentara adivinar la palabra diciendo letras con un numero de oportunidades");
        System.out.println();
    }

    private static String palabraAleatoria() {
        String[] palabra = new String[21];
        palabra[0] = "mayormente";
        palabra[1] = "tortilla";
        palabra[2] = "si o que";
        palabra[3] = "españa";
        palabra[4] = "alemania";
        palabra[5] = "asturias";
        palabra[6] = "madrid";
        palabra[7] = "lisboa";
        palabra[8] = "portugal";
        palabra[9] = "gafas de sol";
        palabra[10] = "monitores";
        palabra[11] = "mochilas";
        palabra[12] = "ratones";
        palabra[13] = "tatuajes";
        palabra[14] = "cargador";
        palabra[15] = "concentrado";
        palabra[16] = "mancuernas";
        palabra[17] = "camisa";
        palabra[18] = "soleado";
        palabra[19] = "barra de tareas";
        palabra[20] = "mapa mental";

        Random random = new Random();
        int aleatorio = random.nextInt(palabra.length);

        return palabra[aleatorio];
    }

    private static char[] ocultarPalabra(String aleatoria) {

        int longitud = 0;
        String palabra = aleatoria;

        for (int i = 0; i < palabra.length(); i++) {
            palabra = palabra.replace(palabra.charAt(i), '_');
            longitud++;
        }
        System.out.println("La longitud de la palabra es: " + longitud);
        System.out.println(palabra);
        return palabra.toCharArray();
    }

    private static char[] historialLetra() {

        char[] historial = new char[6];
        historial[0] = '@';
        historial[1] = '@';
        historial[2] = '@';
        historial[3] = '@';
        historial[4] = '@';
        historial[5] = '@';

        return historial;
    }

    private static boolean introduceLetra(char[] palabra, String aleatoria, boolean prueba, char letra, char[] historial) {
        boolean exit = false;
        int numero = 0;
        System.out.println("Escribe una letra: ");
        letra = Teclat.llegirChar();

        do {
            if (historial[numero] == '@' ){
                historial[numero] = letra;
                exit = true;
            } else if (historial[numero] == letra){
                System.out.println("Escribe otra letra diferente: ");
                letra = Teclat.llegirChar();
                numero = 0;
            } else {
                numero++;
            }

        } while (!exit);

        for (int i = 0; i < aleatoria.length(); i++) {
            if (aleatoria.charAt(i) == letra) {
                palabra[i] = letra;
                prueba = true;
            }
        }
        System.out.println(palabra);
        return prueba;
    }

    private static int ContarError(boolean prueba, int errores) {
        if (prueba == false) {
            errores++;
        }
        return errores;
    }

    private static int contarAciertos(boolean prueba, int aciertos) {
        if (prueba == true) {
            aciertos++;
        }
        return aciertos;
    }

    private static boolean numError(int errores, boolean exit, int aciertos) {

        switch (errores) {
            case 0:
                System.out.println("____________");
                System.out.println("|          |");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|______     ");
                break;

            case 1:
                System.out.println("____________");
                System.out.println("|          |");
                System.out.println("|          0");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|______     ");
                break;

            case 2:
                System.out.println("____________");
                System.out.println("|          |");
                System.out.println("|          0");
                System.out.println("|          |");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|______     ");
                break;

            case 3:
                System.out.println("____________");
                System.out.println("|          |");
                System.out.println("|          0");
                System.out.println("|          |-");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|______     ");
                break;

            case 4:
                System.out.println("____________");
                System.out.println("|          |");
                System.out.println("|          0");
                System.out.println("|         -|-");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|______     ");
                break;

            case 5:
                System.out.println("____________");
                System.out.println("|          |");
                System.out.println("|          0");
                System.out.println("|         -|-");
                System.out.println("|           |");
                System.out.println("|           ");
                System.out.println("|______     ");
                break;

            case 6:
                System.out.println("____________");
                System.out.println("|          |");
                System.out.println("|          0");
                System.out.println("|         -|-");
                System.out.println("|         | |");
                System.out.println("|           ");
                System.out.println("|______     ");
                System.out.println("Has perdido");
                exit = true;
                break;
        }

        if (aciertos == palabraAleatoria().length()) {
            exit = true;
        }

        return exit;
    }


}

