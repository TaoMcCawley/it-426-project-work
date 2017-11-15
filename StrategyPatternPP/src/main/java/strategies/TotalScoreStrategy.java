package strategies;

import java.util.Iterator;

import reviews.Review;

public class TotalScoreStrategy implements IStrategy
{
	@Override
	public int getScore(int year, Iterator<Review> reviews)
	{
		while (reviews.hasNext())
		{
			Review review = reviews.next();
			if (review.getYear() == year)
			{
				int count = 0;
				
				for (int kpi : review.getKpis())
				{
					count += kpi;
				}
				
				return count;
			}
		}
		
		return 0;
	}
}
