
```
#include<stdio.h>
int alien(int n);
void intTobit(int n);

int alien(int n){
  int c;
  for(c=0;n;c++){
    intTobit(n);
    n&=n-1;
  }
  intTobit(n);
  return c;
}
//把整数转化为二进制 
void intTobit(int n){
   char s[32];
   int i=0,rem;
   do{
     rem=n%2;
     n=n/2;
     s[i]=rem;
     i++;
   }while(n!=0);
   while(i>0){
     printf("%d",s[--i]);
   }
   printf("\n");
}

int main(){									  printf("%d\n",alien(1024*1024*1024-1024*1024-1024-1));
   return 0;
}

```
---
2017/10/27: just for shell test!
