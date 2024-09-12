package retry;
//Uses in any test case.
//retry limit is always greater than counter value.
import org.testng.IRetryAnalyzer;   
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
	int counter = 0;
	int retryLimit = 2;

	public boolean retry(ITestResult result)
	{
		if (counter < retryLimit) 
		{
			counter++;
			return true;
		}
		return false;
	}
}

//when testcase fail other than coding error(network error), then retry it more time based on limit
//retry used inside testcase -here login method
//retry is an annotation