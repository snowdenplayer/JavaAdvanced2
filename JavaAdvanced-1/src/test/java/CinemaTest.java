import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import Exeptions.TimeExeption;

public class CinemaTest {
	private Cinema cinema;
	private Movie movie;
	private Movie movie1;
	private Time time;
	private Seance sean;
	
	@Rule
	public TestWatcher test = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("Failed "+description.getMethodName());
		};
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("Succed "+description.getMethodName());
		};
	};
	
	@Before
	public void beforeTest() throws TimeExeption {
		cinema = new Cinema();
		time = new Time(45,1);
		movie = new Movie("Mumbai", time);
		movie1 = new Movie("Lion",new Time(20,2));
		
		
	}
	
	@After
	public void afterTest() {
	cinema = null;
	time =null;
	movie = null;
	movie1 = null;
		
	}
	@Test
	public void addMovieTest() {
		cinema.addMovie(movie);
		cinema.addMovie(movie1);
		List<Movie> expected = new ArrayList<Movie>();
		expected.add(movie);
		expected.add(movie1);		
		List<Movie> real = cinema.getMoviesLibrary();
		Assert.assertEquals(expected, real);		
	};
	
	
	@Test
	public void removeCinemaTest() throws Exception {
		cinema.addMovie(movie);
		cinema.addMovie(movie1);
		
		cinema.removeMovie(movie);
		
		ArrayList<Movie> real = cinema.getMoviesLibrary();
		ArrayList<Movie> expected = new ArrayList<>();	
		expected.add(movie1);
		
		Assert.assertEquals(expected, real);
		
	}
	
	

}
