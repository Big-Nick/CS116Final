package folder1.folder2;
import folder1.folder2.*;
import java.util.*;
import java.io.*;
public class Dealershipser implements serializable{
	public void createDealershipsSer(Dealership[] dealers){
		try{
			System.out.println("Creating the file dealers.ser");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("dealers.ser")));
			for(int i = 0; i<5;i++){
				oos.writeObject( dealers[i] );
			}
			oos.close();
		}catch(IOException ioe)
		{
			System.out.println("Error with file");
		}
	}
	public ArrayList<Dealership> readDealershipsSer(){
		ObjectInputStream ois=null;
		ArrayList<Dealership> dealers = new ArrayList<Dealership>();
		System.out.println("Reading dealers.ser");
		try{
			ois = new ObjectInputStream(new FileInputStream(new File("dealers.ser")));
			while(true){
				Dealership dealer = (Dealership)ois.readObject();
				dealers.add(dealer);
			}
		} catch (EOFException ignored) {
		} catch(IOException ioe){
			System.out.println(ioe);
		} catch(ClassNotFoundException cnfe){
			System.out.println(cnfe);
		} 
		return dealers;
	}
}