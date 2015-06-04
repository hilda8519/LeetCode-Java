package String;

//Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric
characters and ignoring cases.
For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is 
awesome" is not.//

//Brute force(time o(n^2), space o(n))//
Public class Palidrome{
   public boolean isPalindrome(String s) {
      if(s == null) return false;
      if(s.length( ) < 2) return true;

      char[ ] charArray = s.toCharArray( );
      int len = s.length( );

      int i = 0;
      int j = len-1;
      //begin to compare char i & char j
      while(i < j) {
      char left, right;
      // from the beginning to search//
          while(i<len-1 && !isAlpha(left) && !isNum(left)) {
                i++;  
                left = charArray[i]; 
          }
     // from the last to search//
           while(j > 0 && !isAlpha(right) && !isNum(right)) {
                 j--;
                 right = charArray[j];
          }
          //if char i meets char j, stop//
          if( i >= j)
              break;
              
          left = charArray[i];
          right = charArray[j];

          if(!isSame(left, right)) { //if left is not equal to right//
             return false;
          }

          i++;
          j--;

       }
          return true;
   }

     public boolean isAlpha(char a) {
         if((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
            return true;
         }
         else{
              return false;
         }
     }
     
     public boolean isNum(char a) {
         if(a >= '0' && a<= '9') {
            return true;
         } 
         else{
            return false;
         }
     }
     
     //judge char a = char b
     public boolean isSame(char a, char b) {
         if(isNum(a) && isNum(b)) {
            return a == b;
         }
         else if(Character.toLowerCase(a) == Character.toLowerCase(b)){
              return true;
         }
         else{
              return false;
         }
     }
}

//solution 2 using stack to push,pop time  o(1), space o(n)//
public boolean isPalindrome(String s) {
  s = s.replaceAll("[^a-z A-z 0-9]", " ").toLoweCase( );
 
   int len = s.length( );
   // if len < 2, means is 0 or 1, must be parlindrome//
   if(len < 2)
      return true;   
   //Using stack to push and pop,LIFO last in first out//
   Stack<Character> stack = new Stack<Character>( );
   
   int index = 0;
   while(index < len/2) {
         stack.push(s.charAt(index));
         index++;
   }

   if(len % 2 == 1)
      index++;
    //compare index and temp pop from stack
  while(index < len ) {
        if(stack.empty( ))
           return false;
           
           char temp = stack.pop( );
           if(s.charAt(index) != temp)
              return false;
           else
              index++;
  }
  return true;   
}


//two points, one from the beginning and one from the tails. 
Time o(n), space o1(1)//
Public boolean isPalindrome(String s) {
  //define two pointers, i and j//
  int i = 0, j = s.length( )-1;
  //compare i and j//
  while(i < j) {
     while(i < j && !Character.isLetterOrDigit(s.charAt(i)))
        i++;
    while(i < j && !Character.isLetterOrDigit(s.charAt(j)))
        j++;     
    if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
       return false;
    }
     i++;
     j--;
 }
     return true;
}
