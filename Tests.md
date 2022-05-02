*For tests 8-18, "in file" refers to UserDetails.txt, while for tests 22-, "in file" refers to CourseDetails.txt

Test 1: Check socket connection

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java. 
  3. User checks for GUI pop-up. 
  4. User checks for successful network connection in Server terminal: "Accepted connection : Socket..."
  5. User checks for successful thread execution in Server terminal: "Accepted thread: Thread[Thread-0,5,main]"

  Expected Result: Connection is successful.
  
  Test Status: Passed.
  
Test 2: Check multi-thread connection
  
  Steps: 
  1. User launches Server.java.
  2. User launches Login.java. 
  3. User checks for GUI pop-up. 
  4. User checks for successful network connection in Server terminal: "Accepted connection : Socket..."
  5. User checks for successful thread execution in Server terminal: "Accepted thread: Thread[Thread-0,5,main]"
  6. User launches another Login.java.   
  7. User checks for a new GUI pop-up.
  8. User checks for successful network connection in Server terminal: "Accepted connection : Socket[same address,...,same localport]"
  9. User checks for successful thread execution in Server terminal: "Accepted thread: Thread[Thread-1,5,main]"

  Expected Result: Multi-client connection is successful.
  
  Test Status: Passed.
  
  
Test 3: Begin user log in

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.

  Expected Result: Application loads log in automatically.

  Test Status: Passed.

Test 4: User log in

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.

  Expected Result: Application verifies the user's username and password and loads their main menu automatically. 
  
  Test Status: Passed.
  
Test 5: Load account settings menu

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Account Settings" button.

  Expected Result: Application loads account settings menu automatically.
  
  Test Status: Passed.
  
Test 6: Load account editing menu

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Account Settings" button.
  11. User selects the "Edit Account" button.

  Expected Result: Application loads account editing menu automatically.
  
  Test Status: Passed.
  
Test 7: Load username editing page

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Account Settings" button.
  11. User selects the "Edit Account" button.
  12. User selects the "Edit Username" button.

  Expected Result: Application loads username editing page automatically.
  
  Test Status: Passed.
  
Test 8: Edit username
  
  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Account Settings" button.
  11. User selects the "Edit Account" button.
  12. User selects the "Edit Username" button.
  13. User selects the new username textbox.
  14. User enters new username via the keyboard.
  15. User selects the "Submit" button.

  Expected Result: Application changes account username to entered username in file* and loads main menu automatically.
  
  Test Status: Passed.
  
Test 9: Load password editing page

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Account Settings" button.
  11. User selects the "Edit Account" button.
  12. User selects the "Edit Password" button.

  Expected Result: Application loads password editing page automatically.
  
  Test Status: Passed.
  
Test 10: Edit password
  
  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Account Settings" button.
  11. User selects the "Edit Account" button.
  12. User selects the "Edit Password" button.
  13. User selects the new password textbox.
  14. User enters new password via the keyboard.
  15. User selects the "Submit" button.

  Expected Result: Application changes account password to entered password in file* and loads main menu automatically.
  
  Test Status: Passed.
  
Test 11: Delete account
  
  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Account Settings" button.
  11. User selects the "Delete Account" button.
  12. User selects the "Yes" button from the pop-up window.

  Expected Result: Pop-up window disappears. Application deletes account in file* and loads main menu automatically.
  
  Test Status: Passed.
  
Test 12: Delete account failure
  
  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Account Settings" button.
  11. User selects the "Delete Account" button.
  12. User selects the "No" button from the pop-up window.

  Expected Result: Pop-up window disappears.
  
  Test Status: Passed.
  
Test 13: Main menu option

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Account Settings" button.
  11. User selects the "Options" menu bar item.
  12. User selects the "Main Menu" menu item from dropdown menu.

  Expected Result: Application loads main menu automatically.

  Test Status: Passed.

Test 14: Log out option

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Options" menu bar item.
  11. User selects the "Log Out" menu item from dropdown menu.

  Expected Result: Application loads welcome page automatically.

  Test Status: Passed.

Test 15: Begin user account creation

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Create New Account" button.

  Expected Result: Application loads account creation page automatically.

  Test Status: Passed.

Test 16: Create new account

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Create New Account" button.
  4. User selects the username textbox.
  5. User enters new username via keyboard.
  6. User selects the password textbox.
  7. User enters password via the keyboard.
  8. User selects whether they are a teacher or student from dropdown menu.
  9. User selects the "Submit" button.

  Expected Result: Application adds new user account in file* if username is unique and loads their main menu automatically.
  
  Test Status: Passed.
  
Test 17: Load create & edit menu

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.

  Expected Result: Application loads create & edit menu automatically.
  
  Test Status: Passed.
  
Test 18: Load course selection page

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.

  Expected Result: Application loads course selection page automatically.
  
  Test Status: Passed.
  
Test 19: Choose course to edit

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.

  Expected Result: Application loads quiz operations menu automatically.
  
  Test Status: Passed.
  
Test 20: Load quiz selection page

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.

  Expected Result: Application loads quiz selection page automatically.
  
  Test Status: Passed.
  
Test 21: Choose quiz to edit

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.
  15. User selects quiz to edit from dropdown menu.
  16. User selects the "Submit" button.

  Expected Result: Application loads quiz editing menu automatically.
  
  Test Status: Passed.
  
Test 22: Change quiz name

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.
  15. User selects quiz to edit from dropdown menu.
  16. User selects the "Submit" button.
  17. User selects the "Edit Quiz Name" button.
  18. User selects new quiz name textbox.
  19. User enters new name of quiz via keyboard.
  20. User selects the "Submit" button.

  Expected Result: Application changes quiz name in file* and loads quiz editing menu automatically.
  
  Test Status: Passed.
  
Test 23: Add question

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.
  15. User selects quiz to edit from dropdown menu.
  16. User selects the "Submit" button.
  17. User selects the "Add Question" button.
  18. User selects the new prompt textbox. 
  19. User enters new question prompt via keyboard.
  20. User selects question weight textbox.
  21. User enters new weight as integer via keyboard.
  22. User selects the "Submit" button.
  23. User selects the new answer choice textbox.
  24. User enters new answer choice viz keyboard.
  25. User selects the "Add Another Answer Choice" button.
  26. User selects the new answer choice textbox.
  27. User enters new answer choice via keyboard.
  28. User selects the "Submit Answer Choice" button.
  29. User selects the correct response from the dropdown menu.
  30. User checks the "Randomize question" checkbox if desired.
  31. User selects the "Add Another Question" button.
  32. Repeat steps 18-30.
  33. User selects the "Submit Question" button.

  Expected Result: Application adds both newly created questions to previously selected quiz in file* and loads main teacher menu automatically.
  
  Test Status: Passed.
  
Test 24: Remove quiz question

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.
  15. User selects quiz to edit from dropdown menu.
  16. User selects the "Submit" button.
  17. User selects the "Remove Question" button.
  18. User selects which question they would like to remove from dropdown menu.
  19. User selects the "Submit" button.

  Expected Result: Application removes specified question from quiz in file* and loads main teacher menu automatically.
  
  Test Status: Passed.
  
Test 25: Change question prompt

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.
  15. User selects quiz to edit from dropdown menu.
  16. User selects the "Submit" button.
  17. User selects the "Edit Question" button.
  18. User selects which question prompt they would like to edit from dropdown menu.
  19. User selects the "Submit" button.
  20. User selects the new prompt textbox.
  21. User enters new question prompt via keyboard.
  22. User selects the "Submit" button.

  Expected Result: Application changes question prompt in file* and loads quiz editing menu automatically.
  
  Test Status: Passed.

Test 26: Change question weight

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.
  15. User selects quiz to edit from dropdown menu.
  16. User selects the "Submit" button.
  17. User selects the "Edit Weight" button.
  18. User selects the prompt of the question they would like to edit from dropdown menu.
  19. User selects the "Submit" button.
  20. User selects the new weight textbox.
  21. User enters new question weight as integer via keyboard.
  22. User selects the "Submit" button.

  Expected Result: Application changes question weight in file* and loads quiz editing menu automatically.
  
  Test Status: Passed.
  
Test 27: Change question answer choice

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.
  15. User selects quiz to edit from dropdown menu.
  16. User selects the "Submit" button.
  17. User selects the "Edit Question Answer" button.
  18. User selects the prompt of the question they would like to edit from dropdown menu.
  19. User selects the "Submit" button.
  20. User selects which answer choice they would like to edit from dropdown menu.
  21. User selects the "Select Response to Edit" button. 
  22. User selects the new response textbox.
  23. User enters new question response via keyboard.
  24. User selects the "Submit" button.

  Expected Result: Application changes question response in file* and loads quiz editing menu automatically.
  
  Test Status: Passed.
  
Test 28: Change correct question response.

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.
  15. User selects quiz to edit from dropdown menu.
  16. User selects the "Submit" button.
  17. User selects the "Change Correct Answer" button.
  18. User selects the prompt of the question they would like to edit from dropdown menu.
  19. User selects the "Submit" button.
  20. User selects the answer the would like to set as correct from dropdown menu.
  21. User selects the "Select New Correct Answer" button.

  Expected Result: Application changes response labeled Correct_Answer in file* and loads quiz editing menu automatically.
  
  Test Status: Passed.
  
Test 29: Randomize question order

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Edit Quiz" button.
  15. User selects quiz to edit from dropdown menu.
  16. User selects the "Submit" button.
  17. User selects the "Randomize Quiz" button.
  18. User selects the "Ok" button from the pop-up window.

  Expected Result: Application closes displayed pop-up window and randomly rearranges question order in file*.
  
  Test Status: Passed.
  
Test 30: Load quiz creation menu

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Create a Quiz" button.

  Expected Result: Application loads quiz creation menu automatically.
  
  Test Status: Passed.
  
Test 31: Create new quiz manually

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Create a Quiz" button.
  15. User selects the "Create a Quiz" button.
  16. User selects the quiz name textbox.
  17. User enters new quiz name via keyboard.
  18. User selects the "Submit & Add Questions" button.
  19. User selects the new prompt textbox. 
  20. User enters new question prompt via keyboard.
  21. User selects question weight textbox.
  22. User enters new weight as integer via keyboard.
  23. User selects the "Submit" button.
  24. User selects the new answer choice textbox.
  25. User enters new answer choice viz keyboard.
  26. User selects the "Add Another Answer Choice" button.
  27. User selects the new answer choice textbox.
  28. User enters new answer choice via keyboard.
  29. User selects the "Submit Answer Choice" button.
  30. User selects the correct response from the dropdown menu.
  31. User checks the "Randomize question" checkbox if desired.
  32. User selects the "Add Another Question" button.
  33. Repeat steps 18-30.
  34. User selects the "Submit Question" button.

  Expected Result: Application adds newly created quiz and questions to file* and loads main teacher menu automatically.
  
  Test Status: Passed.
  
Test 32: Create new quiz from file name

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Create a Quiz" button.
  15. User selects the "Upload a Quiz File" button.
  16. User selects the quiz file name textbox.
  17. User enters new quiz file name via keyboard.
  18. User selects the "Submit" button.

  Expected Result: Application creates new quiz from file if file is in correct format and loads main teacher menu automatically.
  
  Test Status: Passed.
  
Test 33: Delete quiz

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Change Quizzes" button.
  12. User selects course to edit from dropdown menu.
  13. User selects the "Submit" button.
  14. User selects the "Delete Quiz" button.
  15. User selects quiz to delete from dropdown menu.
  16. User selects the "Delete" button.
  17. User selects the "Yes" button from the pop-up window.

  Expected Result: Pop-up window disappears. Application deletes specified quiz from file* and loads main teacher menu automatically.
  
  Test Status: Passed.
  
Test 34: Create new course

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Create A Course" button.
  12. User selects the course name textbox.
  13. User enters new course name via keyboard.
  14. User selects the "Add Quiz" button.

  Expected Result: Application adds newly created course to file* and loads quiz creation menu automatically.
  
  Test Status: Passed.
  
Test 35: Delete course

  Steps: 
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters teacher username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects teacher from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Create and Edit" button.
  11. User selects the "Delete A Course" button.
  12. User selects course to delete from dropdown menu.
  13. User selects the "Delete" button.
  14. User selects the "Yes" button from the pop-up window.

  Expected Result: Pop-up window disappears. Application deletes specified course from file* and loads main teacher menu automatically.
  
  Test Status: Passed.
  
Test 36: Load course selection page

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters student username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Take Quiz" button.

  Expected Result: Application loads course selection page automatically.
  
  Test Status: Passed.
  
Test 37: Load quiz selection page

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters student username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Take Quiz" button.
  11. User selects a course from the dropdown menu.
  12. User selects the "Submit" button.

  Expected Result: Application loads quiz selection page automatically.
  
  Test Status: Passed.
  
Test 38: Load take quiz panel

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters student username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Take Quiz" button.
  11. User selects a course from the dropdown menu.
  12. User selects the "Submit" button.
  13. User selects a quiz from the dropdown menu.
  14. User selects the "Submit" button.

  Expected Result: Application loads page with quiz questions automatically.
  
  Test Status: Passed.
  
Test 39: Load YES/NO submission prompt

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters student username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Take Quiz" button.
  11. User selects a course from the dropdown menu.
  12. User selects the "Submit" button.
  13. User selects a quiz from the dropdown menu.
  14. User selects the "Submit" button.
  15. User answers all the questions using the dropdown menu.
  16. User selects "Submit" button.

  Expected Result: Application loads a YES or NO submission prompt.
  
  Test Status: Passed.
  
Test 40: Submission Yes choice

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters student username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Take Quiz" button.
  11. User selects a course from the dropdown menu.
  12. User selects the "Submit" button.
  13. User selects a quiz from the dropdown menu.
  14. User selects the "Submit" button.
  15. User answers all the questions using the dropdown menu.
  16. User selects "Submit" button.
  17. User selects "Yes" button in the submission prompt

  Expected Result: Application loads main student menu and writes the submission.
  
  Test Status: Passed.
  
Test 41: Submission NO choice

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters student username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Take Quiz" button.
  11. User selects a course from the dropdown menu.
  12. User selects the "Submit" button.
  13. User selects a quiz from the dropdown menu.
  14. User selects the "Submit" button.
  15. User answers all the questions using the dropdown menu.
  16. User selects "Submit" button.
  17. User selects "No" button in the submission prompt.

  Expected Result: Application loads prompt asking which question does the user want to change.
  
  Test Status: Passed.
  
Test 42: Changing question answer

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters student username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Take Quiz" button.
  11. User selects a course from the dropdown menu.
  12. User selects the "Submit" button.
  13. User selects a quiz from the dropdown menu.
  14. User selects the "Submit" button.
  15. User answers all the questions using the dropdown menu.
  16. User selects "Submit" button.
  17. User selects "No" button in the submission prompt.
  18. User selects question number to change from a dropdown menu.
  19. User selects "Submit" button.

  Expected Result: Application loads prompt re-asking the question.
  
  Test Status: Passed.
  
Test 43: Re-asking the question prompt

  Steps:
  1. User launches Server.java.
  2. User launches Login.java.
  3. User selects the "Log in" button.
  4. User selects the username textbox.
  5. User enters student username via the keyboard.
  6. User selects the password textbox.
  7. Use enters password via the keyboard.
  8. User selects student from dropdown menu.
  9. User selects the "Submit" button.
  10. User selects the "Take Quiz" button.
  11. User selects a course from the dropdown menu.
  12. User selects the "Submit" button.
  13. User selects a quiz from the dropdown menu.
  14. User selects the "Submit" button.
  15. User answers all the questions using the dropdown menu.
  16. User selects "Submit" button.
  17. User selects "No" button in the submission prompt.
  18. User selects question number to change from a dropdown menu.
  19. User selects "Submit" button.
  20. User selects their new answer to the question from a dropdown menu.
  21. User selects "Submit" button.

  Expected Result: Application loads main student menu and records the submission.
  
  Test Status: Passed.
