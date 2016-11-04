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


package kariminf.faris.philosophical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kariminf.faris.linguistic.Adverb;
import kariminf.faris.linguistic.Verb;
import kariminf.faris.ston.Concepts;


/**
 * Action (poiein, to make or do) — examples: to lance, to heat, to cool (something)
 * Affection, passion (paschein, to suffer or undergo) — examples: to be lanced, 
 * to be heated, to be cooled
 * 
 * @author Abdelkrime Aries (kariminfo0@gmail.com)
 *         <br>
 *         Copyright (c) 2015-2016 Abdelkrime Aries
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
public class Action {
	
	public static enum ActionRelation {
		IMPLY,
		CAUSE,
		After,
		Before
	}
	
	private static class ConjunctedSubstances extends HashSet<QuantSubstance> {
		private static final long serialVersionUID = 1L;
		
		public ArrayList<QuantSubstance> getSubstances(){
			ArrayList<QuantSubstance> result = new ArrayList<>();
			result.addAll(this);
			return result;
		}
		
		public ConjunctedSubstances fuse(ConjunctedSubstances cs){
			ConjunctedSubstances result = new ConjunctedSubstances();
			result.addAll(cs);
			return result;
		}
		
	}
	
	
	//An action is defined by a verb
	private Verb verb;
	//- A verb has tense, indicating the time that the sentence describes
	//- A verb has mood, indicating whether the sentence describes reality or 
	//expresses a command, a hypothesis, a hope, etc.
	
	//An action is modified by many adverbs
	private Set<Adverb> adverbs = new HashSet<>();
	
	//Here, we use disjunctions of conjunctions 
	//An Action can have many doers (we can't duplicate a doer)
	private Set<ConjunctedSubstances> doers = new HashSet<>(); 
	
	//An Action can affect many predicates 
	private Set<ConjunctedSubstances> receivers = new HashSet<>();  
	
	//An action can have relations with other Actions
	private HashMap<Action, ActionRelation> relations = new HashMap<>();
	
	//An action can have locations
	private Set<Place> locations = new HashSet<>(); 
	
	//An action can have times
	private Set<Time> times = new HashSet<>(); 

	private Action(Verb verb){ 
		
		this.verb = verb;
		//We have to treat the verb before adding it
		//Or we enter the infinitive form, and before that we transform it 
		//to infinitive in the global system
	}
	
	public static Action getNew (Verb verb){
		return new Action(verb);
	}
	
	public boolean hasAdverb(Adverb adv){
		return adverbs.contains(adv);
	}
	
	public boolean hasAdverb(int advSynset){
		Adverb adv = new Adverb(advSynset);
		return adverbs.contains(adv);
	}
	
	/**
	 * 
	 * @param adv
	 * @param modifiers
	 */
	public void addAdverb(Adverb adv, Set<Adverb> modifiers){
		adverbs.add(adv);
	}
	
	/**
	 * Adds substances that are separated by the word "and". <br>
	 * @param conjunctions2
	 */
	public void addConjunctSubjects(List<QuantSubstance> conjunctions2){
		ConjunctedSubstances conjunctions = new ConjunctedSubstances();
		conjunctions.addAll(conjunctions2);
		if (conjunctions.size()>0)
			this.doers.add(conjunctions);
	}
	
	/**
	 * Adds substances that are separated by the word "and". <br>
	 * @param subjects
	 */
	public void addConjunctObjects(List<QuantSubstance> conjunctions2){
		ConjunctedSubstances conjunctions = new ConjunctedSubstances();
		conjunctions.addAll(conjunctions2);
		if (conjunctions.size()>0)
			this.receivers.add(conjunctions);
	}
	
	public boolean hasSubjects(){
		return (doers.size() > 0);
	}
	
	public boolean hasObjects(){
		return (receivers.size() > 0);
	}
	
	
	public void addLocation(Place place){
		locations.add(place);
	}
	
	public void addTime(Time time){
		times.add(time);
	}
	
	private ArrayList<ArrayList<QuantSubstance>> getDisjunctions(Set<ConjunctedSubstances> disjunctions){
		ArrayList<ArrayList<QuantSubstance>> result = new ArrayList<>();
		for (ConjunctedSubstances conjunctions: disjunctions)
			result.add(conjunctions.getSubstances());
		
		return result;
	}
	
	public ArrayList<ArrayList<QuantSubstance>> getSubjects(){
		return getDisjunctions(doers);
	}
	
	public ArrayList<ArrayList<QuantSubstance>> getObjects(){
		return getDisjunctions(receivers);
	}
	
	public Verb getVerb(){
		return verb;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "";
		result += doers ;
		result += " " + verb ;
		//TODO locations and times in tostring
		result += " " + receivers ;
		
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verb == null) ? 0 : verb.hashCode());
		result = prime * result + ((doers == null) ? 0 : doers.hashCode());
		result = prime * result + ((receivers == null) ? 0 : receivers.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Action)) return false;
		
		Action other = (Action) obj;
		
		if (! this.verb.equals(other.verb)) return false;
		
		//If one action contains the adverb "also", this means their are more doers or 
		// receivers and not the two
		if ( hasAdverb(Concepts.ALSO) || other.hasAdverb(Concepts.ALSO)){
			return (this.doers.equals(other.doers) || this.receivers.equals(other.receivers));
		}
		
		//Otherwise the 
		return (this.doers.equals(other.doers) && this.receivers.equals(other.receivers));
	}
	
	/**
	 * 
	 * @param act
	 * @return
	 */
	public boolean update(Action act){
		
		if (! equals(act)) return false;
		
		// Doers update
		// (AB + CD)(EF + GH) = ABEF + ABGH + CDEF + CDGH
		if (! doers.equals(act.doers)){
			Set<ConjunctedSubstances> doersTmp = new HashSet<>();
			for (ConjunctedSubstances cs: doers){
				for (ConjunctedSubstances cs2: act.doers){
					doersTmp.add(cs.fuse(cs2));
				}
			}
			doers = doersTmp;
		}
		
		// Receivers update
		if (! receivers.equals(act.receivers)){
			Set<ConjunctedSubstances> receiversTmp = new HashSet<>();
			for (ConjunctedSubstances cs: receivers){
				for (ConjunctedSubstances cs2: act.receivers){
					receiversTmp.add(cs.fuse(cs2));
				}
			}
			receivers = receiversTmp;
		}
		
		// Adverbs update
		if (! adverbs.equals(act.adverbs)){
			for (Adverb adv: act.adverbs)
				adverbs.add(adv);
		}
		
		//Delete the adverb: also
		adverbs.remove(new Adverb(Concepts.ALSO));
		
		// Locations update
		if (! locations.equals(act.locations)){
			for (Place loc: act.locations)
				locations.add(loc);
		}
		
		// Times update
		if (! times.equals(act.times)){
			for (Time time: act.times)
				times.add(time);
		}
		
		// Relations with other actions (update)
		if (! relations.equals(act.relations)){
			for (Action a: act.relations.keySet())
				if (!relations.containsKey(a))
					relations.put(a, act.relations.get(a));
		}
		
		
		return true;
	}
	

}