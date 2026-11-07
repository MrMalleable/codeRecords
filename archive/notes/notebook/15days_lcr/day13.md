**string permutation with upcase and lowcase**

> Give a string, which only contains a-z. List all the permutation of upcase and lowcase.
  For example, str = "ab",  the output should be
  "ab", "aB", "Ab", "AB"
  for str = "abc", the output should be
  "abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC"

## 思路

首先,肯定可以用递归来做，每一个节点有大小两种可能。代码可以简单的写成：

```
1: void ListPermutation(string sample, int depth, string& result)
2: {
3:   if(depth == sample.size())
4:   {
5:      prinf("%s\r\n", result.c_str());
6:      return;
7:     }
8:     
9:     // process low-case char
10:     result.push_back(sample[depth]);
11:     ListPermutation(sample, depth+1, result);
12:     result.pop_back();
13:     
14:     //process up-case char
15:     result.push_back(sample[depth]-32);
16:     ListPermutation(sample, depth+1, result);
17:     result.pop_back();
18: }
```

但是，如果考虑空间复杂度的话，这是个指数级的实现。如果字符串有几千行或者几万行，内存就不得了了。

如果换个思路想想的话，其实这个题有简单的解法。因为，大写和小写只有两种变化，其实就是0和1的变化。简单的说，如果字符串长L，那么遍历区间[0,2^L-1]，对于任意i，将其转换为长度为L的二进制表示，然后根据每一位二进制是0还是1，来决定输出大写还是小写。实现如下：

```
1: void ListPermutation(string sample)
2: {
3:     int L = sample.size();
4:     long end = pow(2, L) -1;
5:     for(int i =0; i< end; i++)
6:     {
7:         // Convert Dec to Binary, 
8:         // return a string to represent binary data with size L
9:         string binaryRep = ConvertDecToBinany(i, L);
10:         
11:         string output;
12:         for(int j=0; j<L; j++)
13:         {
14:             if(binaryRep[j] == '0') //low case
15:             {
16:                 output.push_back(sample[j]);
17:             }
18:             else
19:             {
20:                 output.push_back(sample[j]-32);
21:             }        
22:         }
23:         printf("%s\r\n", output.c_str());
24:     }
25: }
```

这样的话，整体思路就更清晰，而且内存使用是O(L)。

---

