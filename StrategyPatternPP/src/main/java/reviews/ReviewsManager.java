package reviews;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ReviewsManager
{
	private Set<String> names;
	private Map<String, List<Review>> yearlyReviews;
	
	public ReviewsManager()
	{
		names = new HashSet <>();
		yearlyReviews = new HashMap<>();
		
		loadData();
	}
	
	private void loadData()
	{
		try(Scanner reader = new Scanner(new FileInputStream("files/reviews.txt")))
		{
			while (reader.hasNextLine())
			{
				String line = reader.nextLine();
				
				//get each part of the review
				String[] parts = line.split(", ");
				String name = parts[0];
				int year = Integer.parseInt(parts[1]);
				int[] kpis = new int[parts.length - 2];
				
				for (int i = 0; i < kpis.length; i++)
				{
					kpis[i] = Integer.parseInt(parts[i + 2]);
				}
				
				names.add(name);
				
				if (!yearlyReviews.containsKey(name))
				{
					yearlyReviews.put(name, new ArrayList<>());
				}

				Review review = new Review(name, year, kpis);
				yearlyReviews.get(name).add(review);
			}
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("Write error: " + ex.getMessage());
		}
	}
	
	public Iterator<Review> getReviews(String name)
	{
		if (!yearlyReviews.containsKey(name))
		{
			return null;
		}
		
		return yearlyReviews.get(name).iterator();
	}
	
	public Iterator<String> getNames()
	{
		return names.iterator();
	}
}
