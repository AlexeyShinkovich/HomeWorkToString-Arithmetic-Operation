package by.htp.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class InPutOutPut {
	StringBuilder buff = new StringBuilder();
	String s=null;
	
	public void inPutOutPut() {
	
	try (FileOutputStream outFile = new FileOutputStream("E:\\learn\\PVT\\log.txt");
			PrintStream out = new PrintStream(outFile);) {
		out.println("Read text from file");
		try (FileInputStream myFile = new FileInputStream("E:\\learn\\PVT\\input.txt");
				InputStreamReader inPut = new InputStreamReader(myFile);
				BufferedReader reader = new BufferedReader(inPut);) {

			int ch;
			out.println("Convert Stream to StringBuilder");
			while ((ch = reader.read()) > -1) {
				buff.append((char) ch);
			}
			out.println("Convert StringBuilder to String");
			s = buff.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		s = new String(s.replaceAll("\n|\r\n", " ").replace("+", " + ").replace("-", " - ").replace("*", " * ")
				.replace("/", " / "));
		out.println("Convert String to Array");
		String[] c = s.split("[ ]+");

		out.println("Find the symbol, do the arithmetic operation and out result");
	
		for (int i = 0; i < c.length; i++) {
			int k = 0;
		
		
			if (c[i].equals("+")) {
				k = Integer.parseInt(c[i - 1]) + Integer.parseInt(c[i + 1]);
				System.out.println(k);
				out.println(k);
			} else if (c[i].equals("-")) {
				k = Integer.parseInt(c[i - 1]) - Integer.parseInt(c[i + 1]);
				System.out.println(k);
				out.println(k);
			}

			else if (c[i].equals("*")) {
				k = Integer.parseInt(c[i - 1]) * Integer.parseInt(c[i + 1]);
				System.out.println(k);
				out.println(k);
			} else if (c[i].equals("/")) {
				k = Integer.parseInt(c[i - 1]) / Integer.parseInt(c[i + 1]);
				System.out.println(k);
				out.println(k);
			}

		}

	} catch (IOException e) {
		e.printStackTrace();
	}
}
}

