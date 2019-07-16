package folder1.folder2;
public class RepeatNumberException extends Exception{
	public RepeatNumberException(){
		super();
	}
	public RepeatNumberException(String s){
		super(s);
	}
	public String getMessage(){
		return "RepeatNumberException has occurred.";
	}
	public String toString(){
		return super.toString()+"\n"+"RepeatNumberException was thrown";
	}
}