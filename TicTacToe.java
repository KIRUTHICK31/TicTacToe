import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class TicTacToe {
  static ArrayList<Integer> playerPos = new ArrayList<Integer>();
  static ArrayList<Integer> cpuPos = new ArrayList<Integer>();
public static void main(String[] args) {
  char [][]board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
  printBoard(board);

while(true){
  Scanner sc = new Scanner(System.in);
System.out.println("Enter the place to fill your coin ");
int playerPlace = sc.nextInt();
while(playerPos.contains(playerPlace)|| cpuPos.contains(playerPlace)){
  System.out.println("The place already taken");
  playerPlace = sc.nextInt();
}

coinPlace(board, playerPlace,"player");
String res = checkwinner();
if(res.length()>0){
  System.out.println(res);
  break;
}
Random rand = new Random();
int cpuPlace = rand.nextInt(9)+1; //the random generate from (0-end-1)so we add +1
while(playerPos.contains(cpuPlace)|| cpuPos.contains(cpuPlace)){
 
  cpuPlace =  rand.nextInt(9)+1;
}
coinPlace(board, cpuPlace,"cpu");

printBoard(board);
   res = checkwinner();
   if(res.length()>0){
    System.out.println(res);
    break;
   }

}
}

 
   private static void printBoard(char [][] board) {
    for(char ele[] : board){
      System.out.print("|");
      for(char c : ele){
        System.out.print(c+"|");
      }
      System.out.println();
      System.out.println("--+-+--");
    }
  }
  private static void coinPlace(char[][]board,int place,String user){
    char symbol ='X';
    if(user.equals("player")){
      symbol = 'X';
      playerPos.add(place);
     
    }
    else if(user.equals("cpu")){
     symbol = 'O';
     cpuPos.add(place);
    }
    switch (place){
      case 1-> board[0][0]= symbol;
      case 2 -> board[0][1]= symbol;
      case 3 -> board[0][2]= symbol;
      case 4 -> board[1][0]= symbol;
      case 5 -> board[1][1]= symbol;
      case 6 -> board[1][2]= symbol;
      case 7 -> board[2][0]= symbol;
      case 8 -> board[2][1]= symbol;
      case 9-> board[2][2]= symbol;
      default->System.out.println("not valid pos");
    
    }
  }

  private static String checkwinner(){
   List topRow = Arrays.asList(1,2,3);
   List midRow = Arrays.asList(4,5,6);
   List botRow = Arrays.asList(7,8,9);
   List lefCol = Arrays.asList(1,4,7);
   List rigCol = Arrays.asList(2,5,8);
   List midCol = Arrays.asList(3,6,9);
   List cross1 = Arrays.asList(1,5,9);
   List cross2 = Arrays.asList(3,5,7);
 
    List<List> wincond = new ArrayList<List>();
    wincond.add(topRow);
    wincond.add(midRow);
    wincond.add(botRow);
    wincond.add(lefCol);
    wincond.add(rigCol);
    wincond.add(midCol);
    wincond.add(cross1);
    wincond.add(cross2);

    for(List l : wincond){
      if(playerPos.containsAll(l)){
        return "you are winner";
      }
      else if(cpuPos.containsAll(l)){
        return "cpu winner";
      }
      else if(playerPos.size() + cpuPos.size() == 9 ){
        return "Draw";
      }
    }
 return "";
  } 
}
