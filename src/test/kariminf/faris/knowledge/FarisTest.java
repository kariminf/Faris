package kariminf.faris.knowledge;

/* FARIS : Factual Arrangement and Representation of Ideas in Sentences
 * FAris : Farabi & Aristotle
 * Faris : A knight (in Arabic)
 * --------------------------------------------------------------------
 * Copyright (C) 2015 Abdelkrime Aries (kariminfo0@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import kariminf.faris.knowledge.Faris;

/**
 * Testing faris
 * 
 * @author Abdelkrime Aries (kariminfo0@gmail.com)
 *         <br>
 *         Copyright (c) 2015-2017 Abdelkrime Aries
 *         <br><br>
 *         Licensed under the Apache License, Version 2.0 (the "License");
 *         you may not use this file except in compliance with the License.
 *         You may obtain a copy of the License at
 *         <br><br>
 *         http://www.apache.org/licenses/LICENSE-2.0
 *         <br><br>
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *         See the License for the specific language governing permissions and
 *         limitations under the License.
 */
public class FarisTest {
	
	static String testFile = "/home/kariminf/Github/Nolporas/STON/bio/NaguibMahfouz_bio/NaguibMahfouz_Bio.ston";

	public static String readFile (String f) {
		try {
			String contents = "";

			BufferedReader input = new BufferedReader(new FileReader(f));

			
			for(String line = input.readLine(); line != null; line = input.readLine()) {
				contents += line + "\n";
			}
			input.close();

			return contents;

		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		} 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String specif = readFile(testFile);
		Faris faris = new Faris();
		boolean success = faris.addStonDescription(specif);
		
		if (!success) System.out.println("NOT SUCCESS");
		print(faris);
		//faris.displayStates();
		
		//search(faris);
	}
	
	public static void search(Faris faris){
		System.out.print(faris.getSynSetText(7846));
	}
	
	
	public static void print(Faris faris){
		System.out.println(faris.info());
		System.out.print(faris);
	}

}
