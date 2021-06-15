## Task 1

## Exploratory testing of Monefy application

1. which area of the app or testing would you explore first and why?
 =>  Expense.
     Exepense management is a heart or core functionality of this application.Generally, Expense/Spendings is what people mostly interested in.

2. What kind of risks you need to mitigate for this type of application?
   
    Risk 1: Insufficient Regression time and Incomplete validation
 => This risk can be resolved by splitting the development into interations and testing the same in individual sprints
    
    
    Risk 2: Some of the modules are not user friendly
 => It can be reolved by getting continuous feedback from stakeholders and frequent demonstrations of new functionality
 
 
## Exploratory Charter 1:

## Target:  
Analyze Monefy's Add expense functionality and report on areas of potential risk
## Resources: 
- Visit to Monefy website
- Searched other budget management applications to get a better idea on functionality

## Time Duration: 45 mins

## Information: 
I have opened the Monefy application and clicked on 'Expense' tab

## A. New expense
Navigated to 'New expense' screen

Add expense for current date.

selected Cash as the payment option, entered 'amount'.Amount field accepts 9 digit value and not letting user to enter 0 amount, its mandatory field.


'Note' is the optional input field.

After entering amount, i see 'Choose Category' button.I have to Choose Category to save my transaction.

## B. choose Category

After clicking on 'Choose Category' button, category options displayed on the screen related to expense.

'Save' option is not available, after choosing category it gets automatically saved and navigates to Home page of application.

## C. Monefy pro screen
To add new category,I need to click on 'Add' button which took me 'Monefy pro' screen where multiple premium options are available.
I see 'Buy 2.99' button, return back to 'Add expense' screen.

## D.Home page
Total expense amount is showing on 'pie chart' present on Home page. 'Balance' is visible below the chart.

Balance is showing in red and in minus figure, if  income is 0 or less than expense amount.Percenage of expense is visible along with the category.

Menu buttons provided to see the overall details of transaction with the date, balance and lidt of transactions.also transaction can be sorted in descending order based on amount.

## E. Edit expense Screen
Clciking on any specific transaction,'Edit expense' screen displays. fields like amount,note are present. I can change the catgory on clcking 'Change Category' button present at the bottom, it gets added into the list with updated changes.

## F. Delete button
Delete button is visible at the top right corner of Edit expense' screen. 
Can delete 1 or more records by long pressing on the record, displays message with count of deleted reocords.

## G. Monefy pro screen  -Refer point 'C' 

On the same screen, left and right arrow button is visible after clicking, it navigates to 
'Monefy pro' screen where multiple premium features are listed. 

## Bugs:

A_1 -  Number pad does not show 'clear (c)' button on it to erase the amount entered by me.
       on entering long digit amount, i have to keep clicking on 'X' button to clear the complete amount.

B_2 -  There are no subcategories provided Ex.Electricity bills,Gas etc.
       Categories does not classified into proper sections ex. Taxi and Car can be classified as sub-categories under Transport, but the app shows both as in       different categories.

C_3 - observed that its not showing the currency which i have set ex. expected is INR but actual is Euro.

C_4 - I do not see any option for cancelling the transaction, app shows a message including 'Cancel' button to cancel or clear record which is not user friendly.

E_5 - How could the user delete and edit from same screen, ideally delete button should be present where there is a list of records.
      After clicking on Delete, it does not ask for the confirm delete or message, it straight away deletes the record.

G_6 - The order of options on 'Monefy pro' screen is not in synch or same for all the navigations.

Expense and Income button user interface keeps changing, intially it shows in text (income,expense) and then symbols like '+' and '-'.

-----------------------------------------------------------------------------------------------------------------------

## Exploratory Charter 2

## Target:  
Analyze Monefy's Add income functionality and report on areas of potential risk

## Resources: 
Visit to Monefy website
Searched other budget management applications to get a better idea on functionality

## Time Duration: 25 mins 

## Information: 

I have opened the Monefy application and clicked on 'Income' tab.

## A. New Income

Navigated to 'New income' screen

Add income on current date

Selected Cash as the payment option, entered 'amount'.Amount field accepts 9 digit value and not letting user to enter 0 amount, its mandatory field.

'Note' is the optional input field.

## B. choose Category

After clicking on 'Choose Category' button, category options displayed on the screen related to income.

## C. Monefy pro screen

To add new category,I need to click on 'Add' button which took me 'Monefy pro' screen where multiple premium options are available.

I see 'Buy 2.99' button and return back to add income screen

'Save' option is not available, after choosing category it gets automatically saved and navigates to Home page of application.

## D.Home page
Total income amount is showing on 'pie chart' present on Home page. 'Balance' is visible below the chart.

Balance field indicates Green when income is more than expense.

Menu buttons provided to see the overall details of transaction with the date, balance and list of transactions.also transaction can be sorted in descending order based on amount.

## E. Delete button
Delete button is visible at the top right corner list of records. 
Can delete 1 or more records by long pressing on the record, displays message with count of deleted reocords.

## Bugs
E_1 -while deleting multiple records from the list, heading of the page gets invisible

--------------------------------------------------------------------------------------------------------------------------------
## Exploratory charter 3:
## Target:  
Analyze Monefy's Export to file functionality and report on areas of potential risk

## Resources: 
- Visit to Monefy website
- Searched other budget management applications to get a better idea on functionality

## Time Duration: 20 mins

## Information: 
I have opened the Monefy application and added some records for income and expense.
Click on the menu option from screen, and select 'Settings'

## A. Settings
Under settings tab, select 'Export to file' option
there aee diffrent select options are visible like character set,Decimal seperator and Delimiter character etc.
select required options and export file but file could not downloaded.

## Bugs:
A_1 - Export to file option does not work as expected,file could not downloaded.

A_2 - Options given under export to file section are not user friendly, non-technical user don't understand what is character set,Decimal seperator and Delimiter character.









