import java.util.Scanner;

public class App {
    static char[] k = new char[10];
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        char player_side; //to store player1 choice x or o
        char player_1;
        char player_2;
        int input_1=0;         //user input value given to the board throug keys 1-9
        char current_player_token; //stores current player's token x or o
        char option;         //stores y or n for game continuation option

        System.out.println("Welcome to Tic-Tac-Toe1");
        while(true){
            //this loop is for clearing the board also initialising with value ' '
            for(int i = 0;i<10;i++){
                k[i] = ' ';
            }
            System.out.println("Player 1 please select your side, x or o");
            player_side = scanner.next().charAt(0); // reading character//receiving the side
            scanner.nextLine(); //handle next line character(enter key)
            player_1 = player_side;  //assigning sides
            if(player_side == 'x'|| player_side == 'o'){        //if(player_side == ('x'||'o')) not working why
                if(player_1 == 'x'){
                    player_2 = 'o';
                }
                else{
                    player_2 = 'x';
                }
            System.out.println("Player 1 is "+player_1+" and Player 2 is "+player_2);
                                
            }
            else{
            System.out.println("Choose correct character");            
            continue; //go back and enter correct character
            }
    
            boolean player_flag = false; /*To switch between player1 and player2, value false for player1 and value true for
            player2. After each time a player is played flag value will be switched*/
            while(true){
                boolean winner_flag = false;   /*Stores the value returned by winner_check function, value "false" for no 
                results and boolean value "true" for win*/
                if(!player_flag){
                    current_player_token = player_1;
                    System.out.println("Player 1 enter input "+current_player_token);                    
                    board_input.input_to_board(input_1, current_player_token, k);
                    board.board_print(k);
                    winner_flag = winner.winner_check(k, current_player_token, "Player1");
                    
                    if(winner_flag){
                        /*This piece of code decides to continue game or not after winning*/
                        System.out.println("Would you like to continue, press y to continue and n to end");
                        option = scanner.next().charAt(0);
                        if(option == 'y'){
                            break;
                        }
                        else{
                            //return;
                            System.exit(0);
                        }
                    }
                    player_flag = true;
                }
                else{
                    current_player_token = player_2;
                    System.out.println("Player 2 enter input "+current_player_token);                    
                    board_input.input_to_board(input_1, current_player_token, k);
                    board.board_print(k);
                    winner_flag = winner.winner_check(k, current_player_token, "Player2");
                    if(winner_flag){
                        /*This piece of code decides to continue game or not*/
                        System.out.println("Would you like to continue, press y to continue and n to end");                                       
                        option = scanner.next().charAt(0);
                                               
                        if(option == 'y'){
                            break;
                        }
                        else{
                            //return;
                            System.exit(0);
                        }
                    }
                    player_flag = false;
    
                }
    
                /*Below statements check if the board is full, if all the positions are not ' '
                then it will be draw condition*/
                if(k[1]!= ' '&& k[1]!= ' '&& k[2]!= ' '&& k[3]!= ' '&& k[4]!= ' '&& k[5]!= ' '&&
                   k[6]!= ' '&& k[7]!= ' '&& k[8]!= ' '&& k[9]!= ' '){ 
                    System.out.println("Well, its a draw"); 
                        
                    /*This piece of code decides to continue game or not*/
                    System.out.println("Would you like to continue, press y to continue and n to end");  
                    option = scanner.next().charAt(0);
                    if(option == 'y'){
                        break;
                    }
                    else{
                        //return;      //or System.exit(0);
                        System.exit(0);
                    }
                    
                }
              
            }      
    
            
        }  
      
        
    }
}

