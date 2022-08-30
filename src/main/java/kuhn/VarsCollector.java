package kuhn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VarsCollector {
	Set<String> vars = new HashSet<>();
	void collectVar(String var) {
		vars.add(var);
	}
	void collectAll(Collection<String> c) {
		vars.addAll(c);
	}
	public void dumpVarsAsDoubles() {
		List<String> vars_ = new ArrayList<>(vars);
		Collections.sort(vars_, Comparator.comparing(String::length));
		for(var var_:vars_) {
			String val ="n/a";
			int length=var_.length();
			if(var_.equals("R")) val="1.d";
			else if(length==2) val="1.d/3";
			else if(length==3) val="1.d/2";
			else {
				//playerA
				
				/*
				 * player one freely chooses the probability alpha \in [0,1/3]
				 * with which he will bet when having a Jack (otherwise he checks; 
				 * if the other player bets, he should always fold).
				 */
				
				if(length==4) {
					char card=var_.charAt(1);
					char action = var_.charAt(3);
					if(card=='J'&&action=='B')
						val="alpha";
					if(card=='J'&&action!='B')
						val="1d-alpha";
				/*
				 * When having a King, he should bet with the probability of 
				 * 3 \alpha 
				 *  (otherwise he checks; if the other player bets, he should always call).
				 */
					if(card=='K'&&action=='B')
						val="3d*alpha";
					if(card=='K'&&action!='B')
						val="1d-3.*alpha";
					
					/*
					 *   He should always check when having a Queen,
					 *   and if the other player bets after this check,
					 *   he should call with the probability of 
					 *   alpha+1/3.
					 */
					if(card=='Q'&&action=='K')
						val="1d";
					if(card=='Q'&&action!='K')
						val="0";
				}

				if(length==6) {
					char card=var_.charAt(1);
					char action = var_.charAt(5);
					if(card=='J'&&action=='F')
						val="1d";
					if(card=='J'&&action!='F')
						val="0d";
					
					if(card=='K'&&action=='C')
						val="1d";
					if(card=='K'&&action!='C')
						val="0d";

					if(card=='Q'&&action=='C')
						val="alpha+1d/3";
					if(card=='Q'&&action!='C')
						val="1d-(alpha+1d/3)";
					
				}
				if(length==5) {
					char card=var_.charAt(2);
					char action = var_.charAt(4);
					
					/*
					 * The second player has a single equilibrium strategy:
					 * Always betting or calling when having a King;
					 */
					if(card=='K'&&(action=='C'||action=='B'))
						val="1d";
					if(card=='K'&& !(action=='C'||action=='B'))
						val="0d";
					/*
					 * when having a Queen, checking if possible, otherwise calling with the
					 * probability of 1/3;
					 */
					if(card=='Q'&& action=='K' )
						val="1d";
					if(card=='Q'&& action=='B' )
						val="0d";
					if(card=='Q'&& action=='C' )
						val="1d/3";
					if(card=='Q'&& action=='F' )
						val="1d-(1d/3)";
					/*
					 * when having a Jack, never calling
					 * and betting with the probability of 1/3.
					 */
					if(card=='J'&& action=='C' )
						val="0d";
					if(card=='J'&& action=='F' )
						val="1d";
					if(card=='J'&& action=='B' )
						val="1d/3";
					if(card=='J'&& action=='K' )
						val="2d/3";
				}

				
			}
			
			System.out.printf("double %s=%s;%n", var_, val);
		}
	}
	
}
