package reviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import strategies.IStrategy;
import strategies.ImprovementStrategy;
import strategies.TotalScoreStrategy;
import strategies.WeightedScoreStrategy;

public class RankedReviews
{
	private static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args)
	{
	    System.out.println("Employee Rankings Application");
        System.out.println("*****************************");
        System.out.println();
        
		System.out.println("Enter a strategy (improvement, total, weighted)");
		String option = console.nextLine();
		
		IStrategy strategy;
		switch(option)
		{
			case "improvement":
				strategy = new ImprovementStrategy();
				break;
			case "total":
				strategy = new TotalScoreStrategy();
				break;
			default: //case "weighted":
				strategy = new WeightedScoreStrategy();
				break;
		}
		
		ReviewsManager manager = new ReviewsManager();
		Iterator<String> names = manager.getNames();
		
		List<RankedReview> rankedList = new ArrayList<>();
		
		while (names.hasNext())
		{
			String name = names.next();
			Iterator<Review> reviews = manager.getReviews(name);
			int score = strategy.getScore(2017, reviews);
			
			rankedList.add(new RankedReview(name, score));
		}
		
		RankedReview[] rankedReviews = rankedList.toArray(new RankedReview[rankedList.size()]);
		Arrays.sort(rankedReviews);
		
		//print out the ranked list
		for (int i = 0; i < rankedReviews.length; i++)
		{
			System.out.println(rankedReviews[i].name + ": " + rankedReviews[i].score);
		}
	}
	
	public static class RankedReview implements Comparable<RankedReview>
	{
		private String name;
		private int score;
		
		public RankedReview(String name, int score)
		{
			this.name = name;
			this.score = score;
		}
		
		public String getName()
		{
			return name;
		}
		
		public int getScore()
		{
			return score;
		}

		public int compareTo(RankedReview other)
		{
			return other.score - this.score;
		}
	}
}
