#include<stdio.h>
main()
{
 int n, i, ct = 0, min = 100, tat, j, k, max = 0;
 float  wt = 0, tt = 0;
 printf("Enter the number of process: ");
 scanf("%d",&n);
 int a[n], b[n], c = n;
 printf("Enter arrival  and burst time of each process: ");
 for(i=0;i<n; i++)
 {
  printf("\nArrival Time for %d process: ",i+1);
  scanf("%d",&a[i]);
  printf("\nburst Time for %d process: ",i+1);
  scanf("%d",&b[i]);
 }
  min = 100;
  for(j=0; j<n; j++)
  {
   if(min > a[j])
   {
    min = a[j];
    printf("\nMin = %d",min);
    k = j;
    printf("\nk = %d",k);
   }
  }
  ct = ct + a[k];
 for(i=0; i<=n ;i++)
 {
  
   min = 100;
  for(j=0; j<n; j++)
  {
   if(min > a[j])
   {
    min = a[j];
    //printf("\nMin = %d",min);
    k = j;
    //printf("\nk = %d",k);
   }
  }
  if(a[k] <= ct)
  {
   ct = ct + b[k];
   //printf("\nCT = %d",ct);
   tat = ct - a[k];
   //printf("\TAT = %d",tat);
   tt = tt + tat;
   //printf("\nTT = %d",tt);
   wt = wt + tat - b[k];
   //printf("\nWT = %d",wt);
   a[k] = 100;
  }
  else 
  {
   ct++;
  } 
 }
 printf("\nAverage turn Around Time: %0.2f\nAverage Waiting Time: %0.2f",tt/n, wt/n);
}
