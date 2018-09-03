import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

// TODO BASIC POC and experiments of reading file - not related to implementation
public class BasicFunctionalityTest {
	
	private Map<String, Integer> wordMap = new TreeMap<String, Integer>();
	
	
	/*
	 (p1,p2)->{return p1.compareTo(p2)} 
    
	 */
		
	
	public BasicFunctionalityTest() {				
		//readDoc();
		testDocSize();
	}
	
	
	
	
	private void testDocSize() {
		
		String[] tokens = null;

		//File file = new File("..\\..\\FLOOW_DUMP\\funcTest1.txt");
		System.out.println("About to load file..........");
		File file = new File("..\\..\\FLOOW_DUMP\\enwiki-latest-abstract.xml");
		
		long fileSize = file.length();
		
		//File file = new File("..\\..\\FLOOW_DUMP\\example.xml");
		
		String[] lineFest = new String[100000];
		
		try {
			//file.createNewFile();
			
			System.out.println("about to load file input stream....");
			FileInputStream fileInputStream = new FileInputStream("..\\..\\FLOOW_DUMP\\enwiki-latest-abstract.xml");
			System.out.println("completed loading file input stream.....");
			
			
			//long fileSize = fileInputStream.getChannel().size();  ==> result = 5552030394  5552030394
			
			
			System.out.println("FILE_SIZE 2 = " + fileSize);
			
			
			
			fileInputStream.close();
		} catch(IOException e) {
			System.out.println("Bad News");
		}
	}
	
	

	
	
	

	private void readDoc() {
		
		String[] tokens = null;

		//File file = new File("..\\..\\FLOOW_DUMP\\funcTest1.txt");
		System.out.println("About to load file..........");
		File file = new File("..\\..\\FLOOW_DUMP\\enwiki-latest-abstract.xml");
		
		
		
		//File file = new File("..\\..\\FLOOW_DUMP\\example.xml");
		
		String[] lineFest = new String[100000];
		
		try {
			//file.createNewFile();
			
			System.out.println("about to load file input stream....");
			FileInputStream fileInputStream = new FileInputStream("..\\..\\FLOOW_DUMP\\enwiki-latest-abstract.xml");
			System.out.println("completed loading file input stream.....");
			long fileSize = fileInputStream.getChannel().size();
			System.out.println("FILE_SIZE = " + fileSize);
			
			
			FileReader fReader = new FileReader(file);
			BufferedReader bfR = new BufferedReader(fReader);
			
			int count = 0;
			for (String line = bfR.readLine(); line != null; line = bfR.readLine()) {
				
				
				if (count > 99999) {
					break;
				}
				
				System.out.println(line);
				lineFest[count] = line== null ? "" : line;
				count++;						
				
				if (StringUtils.isNotBlank(line.trim())) {
					line = line.replaceAll("\\s+", " ");
					
					// TODO: remove any fragments which start and end with <>
					// TODO: alpha numeric characters only
					// TODO: convert all to lower case?
					line = line.replaceAll("[^'A-Za-z\\s]+", "");

					
					
					// TODO: what about words which stretch over multiple lines
					
					tokens = line.split(" ");
					for (String tok : tokens) {
						int val = wordMap.get(tok) == null ?  1 : wordMap.get(tok) + 1;
						wordMap.put(tok, val);
					}
				}
			}
			
//			System.out.println("Count ed lines: " + count);
//			
			bfR.close();
		} catch(IOException e) {
			System.out.println("Bad News");
		}
		
		Set<String> keySet = wordMap.keySet();
		for (String key : keySet)
		{
		    System.out.println("KEY: " + key + " ==> " + wordMap.get(key));
		}
		
		
		System.out.println("\nList Fest: ------------------------------------->>>>>>>>>>>>>>>>\n");
		for (String l : lineFest) {
			System.out.println(l);
		}
		
		System.out.println("Finished ");
		//showFileSize(file);
	}
	
	
	
	private static void showFileSize(File file) {
		double bytes = file.length();
		double kilobytes = (bytes / 1024);
		double megabytes = (kilobytes / 1024);
		double gigabytes = (megabytes / 1024);
		double terabytes = (gigabytes / 1024);
		double petabytes = (terabytes / 1024);
		double exabytes = (petabytes / 1024);
		double zettabytes = (exabytes / 1024);
		double yottabytes = (zettabytes / 1024);
		
		System.out.println("bytes : " + bytes);
		System.out.println("kilobytes : " + kilobytes);
		System.out.println("megabytes : " + megabytes);
		System.out.println("gigabytes : " + gigabytes);
		System.out.println("terabytes : " + terabytes);
		System.out.println("petabytes : " + petabytes);
		System.out.println("exabytes : " + exabytes);
		System.out.println("zettabytes : " + zettabytes);
		System.out.println("yottabytes : " + yottabytes);
	}
	
	
	
	
	
	public static void main(String[] args) {
		new BasicFunctionalityTest();

//		String propVal = System.getProperty("source");
//		System.out.println("Prop val for source = " + propVal);
//		
//		
//		System.out.println("Welcome to Glossop");
//		for (String arg: args) {
//			System.out.println("--> " + arg);
//		}
		
		
		
		System.out.println();
		
	}
	
	
}
