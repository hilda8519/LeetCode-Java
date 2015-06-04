package String;

//solution 1  brute force(time o((n-m+1)*m)=o(n*m);//
Public int strStr(String haystack, String needle) {
  if(haystack == null || needle == null || needle.length( ) == 0)
     return 0;
  if(needle.length( ) > haystack.length( ) )
     return -1;
  for( int i = 0; i <= haystack.length( )-needle.length( );i++ ) {
       boolean successFlag = true;
       for (int j = 0; j < needle.length( ); j++)
       {
            if(haystack.charAt(i+j) != needle.charAt(j))
            {
               successFlag = false;
               break;
            }
       }
        if(successFlag)
           return i;
   }
  return -1;    
}

//solution2 rolling hash time o(m+n-m)=o(n)//
public String strStr(String haystack, String needle) {
  //if haystack == null or 0//
  if(haystack == null || needle == null)
     return null;
  if(haystack.length( ) == 0) {
     return needle.length( ) == 0?" ": null;
   }   
   
   if(needle.length( ) == 0)
      return haystack;
   
   if(haystack.length( ) < needle.length( ))
      return null;    
    //define hashBash//  
    int base = 29;
    long patterHash = 0;
    long tempBase = 1;
  
    for(int i = needle.length( )-1; i > 0; i--) {
        hayHash += (int) haystack.charAt(i)*tempBase;
        tempBase *= base;
    }    
    tempBase /= base;
    
    if(hayHash == patterHash) {
       return haystack;
    }
    
    for(int i = needle.length( ); i<hayStack.length( ); i++) {
        hayHash = (hayHash - (int)haystack.charAt(i - needle.length( ))*tempBase)*base + (int)haystack.charAt(i);
        if(hayHash == patterHash) {
           return haystack.substring(i - needle.length( ) + 1);
     }
    }
    return null;
}



//Solution 3 KMP algorithm//
public int strStr(String haystack, String needle) {
  if(haystack == null || needle == null)
     return 0;
     
  int h = haystack.length( );
  int n = needle.length( );
  
  if(n > h)
     return -1;
     
  if(n == 0)
    return 0;
 
  int[ ] next = getNext(needle);
  int i = 0;
 
   while(i <= h -n) {
         int success = 1;
         for (int j = 0; j < n; j++) { 
              if(needle.charAt(0) != haystack.charAt(i)) {
                 success = 0;
                 i++;
                 break;
              }
              else if(needle.charAt(j) != haystack.charAt(i + j)) {
                      success = 0;
                      i = i + j -next[j -1];
                      break;
              }
          }
          
          if(success == 1)
             return i;
   }
   return -1;      
  }   
  
//KMP process        
public int[ ] getNext(String needle) {
  int[ ] next = new int[needle.length( )];
  next[0] = 0;

  for(int i = 1; i < needle.length( ); i++) {
      int index = next[i - 1];
      while(index > 0 && needle.charAt(index) != needle.charAt(i)) {
            index = next[index -1];
  }
  
  if(needle.charAt(index) == needle.charAt(i)) {
     next[i] = next[i - 1] + 1;
  } else {
          next[i] = 0;
}
      return next;

}  

}        
      
      
}