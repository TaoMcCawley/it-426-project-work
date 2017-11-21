package strategies;

import java.util.Iterator;

import reviews.Review;

public class ImprovementStrategy implements IStrategy
{
	@Override
	public int getScore(int year, Iterator<Review> reviews)
	{
		Review thisYear = null;
		Review lastYear = null;
		
		while (reviews.hasNext())
		{
			Review current = reviews.next();
			
			if (current.getYear() == year)
			{
				thisYear = current;
			}
			else if (current.getYear() == year - 1)
			{
				lastYear = current;
			}
		}
		
		if (thisYear == null || lastYear == null)
		{
			return 0;
		}
		else
		{
			int[] thisKpis = thisYear.getKpis();
			int[] lastKpis = lastYear.getKpis();
			
			int score = 0;
			for (int i = 0; i < thisKpis.length; i++)
			{
				score += thisKpis[i] + lastKpis[i];
			}
			
			return score;
		}
	}
}
