package com.jungle.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.JungleWebApp.Base;
import com.jungle.qa.pages.HomePage;

public class TC_05_Validate_Presence_Of_HowItWorks_Subsections extends Base{

	HomePage homePage;
	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validatePresenceOfHowItWorksSubsections() throws IOException, InterruptedException {
		
		logger = report.createTest(tcName);
		homePage = new HomePage();
		homePage.clickHowItWorks();
		
		boolean flag = false;
		
		getScreenshot(tcName+"_HOWITWORKS_SECTION");
		
		flag = homePage.isSetUpYourWalletSectionVisible();
		Assert.assertTrue(flag, "Set Up Your Wallet Section is Not Visible");
		logger.pass("SET UP YOUR WALLET SECTION IS DISPLAYED");
		
		flag = false;
		flag = homePage.isBuildYourCollectionSectionVisible();
		Assert.assertTrue(flag, "Build your collection Section is Not Visible");
		logger.pass("BUILD YOUR COLLECTION SECTION IS DISPLAYED");
		
		flag = false;
		flag = homePage.isAddyourOwnNFTSectionVisible();
		Assert.assertTrue(flag, "Add your own NFTs Section is Not Visible");
		logger.pass("ADD YOUR OWN NFTs SECTION IS DISPLAYED");
		
		flag = false;
		flag = homePage.isListNFTForSaleSectionVisible();
		Assert.assertTrue(flag, "List NFTs for sale Section is Not Visible");
		logger.pass("LIST NFTs FOR SALE SECTION IS DISPLAYED");
		
	}
}
