package com.jungle.qa.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.JungleWebApp.Base;
import com.jungle.qa.pages.HomePage;

public class TC_10_Validate_Footer_Link_For_Facebook extends Base{

	HomePage homePage;
	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validateFooterLinkForFacebook() throws IOException, InterruptedException {
		
		logger = report.createTest(tcName);
		homePage = new HomePage();
	
		homePage.clickFacebookLink();
		
		ArrayList<String> handles = getWindowHandles();
		
		if(handles.size() == 2) {
			
			switchToTab(handles.get(1));
			Thread.sleep(4000);
		}
		
		String facebookTitle = getPageTitle();
		System.out.println(" Title : " + facebookTitle);
		
		getScreenshot(tcName+"_JUNGLE_FACEBOOK_LINK");
		Assert.assertTrue(facebookTitle.contains("Facebook"));
		logger.pass("JUNGLE FACEBOOK PAGE IS OPENED");
		
		closeTab();
		switchToTab(handles.get(0));

	}
}
