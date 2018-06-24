/*
Date 2017 10 14
Source GeeksForGeeks
*/


/*Given two binary arrays arr1[] and array2[] of same size n.Find length of the longest
common span(i,j) where j>=i such that arr1[i]+arr1[i+1]...+arr1[j]=arr2[i]+arr2[i+1]+...
+arr2[j].
Expected time complexity is O(n)
Examples；
Input: arr1[]={0,1,0,0,0,0}
       qrr2[]={1,0,1,0,0,1}
Output: 4
The longest span with same sum is from index 1 to 4
Input: arr1[]={0,1,0,1,1,1,1}
       qrr2[]={1,1,1,1,1,0,1}
Output: 6
The longest span with same sum is from index 1 to 6
Input: arr1[]={0,0,0}
       qrr2[]={1,1,1}
Output: 0
*/

/*     Method 1 Time complexity： O(n^2)  Auxiliary Space: O(1)
one by one by consider same subarrays of both arrays. For all subarrays, compute sums
and if sums are same and current length is more than max length,then update max length.
Blow is C++ implementation of simple approach
*/

//A simple C++ program to find longest common subarray of two binary arrays with same sum
#include<stdio.h>
using namespace std;

//Return length of the longest common subarray with same sum
int longestCommonSum(bool arr1[], bool arr2[], int n){
  //initialize result
  int maxLen = 0;
  //one by one pick all possible starting points of subarrays
  for (int i = 0; i < n; i++) {
    //initialize sums of current subarrays
    int sum1 = 0, sum2 = 0;

    //consider all points for starting with arr[i]
    for(int j=i;j<n;j++){
      //update sums
      sum1+=arr1[j];
      sum2+=arr2[j];
      //if sums are same and current length is more than maxLen, update maxLen
      if (sum1 == sum2){
        int len=j-i+1;
        //maxLen=max(len,maxLen);
        if (len > maxLen){
          maxLen=len;
        }
      }
    }
    return maxLen;
  }
}
