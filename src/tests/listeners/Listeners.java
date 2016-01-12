package tests.listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.testrail.service.TestRailService;

import tests.TestBase;

public class Listeners {

	protected static void initService(Properties properties) throws MalformedURLException {
		//Set up all the credentials

		//If clientId isn't in there or it's blank, look for api_endpoint. If it's there and not null, that means we have a "local" TestRail Instance.
		// Set the service's apiEndpoint accordingly for the remainder of the test.
		//If both properties are defined, api_endpoint will be ignored
		String clientId = properties.getProperty("clientId");
		if (null == clientId || clientId.isEmpty()) {
			String apiEndpoint = properties.getProperty("api_endpoint");
			TestBase.getService().setApiEndpoint(new URL(apiEndpoint));
		} else {
			//If clientID wasn't null after all, set it, and use the "hosted" TestRail Instance code path
			TestBase.getService().setClientId(clientId);
		}
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		TestBase.getService().setUsername(username);
		TestBase.getService().setPassword(password);
		TestBase.assegnedId = new Integer(properties.getProperty("assignedToId"));
	}
}
