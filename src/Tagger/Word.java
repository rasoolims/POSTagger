package Tagger;

import edu.stanford.nlp.ling.HasWord;

/**
 * Created by Mohammad Sadegh Rasooli.
 * User: Mohammad Sadegh Rasooli
 * Date: 5/30/14
 * Time: 9:49 PM
 * To report any bugs or problems contact rasooli@cs.columbia.edu
 */

public class Word implements HasWord {
    private String word;

    public Word(String word){
        setWord(word);
    }

    @Override
    public String word() {
        return word;
    }

    @Override
    public void setWord(String word) {
        this.word=word;
    }
}
