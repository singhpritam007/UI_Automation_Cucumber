package pages;

import io.cucumber.java.en.Given;

public class DryRunStepDefinition {

	@Given("user run dry run test for first time")
	public void user_run_dry_run_test_for_first_time()
	{
		System.out.println("dry run test");
	}
}
