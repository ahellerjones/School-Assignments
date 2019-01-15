public class GameInfo { 
    
    private final int NUMBER_OF_WORDS = 7;
    private boolean complete;
    private Slice[] slices = new Slice[NUMBER_OF_WORDS]; 
    private WordClue[] cluelist = new WordClue[NUMBER_OF_WORDS]; 
    private String[] wordclues = new String[NUMBER_OF_WORDS];
    
    public GameInfo(String filename) { 
        for(int i = 0; i < NUMBER_OF_WORDS; i++) { 
            this.wordclues[i] 
                = FileUtilities.readLinesFromFile(filename, NUMBER_OF_WORDS)[i];
        }
        
        this.cluelist = getWordClues();
        this.slices = getSlices();   
    }
    
    public Slice[] getSlices() {  
        // sliceCount counts the number of slices that will be made
        // once all words have been sliced for a given game.  
        int sliceCount = 0;
        int slicedIndex = 0;
        Slice[] sliceCounter = new Slice[7];
        for (int i = 0; i < 7; i ++) { 
            sliceCounter = WordUtilities.slice(this.cluelist[i].getWord());
            for (Slice slice : sliceCounter) { 
                sliceCount++;
            }
        }
        // using sliceCount to determine the size of the needed array
        // temp is used to store an array of slices for each 
        // entry in the String array cluelist, which is then transfered to 
        // the master Slice array, sliced, which is returned once
        // all slices are entered.         
        Slice[] sliced = new Slice[sliceCount];
        for (int i = 0; i < 7; i++) {
            Slice[] temp = WordUtilities.slice(cluelist[i].getWord());
            for (int j = 0; j < temp.length; j++) {
                sliced[sliceIndex] = temp[j];
                sliceIndex++;
            }
        }
        return sliced;
    }
    
    public WordClue[] getWordClues() { 
        for (int i = 0; i < NUMBER_OF_WORDS; i++) { 
            cluelist[i] = new WordClue(wordclues[i].substring(0, wordclues[i].indexOf('-')),
                     wordclues[i].substring(wordclues[i].indexOf(
                        '-')+ 1)); 
        // Each String in cluelist is cut up to two Strings determined by 
        // what lies before the hyphen
        // and what lies after the hyphen using indexOf('-'). 
        // These two Strings are then made into a WordClue object.
        }
        return cluelist;
    }
        
    
    public String toString() {
        String bigstring = ("Cluelist\n");
        for(int i = 0; i < cluelist.length; i++) { 
            bigstring += String.format("%s", cluelist[i]);
        }
        bigstring +=("\nSlices\n");
        Slice[] temp2 = getSlices();
        for(int i = 0; i < temp2.length; i++) { 
            bigstring += String.format(
                "%s\n",temp2[i].toString());
        }
        return bigstring;
    }
        
        

    public boolean isComplete() { 
    return slices.length == NUMBER_OF_WORDS
        && cluelist.length == NUMBER_OF_WORDS;
    }
}
              