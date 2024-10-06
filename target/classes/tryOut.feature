
Feature: Title of your feature
  I want to use this template for my feature file

  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes

 @regression
  Scenario Outline: Launch Amazon and perform
    Given I Launch "<application>" application
    When I create and pass DataTable data
    | Name | ID | Age |
    | Prashanth | 1177 | 24 |
    | Vangapelli | 1188 | 26 |

    Examples: 
      | application  | 
      | Amazon |   
      
    @sanity  
	  Scenario Outline: Launch Amazon and perform
	  Given I Launch "<application>" application
	  When I create and pass DataTable data
	  | Name | ID | Age |
	  | Prashanth | 1177 | 24 |
	  | Vangapelli | 1188 | 26 |
	
	  Examples: 
	    | application  | 
	    | Amazon |  
       
