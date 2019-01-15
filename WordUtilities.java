public class WordUtilities { 

    public static Slice[] slice(String word) {
        word = word.toUpperCase(); 
        if (word.length() % 3 == 0) { 
            Slice[] slice = new Slice[
            word.length() / 3];
            for (int i = 0; i < slice.length; i++) { 
                slice[i] = new Slice(word.substring(3 * i , (3 * i) + 3));
            }
            return slice;
        } else if (word.length() % 2 == 0) {
            Slice[] slice = new Slice[
                word.length() / 2];
            for (int i = 0; i < slice.length; i++) { 
                slice[i] = new Slice(
                    word.substring(2 * i , (2 * i) + 2));
            }
        return slice;
        } else {
            Slice[] slice = new Slice[(word.length() / 2)];
            slice[0] = new Slice(word.substring(0, 3));
            
            for (int i = 1; i < slice.length; i++) { 
                slice[i] = new Slice(word.substring((2 * i) + 1, (2 * i) + 3));
            }
            return slice;
        
        }
        
    }
}