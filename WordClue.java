public class WordClue {
    
    private final int MIN_WORD_LENGTH = 4;
    private final int MAX_CLUE_LENGTH = 40;
    
    private String word;
    private String clue;
    private Slice[] slices; 
    
    
    public WordClue(String word, String clue) { 
        if (word == null || word.length() < MIN_WORD_LENGTH) {
            
            this.word = "DEFAULT";
        } else { 
            this.word = word;
        }
        if (clue == null
            || clue.length() > MAX_CLUE_LENGTH || clue.length() == 0) {
            this.clue = "DEFAULT CLUE";
        } else {
            this.clue = clue;
        }
        this.slices = WordUtilities.slice(this.word);
        
            
    }
    
    public boolean equals(WordClue other) { 
        for(int i = 0; i < slices.length; i++){
            if(!this.slices[i].toString().equals(other.getSlices()[i].toString())) { 
                return false; //this doesn't seem to work in auto and not sure why. 
            }
        }
        if (this.word.equals(other.getWord()) 
            && this.clue.equals(other.getClue())) { 
            
            return true   ;
        }
        return false;
    }
    
    public String getClue() { 
        return this.clue;
    }
    
    public String getFirstLetterHint() { 
        return String.format("%c",this.word.charAt(0)).toUpperCase();
    }
    
    public Slice getFirstSliceHint() { 
        return slices[0];
        
    }
    
    public Slice[] getSlices() { 
        return this.slices;
    }
    
    public String getWholeWordHint() { 
    return this.word.toUpperCase();
    }
    
    public String getWord() { 
        return this.word; 
    }
    public String toString(boolean verbose) { 
        if(!verbose) {
            return String.format(
                "%s-%s\n", this.word, this.clue);
        } else { 
            String theString = String.format(
                "%s-%s\n", this.word, this.clue);
            Slice[] slice = WordUtilities.slice(this.word);
            for (int i = 0; i < slice.length - 1; i++) { 
                theString += String.format("%s ", slice[i].toString());
            }
            theString += slice[slice.length - 1].toString();
            return theString + "\n";
        }   
    }
    public String toString() { 
        return toString(false);    
    }
}
