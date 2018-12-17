package com.bowling.game;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for BowlingGame .
 */
public class BowlingGameTest {
	private BowlingGame bowlingGame;

	@Before
	public void setUp() {
		bowlingGame = new BowlingGame();
	}

	@Test
	public void test_empty_bowling() {
		rollMany(10, 0);
		assertThat(bowlingGame.score()).isEqualTo(0);
	}

	@Test
	public void test_ones_all() {
		rollMany(10, 1);
		assertThat(bowlingGame.score()).isEqualTo(10);
	}

	@Test
	public void test_one_spare() {
		rollSpare();
		bowlingGame.roll(3);
		rollMany(17, 0);

		assertThat(bowlingGame.score()).isEqualTo(16);
	}

	@Test
	public void test_one_strike() {
		rollStrike(10);
		bowlingGame.roll(3);
		bowlingGame.roll(4);
		rollMany(16, 0);

		assertThat(bowlingGame.score()).isEqualTo(24);
	}

	@Test
	public void test_perfect_game() {
		rollMany(12, 10);
		assertThat(bowlingGame.score()).isEqualTo(300);
	}

	private void rollMany(int roll, int pins) {
		for (int i = 0; i < roll; i++) {
			bowlingGame.roll(pins);
		}
	}

	private void rollSpare() {
		bowlingGame.roll(5);
		bowlingGame.roll(5);
	}

	private void rollStrike(int i) {
		bowlingGame.roll(i);
	}
}
