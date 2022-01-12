package com.jungle.qa.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.JungleWebApp.Base;
import com.jungle.qa.pages.HomePage;

public class TC_09_Validate_Footer_Link_For_LinkedIn extends Base{

	HomePage homePage;
	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validateFooterLinkForLinkedIn() throws IOException, InterruptedException {
		
		logger = report.createTest(tcName);
		homePage = new HomePage();
		
		homePage.clickLinkedInLink();
		
		ArrayList<String> handles = getWindowHandles();
		
		if(handles.size() == 2) {
			
			logger.pass("NEW TAB OPENED");
			switchToTab(handles.get(1));
			Thread.sleep(4000);
		}
		
		String linkedInTitle = getPageTitle();
		System.out.println(" Title : " + linkedInTitle);
		
		getScreenshot(tcName+"_JUNGLE_LINKEDIN_LINK");
		Assert.assertTrue(linkedInTitle.contains("LinkedIn"));
		logger.pass("JUNGLE LINKEDIN PAGE IS OPENED");
		
		closeTab();
		switchToTab(handles.get(0));

	}
}
