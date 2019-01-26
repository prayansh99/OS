import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        int j, i, ct = 0, tat, g = 0, f = 0, k;
        float tt = 0, wt = 0;
        System.out.println("Enter the number of processes");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int [n];
        int b[] = new int [n];
        int ar[] = new int [n];
        int p[] = new int [n];
        for(i=0; i<n; i++)
        {
            System.out.println("Enter the Arrival time for processes "+(i+1));
            a[i] = s.nextInt();
            System.out.println("Enter the Burst time for processes "+(i+1));
            b[i] = s.nextInt();
            System.out.println("Enter the Priority for processes "+(i+1));
            p[i] = s.nextInt();
        }
        System.out.println("Which value you want to give highest priority:\n1. Highest value\n2. Lowest Value");
        int c = s.nextInt();
        switch(c)
        {
            case 1: {
                while (f < n) {
                    int max = 0;
                    k = 0;
                    for (j = 0; j < n; j++) {
                        if (a[j] <= ct) {
                            ar[k++] = j;
                        }
                    }
                    //System.out.println("\nK: "+k);
                    if (k == 0) {
                        ct++;
                    } else {
                        for (j = 0; j < k; j++) {
                            if (max < p[ar[j]]) {
                                max = p[ar[j]];
                                g = j;
                            }
                        }
                        //System.out.println("G = "+g);
                        ct = ct + b[ar[g]];
                        //System.out.println("CT = "+ct);
                        tat = ct - a[ar[g]];
                        //System.out.println("TAT = "+tat);
                        tt = tt + tat;
                        //System.out.println("TT = "+tt);
                        wt = wt + tat - b[ar[g]];
                        //System.out.println("WT = "+wt);
                        a[ar[g]] = 100;
                        p[ar[g]] = 0;
                        f++;
                    }
                }
            }

            case 2:
            {
                while(f<n)
                {
                    int min = 100; k = 0;
                    for(j=0; j<n; j++)
                    {
                        if(a[j] <= ct)
                        {
                            ar[k++] = j;
                        }
                    }
                    //System.out.println("\nK: "+k);
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
                                g = j;
                            }
                        }
                        //System.out.println("G = "+g);
                        ct = ct + b[ar[g]];
                        //System.out.println("CT = "+ct);
                        tat = ct - a[ar[g]];
                        //System.out.println("TAT = "+tat);
                        tt = tt + tat;
                        //System.out.println("TT = "+tt);
                        wt = wt + tat - b[ar[g]];
                        //System.out.println("WT = "+wt);
                        a[ar[g]] = 100;
                        p[ar[g]] = 100;
                        f++;
                    }
                }
            }
        }
        System.out.println("Average TAT: "+(tt/n) + "\n"+"Average WT: "+(wt/n));
    }
}
