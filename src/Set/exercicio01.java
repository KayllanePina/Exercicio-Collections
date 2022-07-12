package Set;

/* Crie uma classe LinguagemFavorita qe possua os atributos nome, anoDeCriacao, e ide. Em seguida crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
 * A. Ordem de Inserção
 * B. Ordem Natural (nome)
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

        System.out.println("A. Ordene o conjunto por Ordem de Inserção: ");
        Set<LinguagemFavorita> linguagens = new LinkedHashSet(){{
            add(new LinguagemFavorita("Java", 1991, "Intellij"));
            add(new LinguagemFavorita("Node", 1995, "VisualStudioCode"));
            add(new LinguagemFavorita("Python", 1990, "PyCharm"));
        }};

        for (LinguagemFavorita linguagem : linguagens) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getAnoDeCriacao() + " - " + linguagem.getIDE());
        }

        System.out.println("\nB. Ordene o conjunto por Ordem Natural(nome):");
        Set<LinguagemFavorita> ordemNatural = new TreeSet<>(linguagens);
        for ( LinguagemFavorita ordem : ordemNatural ){
            System.out.println(ordem.getNome() + " - " + ordem.getAnoDeCriacao() + " - " + ordem.getIDE());
        }

        System.out.println("\nC. Ordene o conjunto por Ordem de IDE:");
        Set<LinguagemFavorita> ide = new TreeSet<>(new ComparatorIDE());
        ide.addAll(linguagens);

        for ( LinguagemFavorita ides : ide) {
            System.out.println(ides.getNome() + " - " + ides.getAnoDeCriacao() + " - " + ides.getIDE());
        }

        System.out.println("\nD. Ordene o conjunto por Ordem de Ano e Nome:");
        Set<LinguagemFavorita> anoENome = new TreeSet<>(new ComparatorAnoENome());
        anoENome.addAll(linguagens);

        for ( LinguagemFavorita anoEnome : anoENome) {
            System.out.println(anoEnome.getNome() + " - " + anoEnome.getAnoDeCriacao() + " - " + anoEnome.getIDE());
        }


        System.out.println("\nE. Ordene o conjunto por Ordem de Nome, Ano e IDE:");
        Set<LinguagemFavorita> nomeAnoEide = new TreeSet<>(new ComparatorNomeAnoIde());
        nomeAnoEide.addAll(linguagens);

        for ( LinguagemFavorita nomeAnoEides : nomeAnoEide) {
            System.out.println(nomeAnoEides.getNome() + " - " + nomeAnoEides.getAnoDeCriacao() + " - " + nomeAnoEides.getIDE());
        }
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoDeCriacao;
    private String IDE;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String IDE) {

        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.IDE = IDE;
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

    public String getIDE() {

        return IDE;
    }

    public void setIDE(String IDE) {

        this.IDE = IDE;
    }

    @Override
    public String toString() {

        return "Linguagem Favorita: " +
                "nome = '" + nome + '\'' +
                ", anoDeCriacao = " + anoDeCriacao +
                ", IDE = '" + IDE + '\'';
    }

    @Override
    public int compareTo(LinguagemFavorita o) {

        return this.nome.compareTo(o.nome);
    }
}

class ComparatorNome implements  Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        return nome;
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ide = o1.getIDE().compareTo(o2.getIDE());
        return ide;
    }


}

class ComparatorAnoENome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ano = o1.getAnoDeCriacao().compareTo(o2.getAnoDeCriacao());
        if(ano != 0) return ano;

        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome != 0) return nome;

        int ide = o1.getIDE().compareTo(o2.getIDE());
        return ide;
    }
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome != 0) return nome;

        int ano = o1.getAnoDeCriacao().compareTo(o2.getAnoDeCriacao());
        if(ano != 0) return ano;

        int ide = o1.getIDE().compareTo(o2.getIDE());
        return ide;
    }
}