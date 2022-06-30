
Feature: Videos in youtube

Scenario Outline: Play a video in youtube
  
  Given I navigate to youtube
	And I search for "<videotitle>" 
	When I click the video
	Then The video should be played
	
	Examples:
	| videotitle |
	| Cute baby animals Videos |
	| Cute cats |
	| Doggies |
	| selenium cucumber |
	

      
