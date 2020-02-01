import java.io.*;
class Tic_Tac_Toe
{
    private static void print(char arr[][])
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(arr[i][j]+"|");
            }
            System.out.println();
        }
    }

    private static int check(int r1, int c1, char Board[][])
    {
        int flag=0;
        for(int i=c1-2;i<=c1;i++)/**FOR:: -- -orientation */
        {
            if(i==0&&Board[r1][i]==Board[r1][i+1]&&Board[r1][i]==Board[r1][i+2])
            {
                flag++;
            }
        }
        for(int i=r1-2;i<=r1;i++)/**FOR:: |-orientation */
        {
            if(i==0&&Board[i][c1]==Board[i+1][c1]&&Board[i][c1]==Board[i+2][c1])
            {
                flag++;
            }
        }
        for(int i=r1-2,j=c1-2;i<=r1;i++,j++)/**FOR:: \-orientation */
        {
            if(i==0&&j==0&&Board[i][j]==Board[i+1][j+1]&&Board[i][j]==Board[i+2][j+2])
            {
                flag++;
            }
        }
        for(int i=r1-2,j=c1+2;i<=r1;i++,j--)/**FOR:: /-orientation */
        {
            if(i==0&&j==2&&Board[i][j]==Board[i+1][j-1]&&Board[i][j]==Board[i+2][j-2])
            {
                flag++;
            }
        }
        return(flag);
    }

    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char Board[][]=new char[3][3];
        int x=0;/**THIS IS TO CHECK THAT IF IT IS DRAW!!!*/
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                Board[i][j]='_';
            }
        }
        print(Board);
        System.out.println("Welcome to Tic-Tac-Toe Game::");
        System.out.println("=============================");       
        for(x=1;x<=4;x++)/**THIS IS WHERE THE LOOP RUNS FOR 4X2 TIMES*/
        {
            /**PLAYER 1 ROUND*/
            System.out.println("Player 1(X)be ready::");
            int input_i,input_j;
            System.out.println("Input row no(1-3)::");
            input_i=Integer.parseInt(br.readLine());
            if(input_i<=0||input_i>3)
            {
                System.out.println("ERROR!!Input row no(1-3)::");
                input_i=Integer.parseInt(br.readLine());
            }
            System.out.println("Input column no::");
            input_j=Integer.parseInt(br.readLine());
            if(input_j<=0||input_j>3)
            {
                System.out.println("ERROR!!Input column no(1-3)::");
                input_j=Integer.parseInt(br.readLine());
            }

            if(Board[input_i-1][input_j-1]=='_')
                Board[--input_i][--input_j]='X';
            else/**So that nobody can override the array location*/
            {
                System.out.println("ERROR! INPUT EMPTY LOCATION!!");
                System.out.println("Input row no(1-3)::");
                input_i=Integer.parseInt(br.readLine());
                if(input_i<=0||input_i>3)
                {
                    System.out.println("ERROR!!Input row no(1-3)::");
                    input_i=Integer.parseInt(br.readLine());
                }
                System.out.println("Input column no::");
                input_j=Integer.parseInt(br.readLine());
                if(input_j<=0||input_j>3)
                {
                    System.out.println("ERROR!!Input column no(1-3)::");
                    input_j=Integer.parseInt(br.readLine());
                }
                Board[--input_i][--input_j]='X';
            }
            /**CHECKING FOR PLAYER 1...*/
            int flag1=check(input_i,input_j,Board);
            if(flag1>=1)
            {
                System.out.println("\f");/**FLUSHSCREEN*/
                print(Board);
                System.out.println("Player 1 WINS!!");
                break;
            }
            System.out.println("\f");/**FLUSHSCREEN*/
            print(Board);            
            /**PLAYER 2 ROUND*/
            System.out.println("Player 2(O)be ready::");
            input_i=0;input_j=0;
            System.out.println("Input row no(1-3)::");
            input_i=Integer.parseInt(br.readLine());
            if(input_i<=0||input_i>3)
            {
                System.out.println("ERROR!!Input row no(1-3)::");
                input_i=Integer.parseInt(br.readLine());
            }
            System.out.println("Input column no::");
            input_j=Integer.parseInt(br.readLine());
            if(input_j<=0||input_j>3)
            {
                System.out.println("ERROR!!Input column no(1-3)::");
                input_j=Integer.parseInt(br.readLine());
            }

            if(Board[input_i-1][input_j-1]=='_')
                Board[--input_i][--input_j]='O';
            else/**So that nobody can override the array location*/
            {
                System.out.println("ERROR! INPUT EMPTY LOCATION!!");
                System.out.println("Input row no(1-3)::");
                input_i=Integer.parseInt(br.readLine());
                if(input_i<=0||input_i>3)
                {
                    System.out.println("ERROR!!Input row no(1-3)::");
                    input_i=Integer.parseInt(br.readLine());
                }
                System.out.println("Input column no::");
                input_j=Integer.parseInt(br.readLine());
                if(input_j<=0||input_j>3)
                {
                    System.out.println("ERROR!!Input column no(1-3)::");
                    input_j=Integer.parseInt(br.readLine());
                }
                Board[--input_i][--input_j]='O';
            }
            /**CHECKING FOR PLAYER 2...*/
            int flag2=check(input_i,input_j,Board);
            if(flag2>=1)
            {
                System.out.println("\f");/**FLUSHSCREEN*/
                print(Board);
                System.out.println("Player 2 WINS!!");
                break;
            }
            System.out.println("\f");/**FLUSHSCREEN*/
            print(Board);
            if(x==4)/**Player 1 gets one extra round after 8 total plays...*/
            {
                /**PLAYER 1 EXTRA ROUND*/
                System.out.println("Player 1(X)be ready::");
                input_i=0;input_j=0;
                System.out.println("Input row no(1-3)::");
                input_i=Integer.parseInt(br.readLine());
                if(input_i<=0||input_i>3)
                {
                    System.out.println("ERROR!!Input row no(1-3)::");
                    input_i=Integer.parseInt(br.readLine());
                }
                System.out.println("Input column no::");
                input_j=Integer.parseInt(br.readLine());
                if(input_j<=0||input_j>3)
                {
                    System.out.println("ERROR!!Input column no(1-3)::");
                    input_j=Integer.parseInt(br.readLine());
                }
                
                if(Board[input_i-1][input_j-1]=='_')
                    Board[--input_i][--input_j]='X';
                else/**So that nobody can override the array location*/
                {
                    System.out.println("ERROR! INPUT EMPTY LOCATION!!");
                    System.out.println("Input row no(1-3)::");
                    input_i=Integer.parseInt(br.readLine());
                    if(input_i<=0||input_i>3)
                    {
                        System.out.println("ERROR!!Input row no(1-3)::");
                        input_i=Integer.parseInt(br.readLine());
                    }
                    System.out.println("Input column no::");
                    input_j=Integer.parseInt(br.readLine());
                    if(input_j<=0||input_j>3)
                    {
                        System.out.println("ERROR!!Input column no(1-3)::");
                        input_j=Integer.parseInt(br.readLine());
                    }
                    Board[--input_i][--input_j]='X';
                }
                /**CHECKING FOR PLAYER 1...*/
                flag1=check(input_i,input_j,Board);
                if(flag1>=1)
                {
                    System.out.println("\f");/**FLUSHSCREEN*/
                    print(Board);
                    System.out.println("Player 1 WINS!!");
                    break;
                }
                System.out.println("\f");/**FLUSHSCREEN*/
                print(Board);
            }
        }
        if(x==5)/**THIS IS TO CHECK IF DRAW*/
        {
            System.out.println("\f");/**FLUSHSCREEN*/
            System.out.println("THAT IS A DRAW MATCH!!!");
        }
    }
}