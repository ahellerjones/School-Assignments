public class Slice { 
    private boolean used;
    private String text;
    
    
    public Slice(String text) { 
        this.text = text;
    }
    
    
    public  boolean isUsed() { 
    return this.used;
    }
    
    public void reset() { 
    this.used = false;
    }
    
    public String toString() { 
        if (!used) { 
            return this.text;
        } else { 
            return "";
        }
    }
    public void use() { 
        this.used = true;
    }
}