public class board_input {

/*First find out which key is pressed and then stores the token x or o of the corresponding
player to board positions matching with the key positions*/

    static void input_to_board(int input_1, char current_player_token, char[] k){
       
        input_1 = App.scanner.nextInt();
        App.scanner.nextLine(); //handle next line character(enter key)
        if(input_1 == 1){
            k[1] = current_player_token;
        }
        else if(input_1 == 2){
            k[2] = current_player_token;
        }
        else if(input_1 == 3){
            k[3] = current_player_token;
        }
        else if(input_1 == 4){
            k[4] = current_player_token;
        }
        else if(input_1 == 5){
            k[5] = current_player_token;
        }
        else if(input_1 == 6){
            k[6] = current_player_token;
        }
        else if(input_1 == 7){
            k[7] = current_player_token;
        }
        else if(input_1 == 8){
            k[8] = current_player_token;
        }
        else if(input_1 == 9){
            k[9] = current_player_token;
        }
}
}
