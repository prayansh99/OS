import java.util.Scanner;

public class A
{
    public static void main(String[] args) {
        int j, i, ct = 0, f = 0, fd=-1, sum = 0;
        float tt = 0, wt = 0, rt = 0;
        System.out.println("Enter the number of processes");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int [n];
        int b[] = new int [n];
        int ar[] = new int [n];
        int br[] = new int [n];
        int tat[] = new int [n];
        f = n;
        for(i=0; i<n; i++)
        {
            System.out.println("Enter the Arrival time for processes "+(i+1));
            a[i] = s.nextInt();
            System.out.println("Enter the Burst time for processes "+(i+1));
            b[i] = s.nextInt();
        }
        for(i=0;i<n;i++)
        {
            br[i] = b[i];
        }
        System.out.println("\nF: "+f);
        while(f >= 1)
        {
            int k =0;
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
            else
            {
                int min = 0;
                for(j=0; j<k; j++)
                {
                    if( min > b[ar[j]])
                    {
                        min = b[ar[j]];
                        fd = j;
                    }
                }
                System.out.println("\nFD: "+fd);
                b[ar[fd]]--;
                System.out.println("\nB: "+b[ar[fd]]);
                ct++;
                System.out.println("\nCT: "+ct);
                if( br[ar[fd]] == b[ar[fd]] +1 )
                {
                    rt = rt + ct - a[ar[fd]] - 1;
                    System.out.println("\nRT: "+rt);
                }
                if(b[ar[fd]] == 0)
                {
                    tat[ar[fd]] = ct - a[ar[fd]];
                    System.out.println("\nTAT: "+tat[ar[fd]]);
                    f--;
                    System.out.println("\nF: "+f);
                    wt = wt + tat[ar[fd]] - br[ar[fd]];
                    System.out.println("\nWT: "+wt);
                    a[ar[fd]] = 100;
                }
            }
        }
        for(i=0;i<n;i++)
        {
            sum =  sum + tat[i];
        }
        System.out.println("Avg TAT: "+((float)sum/n)+"\n"+"Avg WT: "+(wt/n)+"\n"+"Avg RT: "+(rt/n));
    }
}
