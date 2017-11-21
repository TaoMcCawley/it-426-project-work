package strategies;

import java.util.Iterator;

import reviews.Review;

public class WeightedScoreStrategy implements IStrategy
{
	private double[] weights = {1.0, 2.0, 1.0, 3.0, 1.0, 1.0};

	@Override
	public int getScore(int year, Iterator<Review> reviews)
	{
		while (reviews.hasNext())
		{
			Review review = reviews.next();
			if (review.getYear() == year)
			{
				int count = 0;
				int[] kpis = review.getKpis();
				
				for (int j = 0; j < kpis.length; j++)
				{
					count += kpis[j] * weights[j];
				}
				
				return count;
			}
		}
		
		return 0;
	}
}
