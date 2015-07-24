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

import edu.mit.jwi.item.POS;

public class Adjective extends PartOfSpeach {
	
	/*public static enum Graduation {
		ABSOLUTE,
		COMPARATIVE,
		SUPERLATIVE
	}
	
	private Graduation graduation;*/

	public Adjective(int adjSynSet) {
		super(adjSynSet);
	}

	@Override
	public POS getPOS() {
		return POS.ADJECTIVE;
	}

}