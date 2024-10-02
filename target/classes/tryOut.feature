
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

 
  Scenario Outline: Launch Amazon and perform
    Given I Launch "<application>" application
    #When I check for the <value> in step
    #Then I verify the <status> in step

    Examples: 
      | application  | 
      | Amazon |   
       
