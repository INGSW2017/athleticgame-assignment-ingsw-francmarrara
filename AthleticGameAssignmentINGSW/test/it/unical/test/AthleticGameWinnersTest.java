package it.unical.test;

import java.time.Instant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameWinnersTest {
	private static AthleticGame game;

	@BeforeClass
	public static void init() {
		game = new AthleticGame("Calcio");
	}

	@After
	public void reset() {
		game.reset();
	}

	@Before
	public void start() {
		game.start();
	}

	@Test
	public void getWinnerWorks_v1() {
		game.addArrival("Andrea_Conti", Instant.now().plusMillis(1000));
		game.addArrival("Ignazio_Abate", Instant.now().plusMillis(2000));
		game.addArrival("Frank_Kessie", Instant.now().plusMillis(3000));
		game.addArrival("Riccardo_Montolivo", Instant.now().plusMillis(5000));

		Assert.assertEquals("Andrea_Conti", game.getWinner());
	}

	@Test
	public void getWinnerWorks_v2() {

		game.addArrival("Andrea_Conti", Instant.now().plusMillis(1000));
		game.addArrival("Ignazio_Abate", Instant.now().plusMillis(1001));
		game.addArrival("Frank_Kessie", Instant.now().plusMillis(1002));
		game.addArrival("Riccardo_Montolivo", Instant.now().plusMillis(1003));

		Assert.assertEquals("Andrea_Conti", game.getWinner());
	}

}
