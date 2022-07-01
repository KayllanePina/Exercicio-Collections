package Set;

/* Crie uma classe LinguagemFavorita qe possua os atributos nome, anoDeCriacao, e ide. Em seguida crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
 * A. Ordem de Inserção
 * B. Ordem Natural
 * C. IDE
 * D. Ano de criação e nome
 * E. Nome, ano de criação e IDE
 * No final, exiva as linguagens no console, um abaixo do outro
 * */

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class exercicio01 {
    public static void main(String[] args) {
        System.out.println("A. Ordem de Inserção");
        Set<LinguagemFavorita> linguagemFavorita = new LinkedHashSet(){{
            add(new LinguagemFavorita("Java", 1991, "Intellij"));
            add(new LinguagemFavorita("C", 1972, "JetBrains"));
            add(new LinguagemFavorita("Python", 1990, "PyCharm"));
        }};
        for (LinguagemFavorita linguagens : linguagemFavorita) {
            System.out.println(linguagens.getNome() + " - " + linguagens.getAnoDeCriacao() + " - " + linguagens.getIde());
        }

        System.out.println("\nB. Ordem Natural");

        System.out.println("\nC. IDE");
        Set<LinguagemFavorita> ides = new TreeSet<>(new ComparatorIDE());
        ides.addAll(linguagemFavorita);
        for (LinguagemFavorita ide : ides) {
            System.out.println(ide.getNome() + " - " + ide.getAnoDeCriacao() + " - " + ide.getIde());
        }

        System.out.println("\nD. Ano e criação e nome");
        Set<LinguagemFavorita> anoDeCriacaoENome = new TreeSet<>(new ComparatorAnoDeCriacaoENome());
        anoDeCriacaoENome.addAll(linguagemFavorita);
        for (LinguagemFavorita anoEcriacao : anoDeCriacaoENome) {
            System.out.println(anoEcriacao.getNome() + " - " + anoEcriacao.getAnoDeCriacao() + " - " + anoEcriacao.getIde());
        }


        System.out.println("\nE. Nome, ano de criação e IDE");
        Set<LinguagemFavorita> nomeAnoIde = new TreeSet<>(new ComparatorNomeAnoIde());
        nomeAnoIde.addAll(linguagemFavorita);
        for (LinguagemFavorita nomeAnoIdes : nomeAnoIde) {
            System.out.println(nomeAnoIdes.getNome() + " - " + nomeAnoIdes.getAnoDeCriacao() + " - " + nomeAnoIdes.getIde());
        }
    }
}

class LinguagemFavorita implements  Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'';
    }

    @Override
    public int compareTo(LinguagemFavorita o) {
        return 0;
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ide = o1.getIde().compareTo(o2.getIde());
        return ide;
    }
}

class ComparatorAnoDeCriacaoENome implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int anoDeCriacao = o1.getAnoDeCriacao().compareTo(o2.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;

        int nome = o1.getNome().compareTo(o2.getNome());
        return nome;
    }
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome != 0) return nome;

        int anoDeCriacao = o1.getAnoDeCriacao().compareTo(o2.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;

        int ide = o1.getIde().compareTo(o2.getIde());
        return ide;
    }
}