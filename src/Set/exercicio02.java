package Set;

/* Crie um conjunto contendo as cores do arco-íris e:
 * A. Exiba todas as cores do uma abaixo da outra
 * B. A quantidade de cores que o arco-íris tem
 * C. Exiba as cores em ordem alfabética
 * D. Exiba as cores na ordem inversa da que foi informada
 * E. Exiba todas as cores que começam com a letra "v"
 * F. Remova todas as cores que não começam com a letra "v"
 * G. Limpe o conjunto
 * H. Confira se o conjunto está vazio*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class exercicio02 {

    public static void main(String[] args) {

        System.out.println("A. Exiba todas as cores do uma abaixo da outra: ");
        Set<String> coresDoArcoIris = new LinkedHashSet(){{
            add("Vermelho");
            add("Laranja");
            add("Amarelo");
            add("Verde");
            add("Azul");
            add("Anil");
            add("Violeta");
        }};

        for (String cores : coresDoArcoIris) {
            System.out.println(cores);
        }

        System.out.println("\nB. A quantidade de cores que o arco-íris tem: ");
        System.out.println(coresDoArcoIris.size());

        System.out.println("\nC. Exiba as cores em ordem alfabética:");
        Set<String> ordemAlfabetica = new TreeSet<>(coresDoArcoIris);
        for (String ordem : ordemAlfabetica) {
            System.out.println(ordem);
        }

        System.out.println("\nD. Exiba as cores na ordem inversa da que foi informada:");
        List<String> ordemInverso = new ArrayList<>(coresDoArcoIris);
        Collections.reverse(ordemInverso);

        for (String inverso : ordemInverso) {
            System.out.println(inverso);
        }

        System.out.println("\nE. Exiba todas as cores que começam com a letra \"v\"");
        for (String letraV : coresDoArcoIris) {
            if (letraV.startsWith("V")) System.out.println(letraV);
        }

        System.out.println("\nF. Remova todas as cores que não começam com a letra \"v\"");
        coresDoArcoIris.removeIf(o -> o.startsWith("V"));
        System.out.println(coresDoArcoIris);

        System.out.println("\nG. Limpe o conjunto");
        coresDoArcoIris.clear();
        System.out.println(coresDoArcoIris);

        System.out.println("\nH. Confira se o conjunto está vazio");
        System.out.println(coresDoArcoIris.isEmpty());

    }
}