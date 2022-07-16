package Map;

/*Dada a população estimada de alguns estados do NE brasileiro, faça:
Estado = PE - População = 9.616.621
Estado = AL - População = 3.351.543
Estado = CE - População = 9.187.103
Estado = RN - População = 3.534.265

- Crie um dicionário e relacione os estados e suas populações
- Substitua a populaçao do estado do RN por 3.534.165
- Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277
- Exiba a população do PE
- Exiba todos os estados e suas populações na ordem que foi informado
- Exiba os estados e suas populações em ordem alfabética
- Exiba o estado com o menor população e sua quantidade
- Exiba o estado com a maior população e sua quantidade
- Exiba a soma da população desses estados
- Exiba a média da populção deste dicionário de estados
- Remova os estados com a população menor que 4.000.000
- Apague o dicionário de estados
- Confira se o dicionário está vazio
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class exercicio01 {

    public static void main(String[] args) {

        System.out.println("A. Crie um dicionário e relacione os estados e suas populações:");
        Map<String, Integer> estados = new HashMap(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estados);

        System.out.println("\nB. Substitua a populaçao do estado do RN por 3.534.165:");
        estados.put("RN", 3534165);
        System.out.println(estados);

        System.out.println("\nC. Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277:");

        if (estados.containsKey("PB")) {
            System.out.println(estados.containsKey("PB"));
        } else {
            estados.put("PB", 4039277);
        }

        System.out.println(estados);

        System.out.println("\nD. Exiba a população do PE:");
        System.out.println(estados.get("PE"));

        System.out.println("\nE. Exiba todos os estados e suas populações na ordem que foi informado:");
        Map<String, Integer> estados2 = new LinkedHashMap(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estados2);

        System.out.println("\nF. Exiba os estados e suas populações em ordem alfabética:");
        Map<String, Integer> estados3 = new TreeMap(estados);
        System.out.println(estados3);

        System.out.println("\nG. Exiba o estado com o menor população e sua quantidade:");
        Integer populacao = Collections.min(estados.values());

        Set<Entry<String, Integer>> entries = estados.entrySet();

        String menorPopulacao = "";

        for (Entry<String, Integer> entry : entries) {
            if (entry.getValue().equals(populacao)){
                menorPopulacao = entry.getKey();
            }
        }

        System.out.println(menorPopulacao + " - " + populacao);

        System.out.println("\nH. Exiba o estado com a maior população e sua quantidade:");
        Integer populacao2 = Collections.max(estados.values());

        Set<Entry<String, Integer>> entries2 = estados.entrySet();

        String menorPopulacao2 = "";

        for (Entry<String, Integer> entry2 : entries2) {
            if (entry2.getValue().equals(populacao2)){
                menorPopulacao2 = entry2.getKey();
            }
        }

        System.out.println(menorPopulacao2 + " - " + populacao2);

        System.out.println("\nI. Exiba a soma da população desses estados:");
        Iterator<Integer> iterator = estados.values().iterator();

        Integer somaEstados = 0;

        while (iterator.hasNext()) {
            somaEstados += iterator.next();
        }
        System.out.println(somaEstados);

        System.out.println("\nJ. Exiba a média da populção deste dicionário de estados:");
        System.out.println(somaEstados / estados.size());

        System.out.println("\nK. Remova os estados com a população menor que 4.000.000:");
        Iterator<Integer> iterator2 = estados.values().iterator();

        while (iterator2.hasNext()){
            if (iterator2.next() < 4000000) iterator2.remove();
        }
        System.out.println(estados);

        System.out.println("\nL. Apague o dicionário de estados:");
        estados.clear();
        System.out.println(estados);

        System.out.println("\nM. Confira se o dicionário está vazio:");
        System.out.println(estados.isEmpty());

    }
}