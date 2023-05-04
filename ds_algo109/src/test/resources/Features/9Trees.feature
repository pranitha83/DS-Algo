@Tree
Feature: Evaluate Tree module

  Scenario: user is able to navigate to "Tree" Page
    Given user is able to click on dropdown
    When user click Tree item from the drop down menu
    Then user should be navigate to the "Tree" Page

  Scenario Outline: user is able to navigate to "Overview of Trees" page
    Given user is able to click on overview of trees
    When user clicks "Try Here" button and navigate to try editor page for valid code test
       When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: User is able to navigate to tryeditor page and run invalid python code
    Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario Outline: The user is able to run code in tryEditor for Terminologies page
    Given The user clicks on the Terminologies button
    When user clicks "Try Here" button and navigate to try editor page
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Terminologies page
    Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario Outline: The user is able to run code in tryEditor for Types of Trees page
    Given The user clicks on the Types of Trees button
   When  user clicks "Try Here" button and navigate to try editor page
     When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Types of Trees page
  Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  

  Scenario Outline: The user is able to run code in tryEditor for Tree Traversals Page
    Given The user clicks on the Tree Traversals button
    When  user clicks "Try Here" button and navigate to try editor page
     When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Tree Traversals Page
   Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario Outline: The user is able to run code in tryEditor for Traversals-Illustration Page
    Given The user clicks on the Traversal illustration button
    When  user clicks "Try Here" button and navigate to try editor page
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Traversals-Illustration Page
      Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  
  Scenario Outline: The user is able to run code in tryEditor for Binary Trees Page
    Given The user clicks on the binary trees button
     When  user clicks "Try Here" button and navigate to try editor page
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Binary Trees Page
    Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  

  Scenario Outline: The user is able to run code in tryEditor for Types of Binary Trees Page
    Given The user clicks on the Types of binary trees
     When  user clicks "Try Here" button and navigate to try editor page
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Types of Binary Trees Page
    Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  

  Scenario Outline: The user is able to run code in tryEditor for Implementation in Python Page
    Given The user clicks on the Implementation in Python button
     When  user clicks "Try Here" button and navigate to try editor page
   When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Implementation in Python Page
    Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  

  Scenario Outline: The user is able to run code in tryEditor for Binary Tree Traversals page
    Given The user clicks on the binary tree traversals button for btt
     When  user clicks "Try Here" button and navigate to try editor page
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Binary Tree Traversals page
    Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  

  Scenario Outline: The user is able to run code in tryEditor for Implementation of Binary Trees Page
    Given The user clicks on the Implementation of Binary Trees button for ibt
     When  user clicks "Try Here" button and navigate to try editor page
     When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Implementation of Binary Trees Page
    Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario Outline: The user is able to run code in tryEditor for Applications of Binary trees Page
    Given The user clicks on the Applications of Binary Trees button for abt
     When  user clicks "Try Here" button and navigate to try editor page
     When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Applications of Binary trees Page
     Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

 

  Scenario Outline: The user is able to run code in tryEditor for Binary Search Trees Page
    Given The user clicks on the Binary Search Trees button for bst
     When  user clicks "Try Here" button and navigate to try editor page
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Binary Search Trees Page
     Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  

  Scenario Outline: The user is able to run code in tryEditor for Implementation Of BST Page
    Given The user clicks on the Implementation of BST button for ibst
     When  user clicks "Try Here" button and navigate to try editor page
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run result
    

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Implementation Of BST Page
    Given user clicks "Try Here" button and navigate to try editor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user validating "Practice Questions" page
   
   
    Given The user clicks on the Practice Questions in Overview of Trees
    Then The user should be directed to Practice Questions of tree page Page
