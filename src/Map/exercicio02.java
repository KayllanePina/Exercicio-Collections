package Map;

/*
--- Desafio ---
        Faça um programa que simule um lançamento de dados.
        Lance o dado 100 vezes e armazene.
        Depois, mostre quantas vezes cada valor foi inserido
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class exercicio02 {
    public static void main(String[] args) {
        int qtdLancamentos = 100;

        List<Integer> valores = new ArrayList<>();
        Random geradorLancamento = new Random();

        for (int i = 0; i < qtdLancamentos; i++){
            int number = geradorLancamento.nextInt(6) + 1;
            valores.add(number);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores) {
            if (lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            else lancamentos.put(resultado, 1);
        }

        System.out.println("Jogando");
        for (int i = 0; i < 3; i++){
            try {
                Thread.sleep(3000);
                System.out.println(".");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("\n Valor " + " Quantidade de vezes");
        for (Map.Entry<Integer, Integer> entry: lancamentos.entrySet()){
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }
    }
}


