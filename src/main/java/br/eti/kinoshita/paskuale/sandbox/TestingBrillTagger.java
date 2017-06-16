package br.eti.kinoshita.paskuale.sandbox;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import hepple.postag.POSTagger;

public class TestingBrillTagger {

    public static void main(String[] args) throws Exception {
        List<String> s1 = Arrays.asList("The classes were tough.".split(" "));
        List<String> s2 = Arrays.asList("The teacher was serious about it.".split(" "));
        List<String> s3 = Arrays.asList("This is not a haiku, so that's it I think.".split(" "));

        @SuppressWarnings("unchecked")
        List<List<String>> sentences = Arrays.asList(s1, s2, s3);
        
        URL lexiconURL = new URL("file:/home/kinow/Development/nlp/GATE_Developer_8.4.1/plugins/ANNIE/resources/heptag/lexicon");
        URL rulesURL = new URL("file:/home/kinow/Development/nlp/GATE_Developer_8.4.1/plugins/ANNIE/resources/heptag/ruleset");
        POSTagger tagger = new POSTagger(lexiconURL, rulesURL);
        
        List<List<String[]>> r = tagger.runTagger(sentences);
        
        for (List<String[]> l : r) {
            for (String[] a : l) {
                for (String s : a) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }
    }
}
