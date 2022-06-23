package Lists;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> temperatura = new ArrayList<>();

        int count = 0;
        while(true){
            if(count == 6) break;

            System.out.println("Digite as temperaturas");
            Double temp = sc.nextDouble();
            temperatura.add(temp);
            count++;
        }

        System.out.println("-----------------------");

        // Calculando a média das temperaturas
        double media = temperatura.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0d);

        System.out.printf("Média das temperaturas: %.1f\n", media);

        System.out.println("-----------------------");

        // Temperaturas acima da média
        System.out.println("Temperaturas acima da média: ");
        temperatura.stream()
                .filter(t -> t >media)
                .forEach(t -> System.out.printf("%.1f\n", t));

        System.out.println("-----------------------");

        // Mes das temperaturas acima da média
        System.out.println("Meses das temperaturas acima da média: ");
        Iterator<Double> iterator = temperatura.iterator();

        count = 0;
        while(iterator.hasNext()){
            Double temp = iterator.next();

            if(temp > media){
                switch (count){
                    case (0):
                        System.out.printf("1 - Janeiro: %.1f\n", temp);
                        break;
                    case (1):
                        System.out.printf("2 - Fevereiro: %.1f\n", temp);
                        break;
                    case (2):
                        System.out.printf("3 - Março: %.1f\n", temp);
                        break;
                    case (3):
                        System.out.printf("4 - Abril: %.1f\n", temp);
                        break;
                    case (4):
                        System.out.printf("5 - Maio: %.1f\n", temp);
                        break;
                    case (5):
                        System.out.printf("6 - Junho: %.1f\n", temp);
                        break;
                    default:
                        System.out.println("Nenhuma temperatura acima da média");
                }
            }
            count++;
        }
    }
}
