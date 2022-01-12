package com.jungle.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.JungleWebApp.Base;
import com.jungle.qa.pages.HomePage;

public class TC_06_Validate_Presence_Of_Categories_In_Browse_By_Category_Section extends Base{

	HomePage homePage;
	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validatePresenceOfBrowseByCategorySection() throws IOException, InterruptedException {
		
		logger = report.createTest(tcName);
		homePage = new HomePage();
		
		homePage.clickMarket();
		Thread.sleep(4000);
		
		boolean flag = false;
		
		getScreenshot(tcName+"_BROWSEBYCATEGORY_SECTION");
		
		flag = homePage.isArtCategoryVisible();
		Assert.assertTrue(flag, "ArtCategory is Not Visible");
		logger.pass("ART CATEGORY IS VISIBLE");
		
		flag = false;
		flag = homePage.isMusicCategoryVisible();
		Assert.assertTrue(flag, "MusicCategory is Not Visible");
		logger.pass("MUSIC CATEGORY IS VISIBLE");
		
		flag = false;
		flag = homePage.isDomainNamesCategoryVisible();
		Assert.assertTrue(flag, "DomainNamesCategory is Not Visible");
		logger.pass("DOMAIN NAMES CATEGORY IS VISIBLE");
			
	}
}
