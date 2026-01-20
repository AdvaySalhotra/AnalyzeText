public class Word {

    private int count;
    private String word;


    public Word(String word) {
        this.count = 1;
        this.word = word;

    }

    public int getCount() {
        return count;
    }
    public void updateCount() {
        this.count ++;
    }


    public String getWord() {
        return word;
    }

}

