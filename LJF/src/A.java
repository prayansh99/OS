// LJF

import java.util.Scanner;

public class A
{
    public static void main(String[] args) {
        int j, i, f=0, ct = 0, tat, g = 0;
        float tt = 0, wt = 0;
        System.out.println("Enter the number of processes");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int [n];
        int b[] = new int [n];
        int ar[] = new int [n];
        for(i=0; i<n; i++)
        {
            System.out.println("Enter the Arrival time for processes "+(i+1));
            a[i] = s.nextInt();
            System.out.println("Enter the Burst time for processes "+(i+1));
            b[i] = s.nextInt();
        }
        while(f<n)
        {
            int max = 0, k =0;
            for(j=0; j<n; j++)
            {
                if(a[j] <= ct)
                {
                    ar[k++] = j;
                }
            }
            if(k == 0)
            {
                ct++;
            }
            else{
                for(j=0; j<k; j++)
                {
                    if(max < b[ar[j]])
                    {
                        max = b[ar[j]];
                        g = ar[j];
                    }
                }
                ct = ct + b[g];
                //System.out.println("CT = "+ct);
                tat = ct - a[g];
                //System.out.println("TAT = "+tat);
                tt = tt + tat;
                //System.out.println("TT = "+tt);
                wt = wt + tat - b[g];
                //System.out.println("WT = "+wt);
                a[g] = 100;
                b[g] = 100;
                f++;
            }
        }
        System.out.println("Average TAT: "+(tt/n) + "\n"+"Average WT: "+(wt/n));
    }
}
