//Encapsulation
public class Range {
	
	int start;
	int end;
	
	public Range(int start, int end){
		if (start > end) throw new IllegalArgumentException();
		this.start = start;
		this.end = end;
	}
	
	public String toString(){
		return ("Range: ["+start+", "+end+"]");
	}
}
