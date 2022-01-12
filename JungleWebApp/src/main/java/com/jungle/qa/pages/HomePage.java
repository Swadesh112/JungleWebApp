package com.jungle.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jungle.qa.JungleWebApp.Base;

public class HomePage extends Base{
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='banner']//h1[contains(@class,'headline')]")
	private WebElement bannerHeadline;
	
	public String getBannerHeadlineText() {
		
		waitForElementVisible(bannerHeadline);
		return bannerHeadline.getText();
	}
	
	@FindBy(xpath="//*[@id='nav-menu']//a[contains(text(),'Explore')]")
	private WebElement exploreHeaderLink;
	
	public void clickExplore() {
		
		waitForElementClickable(exploreHeaderLink);
		exploreHeaderLink.click();
	}
	
	@FindBy(xpath="//*[@id='nav-menu']//a[contains(text(),'Market')]")
	private WebElement marketHeaderLink;
	
	public void clickMarket() {
		
		waitForElementClickable(marketHeaderLink);
		marketHeaderLink.click();
	}
	
	@FindBy(xpath="//*[@id='nav-menu']//a[contains(text(),'How It Works')]")
	private WebElement howItWorksHeaderLink;
	
	public void clickHowItWorks() {
		
		waitForElementClickable(howItWorksHeaderLink);
		howItWorksHeaderLink.click();
	}
	
	//------------------------------------------------------------------------------
	@FindBy(id="faq")
	private WebElement faqSection;
	
	@FindBy(xpath="//span[contains(text(),'What is Jungle NFT?')]/parent::h3")
	private WebElement faqQuestion;
	
	@FindBy(xpath="//div[contains(@class,'faq__answer jsAnswer 0')]")
	private WebElement faqAnswer;
	
	public boolean isFAQQuestionVisible() {
		
		waitForElementVisible(faqQuestion);
		return faqQuestion.isDisplayed(); 	
	}
	
	public boolean isFAQAnswerVisible() {
		
		waitForElementVisible(faqAnswer);
		return faqAnswer.isDisplayed(); 	
	}
	
	@FindBy(xpath="//ul[@class='faq__list']/li[@class='faq__item'][1]/h3[contains(@class,'faq__question jsQuestion')]")
	public WebElement faqQuestionExpanded;
	
	@FindBy(xpath="//ul[@class='faq__list']/li[@class='faq__item'][1]/div[contains(@class,'faq__answer jsAnswer 0')]")
	public WebElement faqAnswerCollapsed;
	
	@FindBy(xpath="//ul[@class='faq__list']/li[@class='faq__item'][1]//div[contains(@class,'faq__icon')]")
	private WebElement faqCollapseIcon;
	
	public void clickFAQCollapseIcon() {
		
		waitForElementClickable(faqCollapseIcon);
		faqCollapseIcon.click();
	}
	
	
	//------------------------------------------------------------------------------
	@FindBy(id="market")
	private WebElement browseByCategorySection;
	
	@FindBy(xpath="//h3[contains(text(),'Art')]/parent::div/parent::div")
	private WebElement artCategory;
	
	@FindBy(xpath="//h3[contains(text(),'Music')]/parent::div/parent::div")
	private WebElement musicCategory;
	
	@FindBy(xpath="//h3[contains(text(),'Domain Names')]/parent::div/parent::div")
	private WebElement domainNamesCategory;
	
	public boolean isArtCategoryVisible() {
		
		waitForElementVisible(artCategory);
		return artCategory.isDisplayed(); 	
	}
	
	public boolean isMusicCategoryVisible() {
		
		waitForElementVisible(musicCategory);
		return musicCategory.isDisplayed(); 	
	}	
	
	public boolean isDomainNamesCategoryVisible() {
		
		waitForElementVisible(domainNamesCategory);
		return domainNamesCategory.isDisplayed(); 	
	}	
	
	@FindBy(id="steps")
	private WebElement howItWorksSection;
	
	@FindBy(xpath="//h3[contains(text(),'Set up your wallet')]/parent::div/parent::div")
	private WebElement setUpYourWalletSection;
	
	@FindBy(xpath="//h3[contains(text(),'Build your collection')]/parent::div/parent::div")
	private WebElement buildYourCollectionSection;
	
	@FindBy(xpath="//h3[contains(text(),'Add your own NFTs')]/parent::div/parent::div")
	private WebElement addyourOwnNFTSection;
	
	@FindBy(xpath="//h3[contains(text(),'List NFTs for sale')]/parent::div/parent::div")
	private WebElement listNFTForSaleSection;
	
	public boolean isSetUpYourWalletSectionVisible() {
		
		waitForElementVisible(setUpYourWalletSection);
		return setUpYourWalletSection.isDisplayed(); 	
	}
	
	public boolean isBuildYourCollectionSectionVisible() {
		
		waitForElementVisible(buildYourCollectionSection);
		return buildYourCollectionSection.isDisplayed(); 	
	}
	
	public boolean isAddyourOwnNFTSectionVisible() {
		
		waitForElementVisible(addyourOwnNFTSection);
		return addyourOwnNFTSection.isDisplayed(); 	
	}
	
	public boolean isListNFTForSaleSectionVisible() {
		
		waitForElementVisible(listNFTForSaleSection);
		return listNFTForSaleSection.isDisplayed(); 	
	}
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement emailInput;
	
	@FindBy(xpath="//button[contains(text(),'Sign up')]")
	private WebElement signUpButton;
	
	@FindBy(xpath="//div[contains(text(),'Thank you, You are in!')]")
	private WebElement confirmSignUp;
	
	public void enterText_Email(String text) {
		waitForElementVisible(emailInput);
		emailInput.sendKeys(text);
	}
	
	public void clickSignUp() {
		waitForElementClickable(signUpButton);
		signUpButton.click();
		
	}
	public boolean isSignUpConfirmed() {
		waitForElementVisible(confirmSignUp);
		return confirmSignUp.isDisplayed();
	}
	
	
	@FindBy(xpath="//a[contains(@href,'twitter')]")
	private WebElement twitterFooterLink;
	
	@FindBy(xpath="//a[contains(@href,'linkedin')]")
	private WebElement linkedInFooterLink;
	
	@FindBy(xpath="//a[contains(@href,'facebook')]")
	private WebElement facebookFooterLink;
	
	public void clickTwitterLink() {
		
		waitForElementClickable(twitterFooterLink);
		twitterFooterLink.click();	
	}
	
	public void clickLinkedInLink() {
		
		waitForElementClickable(linkedInFooterLink);
		linkedInFooterLink.click();	
	}
	
	public void clickFacebookLink() {
		
		waitForElementClickable(facebookFooterLink);
		facebookFooterLink.click();	
	}
	
	public boolean isFAQSectionVisible() {
		
		return faqSection.isDisplayed(); 	
	}

	
	

}
