import java.util.Scanner;

public class D
{
    public static void main(String[] args) {
        int j, i, ct = 0, fd = 0, f = 0, k, sum = 0;
        float wt = 0;
        System.out.println("Enter the number of processes");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int [n];
        int b[] = new int [n];
        int ar[] = new int [n];
        int p[] = new int [n];
        int tat[] = new int [n];
        int br[] = new int [n];
        f = n;
        for(i=0; i<n; i++)
        {
            System.out.println("Enter the Arrival time for processes "+(i+1));
            a[i] = s.nextInt();
            System.out.println("Enter the Burst time for processes "+(i+1));
            b[i] = s.nextInt();
            System.out.println("Enter the Priority for processes "+(i+1));
            p[i] = s.nextInt();
        }
        for(i=0;i<n;i++)
        {
            br[i] = b[i];
        }
        System.out.println("Which value you want to give highest priority:\n1. Highest value\n2. Lowest Value");
        int c = s.nextInt();
        switch(c)
        {
            case 1: {
                while (f>= 1) {

                    k = 0;
                    for (j = 0; j < n; j++) {
                        if (a[j] <= ct) {
                            ar[k++] = j;
                        }
                    }
                    System.out.println("\nK: "+k);
                    if (k == 0) {
                        ct++;
                    } else {
                        int max = 0;
                        for (j = 0; j < k; j++) {
                            if (max < p[ar[j]]) {
                                max = p[ar[j]];
                                System.out.println("MAX = "+max);
                                fd = j;
                            }
                        }
                        System.out.println("G = "+fd);
                        b[ar[fd]]--;
                        System.out.println("\nB: "+b[ar[fd]]);
                        ct++;
                        System.out.println("\nCT: "+ct);

                        if(b[ar[fd]] == 0)
                        {
                            tat[ar[fd]] = ct - a[ar[fd]];
                            System.out.println("\nTAT: "+tat[ar[fd]]);
                            f--;
                            System.out.println("\nF: "+f);
                            wt = wt + tat[ar[fd]] - br[ar[fd]];
                            System.out.println("\nWT: "+wt);
                            a[ar[fd]] = 100;
                            p[ar[fd]] = 0;
                        }
                    }
                }
            }

            case 2:
            {
                while(f >= 1)
                {
                    int min = 100; k = 0;
                    for(j=0; j<n; j++)
                    {
                        if(a[j] <= ct)
                        {
                            ar[k++] = j;
                        }
                    }
                    System.out.println("\nK: "+k);
                    if(k == 0)
                    {
                        ct++;
                    }
                    else{
                        for(j=0; j<k; j++)
                        {
                            if(min > p[ar[j]])
                            {
                                min = p[ar[j]];
                                fd = j;
                            }
                        }
                        System.out.println("G = "+fd);
                        b[ar[fd]]--;
                        System.out.println("\nB: "+b[ar[fd]]);
                        ct++;
                        System.out.println("\nCT: "+ct);

                        if(b[ar[fd]] == 0)
                        {
                            tat[ar[fd]] = ct - a[ar[fd]];
                            System.out.println("\nTAT: "+tat[ar[fd]]);
                            f--;
                            System.out.println("\nF: "+f);
                            wt = wt + tat[ar[fd]] - br[ar[fd]];
                            System.out.println("\nWT: "+wt);
                            a[ar[fd]] = 100;
                            p[ar[fd]] = 100;
                        }
                    }
                }
            }
        }
        for(i=0;i<n;i++)
        {
            sum =  sum + tat[i];
        }
        System.out.println("Average TAT: "+((float)sum/n) + "\n"+"Average WT: "+(wt/n));
    }
}
