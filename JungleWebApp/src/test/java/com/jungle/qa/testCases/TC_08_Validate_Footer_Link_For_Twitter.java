package com.jungle.qa.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.JungleWebApp.Base;
import com.jungle.qa.pages.HomePage;

public class TC_08_Validate_Footer_Link_For_Twitter extends Base{

	HomePage homePage;
	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validateFooterLinkForTwitter() throws IOException, InterruptedException {
		
		logger = report.createTest(tcName);
		homePage = new HomePage();
		
		homePage.clickTwitterLink();
		
		ArrayList<String> handles = getWindowHandles();
		
		if(handles.size() == 2) {
			
			logger.pass("NEW TAB OPENED");
			switchToTab(handles.get(1));
			Thread.sleep(4000);
		}
		
		String twitterTitle = getPageTitle();
		System.out.println(" Title : " + twitterTitle);
		
		getScreenshot(tcName+"_JUNGLE_TWITTER_LINK");
		Assert.assertTrue(twitterTitle.contains("Twitter"));
		logger.pass("JUNGLE TWITTER PAGE IS OPENED");
		
		closeTab();
		switchToTab(handles.get(0));

	}
}
