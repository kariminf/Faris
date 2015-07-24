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
package dz.aak.faris.knowledge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dz.aak.faris.philosophical.Substance;

public class Mind {

	//private HashMap<>
	
	public static enum Truth {
		THINK,
		BELIEVE,
		HOPE,
		QUOTE,
		FACT
	}
	
	private String name;
	private Substance owner;
	
	private HashMap<Truth, Idea> ideas = new HashMap<Truth, Idea>();
	
	private List<Conditional> conditions = new ArrayList<Conditional>();
	
	public Mind(String name) {
		this.name = name;
		
	}

}
