package folder1.folder2;
import folder1.folder2.*;
import java.util.*;
import java.io.*;
public class ImplDealership extends Dealershipser implements IntDealership
{
	public void createFile(Dealership[] dealers){
		Dealershipser temp = new Dealershipser();
		temp.createDealershipsSer(dealers);
	}
	public ArrayList<Dealership> readFile(){
		Dealershipser temp = new Dealershipser();
		ArrayList<Dealership> dealers = new ArrayList<Dealership>();
		dealers.addAll(temp.readDealershipsSer());
		return dealers;
	}
}
