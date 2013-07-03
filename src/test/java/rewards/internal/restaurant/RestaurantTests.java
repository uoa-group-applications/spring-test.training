package rewards.internal.restaurant;

import org.junit.Before;
import org.junit.Test;

import rewards.Dining;
import rewards.internal.account.Account;

/**
 * Unit tests for exercising the behavior of the Restaurant aggregate entity. A restaurant calculates a benefit to award
 * to an account for dining based on an availability policy and benefit percentage.
 */
public class RestaurantTests {

	private Account account;

	private Dining dining;

	// sets up test fixtures
	@Before
	public void setUp() {
		// TODO 1: setup the main Restaurant object you will test

		// sets up supporting objects needed to run the test
		account = new Account("123456789", "Keith and Keri Donald");
		account.addBeneficiary("Annabelle");
		// creates a new dining of 100.00 charged to credit card '1234123412341234' by merchant '123457890'
		dining = Dining.createDining("100.00", "1234123412341234", "1234567890");
	}

	@Test
	public void testCalcuateBenefitFor() {
		// TODO 2: Implement the 'normal' calculateBenefitFor() scenario test
	}

	@Test
	public void testNoBenefitAvailable() {
		// TODO 3: Implement the 'exceptional' noBenefitAvailable() scenario test
	}

	/**
	 * A simple "dummy" benefit availability policy containing a single flag used to determine if benefit is available.
	 * Only useful for testing--a real availability policy might consider many factors such as the day of week of the
	 * dining, or the account's reward history for the current month.
	 */
	private static class StubBenefitAvailibilityPolicy implements BenefitAvailabilityPolicy {

		private boolean isBenefitAvailable;

		public StubBenefitAvailibilityPolicy(boolean isBenefitAvailable) {
			this.isBenefitAvailable = isBenefitAvailable;
		}

		public boolean isBenefitAvailableFor(Account account, Dining dining) {
			return isBenefitAvailable;
		}
	}
}