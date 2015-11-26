/* Farest : Facts representation of sentences
 * ------------------------------------------
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
package dz.aak.faris.linguistic;

public abstract class PartOfSpeach {
	
	
	public static enum POS {
		NOUN,
		VERB,
		ADJECTIVE,
		ADVERB
	}

	private int synSet = -1;
	
	public PartOfSpeach(int synSet) {
		this.synSet = synSet;
	}
	
	public int getSynSet(){
		return synSet;
	}
	
	public abstract POS getPOS();

}