package reviews;

import java.util.Arrays;

public class Review
{
	private String name;
	private int year;
	private int[] kpis;
	
	public Review(String name, int year, int[] kpis)
	{
		this.name = name;
		this.year = year;
		this.kpis = kpis;
	}

	public String getName()
	{
		return name;
	}

	public int getYear()
	{
		return year;
	}

	public int[] getKpis()
	{
		return kpis;
	}

	@Override
	public String toString()
	{
		return "Review [name=" + name + ", year=" + year + ", kpis="
				+ Arrays.toString(kpis) + "]";
	}
}
