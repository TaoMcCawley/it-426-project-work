package strategies;

import java.util.Iterator;

import reviews.Review;

public interface IStrategy
{
	public int getScore(int year, Iterator<Review> reviews);
}