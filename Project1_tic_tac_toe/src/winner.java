public class winner {

    static boolean winner_check(char[] k, char current_player_token, String player_name){
        boolean a = false;
        if(((k[1]==k[2]&&k[2]==k[3]) && (k[1]!=' ')) || ((k[4]==k[5]&&k[5]==k[6]) && (k[4]!=' ')) ||
        ((k[7]==k[8]&&k[8]==k[9]) && (k[7]!=' ')) || ((k[1]==k[4]&&k[4]==k[7]) && (k[1]!=' ')) ||
        ((k[2]==k[5]&&k[5]==k[8]) && (k[2]!=' ')) || ((k[3]==k[6]&&k[6]==k[9]) && (k[3]!=' ')) ||
        ((k[1]==k[5]&&k[5]==k[9]) && (k[1]!=' ')) || ((k[3]==k[5]&&k[5]==k[7]) && (k[5]!=' '))){

            System.out.println(player_name + " played with " + current_player_token + " is the winner");
                        
            a = true;
        }
        return a;
    }

/*Winner logic- first looks if 3 straight positions are same the make sure that it is not an empty
space and then OR all the winning conditions*/
}
