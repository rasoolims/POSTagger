package Tagger;

/**
 * Created by Mohammad Sadegh Rasooli.
 * User: Mohammad Sadegh Rasooli
 * Date: 5/30/14
 * Time: 9:28 PM
 * To report any bugs or problems contact rasooli@cs.columbia.edu
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import edu.stanford.nlp.io.EncodingPrintWriter;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Tagger {
    /**
     * Stanford Maximum-Entropy Tagger
     */
    private MaxentTagger tagger;

    /**
     * @param modelFile   model file that is built from Stanford tagger
     * As for my default the files are '|'-separated
     */
    public Tagger(String modelFile){
        tagger = new MaxentTagger(modelFile);
    }


    /**
     * Tags a file
     * @param inputfile  should be whitespace tokenized even for punctuations, each sentence in one line
     * @param outputFile  each line consists of whitespace tokenized "word|pos" such as "I|PRO am|V ok|AJ"
     * @throws IOException
     */
    public void tagFile( String inputfile, String outputFile) throws IOException {
        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new FileReader(inputfile)));
        BufferedWriter writer=new BufferedWriter(new FileWriter(new File(outputFile)));


        for (List<HasWord> sentence : sentences) {
            ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
            writer.write(Sentence.listToString(tSentence, false)+"\n");
        }
        writer.flush();
        writer.close();
    }

    /**
     *  Tags a sentence and returns the tagged structure
     * @param sentence
     * @return
     */
    public ArrayList<TaggedWord> tagSentence(List<HasWord> sentence){
        return tagger.tagSentence(sentence);
    }

    /**
     *
     * @param sentence a String whitespace tokenized (even for punctuations); e.g. "I am here ( in NY ) ."
     * @return   A vector of pos tags
     */
    public Vector<String> getTags(String sentence){
        Vector<String> tags=new Vector<String>();

        List<Word> wordList= new ArrayList<Word>();
        for(String word:sentence.split(" ")){
            wordList.add(new Word(word));
        }

        ArrayList<TaggedWord> taggedSentence = tagger.tagSentence(wordList);

        for(TaggedWord taggedWord:taggedSentence)
            tags.add(taggedWord.tag());

        return tags;
    }

}
