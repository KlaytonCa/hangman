import java.io.File;
import java.util.*;

public class HangmanManager
{
	Set<String> words;
	Set<Character> guesses;
	String pattern;
	Map<Integer,String> pat;
	int ng = 0;
	int len;
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		
		if(length > 1 && max > 0)
		{
		len = length;
		guesses = new HashSet<Character>();
		pat = new TreeMap<Integer,String>();
		for(int h = 0; h < 26; h++)
			pat.put(h,"-");
		ng = max;
		words = new HashSet<String>();
		for (int i = 0; i < dictionary.size(); i++)
		{
			if(dictionary.get(i).length() == length)
				words.add(dictionary.get(i));
		}
	}
	}
	
	public Set<String> words()
	{
			return words;
	}	
	
	public int guessesLeft()
	{
		return ng;
	}
		
	public Set<Character> guesses()
	{
		return guesses;
	}
	
	public String pattern()
	{
		pattern = "";
		for(int i = 0; i < pat.size(); i++)
			pattern += pat.get(i);
		return pattern;
	}
	
	public int record( char guess )
	{
		guesses.add(guess);
		pat.put(guess -97,Character.toString(guess));
		ArrayList<Set<String>> sets = new ArrayList<Set<String>>();
		for(int g = 0; g < len; g++)
		{
			sets.add(new HashSet<String>());
		}
		int count = 0;
		System.out.println(Character.toString(guess));
		String[] wordlist =words.toArray(new String[words.size()]);
		System.out.println(wordlist[0].substring(0,1));
		
		for(int i = 0; i < words.size(); i++)
		{
			// loops through the list of words
			
		
				// loops through each letter in the word
				for(int numbere = 0; numbere < len; numbere++)
				{
					//loops through the word adding it to word list 1 > x depending on the number of matching leters
					if(wordlist[i].substring(numbere,numbere+1).toLowerCase() == Character.toString(guess))
					{
						
						count ++;
						System.out.println(count + " count");
					}
				
			}
				(sets.get(count)).add(wordlist[i]);
				count = 0;
		}
		int biggest = 0;
		int thenew = 0;
		// gets the biggest set
		for(int big = 0; big < sets.size();big++)
		{
			if(sets.get(big).size() > biggest)
			{
				biggest = sets.get(big).size();
				thenew = big;
			}
		}
		System.out.println(sets.get(2));
			words =(sets.get(thenew));
			System.out.println(words);
		
		return biggest;
	}

	
}