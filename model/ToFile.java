package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class ToFile implements Persistable {

	@Override
	public void save(HashMap<String, Product> productList) {
		File f = new File("shop.txt");
	    FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
		    PrintWriter pw = new PrintWriter(fos);
		    for (Product product : productList.values()){
				pw.write(product.getProductId() + "," + product.getProductTitle() +"," + product.getProductType() + ",");
			}
	        pw.flush();
	        fos.close();
	        pw.close();
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(HashMap<String, Product> productList) {
		try {
			String id="", type="", title ="";
			
			Scanner in = new Scanner(new FileReader("shop.txt"));
			int i,j;
			while(in.hasNext()){
				String line = in.nextLine();
				for(i = 1; i < line.length(); i++){
					if(line.substring(i-1, i).equals(",")){
						id = line.substring(0,i-1);
						
					}
				}
					for(j = i; j <line.length();j++){
						if(line.substring(j-1,j).equals(",")){
							title = line.substring(i,j-1);
							break;
						}
					}
					type = line.substring(j,line.length());
				
				
					//TODO change to product type
					productList.put(id, new CD(title, id, type));
				}		
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
