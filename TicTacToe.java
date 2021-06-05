import java.lang.*;
import java.util.*;
public class TicTacToe{

    static ArrayList<Integer> playersPositions = new ArrayList<Integer>(); 
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args){

        char [] [] gameBoard = {{' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '}};
          
           while(true){
           Scanner sc = new Scanner(System.in);
           System.out.println("Enter your placement 1-9");
          
           int playerPos = sc.nextInt();
           while(playersPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
               System.out.println("Positions Taken! Enter a correct postion");
               playerPos = sc.nextInt();
           }
           
              PiecePos(gameBoard, playerPos, "player");
              

              Random rm = new Random();
              int cpuPos = rm.nextInt(9) + 1; 
              while(playersPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                System.out.println("Positions Taken! Enter a correct postion");
                cpuPos = rm.nextInt(9) + 1; 
                
            }
              PiecePos(gameBoard, cpuPos, "cpu");
          
          
           printGameBoard(gameBoard);

           Winner();
           
         
           }
        }
    public static void printGameBoard(char [] [] gameBoard){
         for(char [] row : gameBoard){
             for(char c : row){
                System.out.print(c);
             }
             System.out.println();
         }
    }
    public static void PiecePos(char [] [] gameBoard, int pos, String user){
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            playersPositions.add(pos);
        }else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(pos);
        }
        switch(pos){
            case 1:
             gameBoard[0] [0] = symbol;
            break;
            case 2:
             gameBoard[0] [2] = symbol;
            break;
            case 3:
             gameBoard[0] [4] = symbol;
            break;
            case 4:
             gameBoard[2] [0] = symbol;
            break;
            case 5:
             gameBoard[2] [2] = symbol;
            break;
            case 6:
             gameBoard[2] [4] = symbol;
            break;
            case 7:
             gameBoard[4] [0] = symbol;
            break;
            case 8:
             gameBoard[4] [2] = symbol;
            break;
            case 9:
             gameBoard[4] [4] = symbol;
            break;
            default:
            System.out.println("Game error");
              break;
        }
    }

    public static void Winner(){
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List leftDiag = Arrays.asList(1, 5, 9);
        List rightDiag = Arrays.asList(3, 5, 7);

        List<List> win = new ArrayList<List>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(rightCol);
        win.add(leftDiag);
        win.add(rightDiag);

        for(List l : win){
            if(playersPositions.containsAll(l)){
                System.out.println("Congrats you won! :)");
                System.exit(0);
            
            }else if(cpuPositions.containsAll(l)){
                System.out.println("CPU won! Sorry :(");
                System.exit(0);
            } else if(playersPositions.size() + cpuPositions.size() == 9){
                 System.out.println("CAT!");
            }
        }
    }
}
