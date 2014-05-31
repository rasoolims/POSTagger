package Test;

import Tagger.Tagger;

import java.io.IOException;
import java.util.Vector;

/**
 * Created by Mohammad Sadegh Rasooli.
 * User: Mohammad Sadegh Rasooli
 * Date: 5/30/14
 * Time: 9:54 PM
 * To report any bugs or problems contact rasooli@cs.columbia.edu
 */

public class TaggerTest {
    public static void main(String[] args) throws IOException {
        // Just for IDE test
        String modelFile="/Users/msr/Projects/PersianPOSTagger/src/Test/persian.model";
        String inputFile="/Users/msr/Projects/PersianPOSTagger/src/Test/persiantest.tmp";
        String outputFile="/Users/msr/Projects/PersianPOSTagger/src/Test/output.tmp";


        if(args.length>2){
            modelFile=args[0];
            inputFile=args[1];
            outputFile=args[2];
        }

        Tagger tagger=new Tagger(modelFile);
        tagger.tagFile(inputFile,outputFile);

        String sentence="هوا خوب می‌شود".trim();
        Vector<String> tags=tagger.getTags(sentence);
        for (String tag: tags)
            System.out.println(tag);
    }
}
