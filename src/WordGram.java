/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Sachin Jaishankar
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		System.arraycopy(source, start, myWords, 0, size);
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram p = (WordGram) o;
		for(int i = 0; i < myWords.length; i++) {
			if(!myWords[i].equals(p.myWords[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode(){
		if(myHash == 0) {
			myHash = toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		for(int i = 0; i < wg.myWords.length - 1; i++) {
			wg.myWords[i] = wg.myWords[i+1];
		}
		wg.myWords[wg.myWords.length-1] = last;
		return wg;
	}

	@Override
	public String toString(){
		myToString = String.join(" ", myWords);	
		return myToString;
	}
}
