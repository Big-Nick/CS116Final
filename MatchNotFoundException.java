package folder1.folder2;
public class MatchNotFoundException extends Exception{
	public MatchNotFoundException(){
		super();
	}
	public MatchNotFoundException(String s){
		super(s);
	}
	public String getMessage(){
		return "MatchNotFoundException has occurred.";
	}
	public String toString(){
		return super.toString()+"\n"+"MatchNotFoundException was thrown";
	}
}