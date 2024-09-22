import java.util.Random;

public class array_funcs {

    /*Returns a card popped from the deck*/
    static cards deck_card_pop(cards[] input_array, int position, int input_array_size){    
        // create instance of Random class
        Random rand = new Random();
        // Generate random integers in range 0 to input_array_size
        position = rand.nextInt(input_array_size+1); //problem when 0 comes
        App.position = position;
        cards[] temp_array;
        cards removed_one = input_array[position-1];
        //n-1 4

        temp_array = new cards[input_array_size-1];
        for(int i = 0; i<position-1;i++){     //pos-1 because index from 0 
            //temp_array[i] = new cards();
            temp_array[i] = input_array[i];    //here i ends at pos-2
            //temp_array[0].get_name_of_card();
        }
        for(int i = position-1;i<input_array_size-1;i++){   
            temp_array[i] = input_array[i + 1];
            //temp_array[position-1].get_name_of_card();
        }

        input_array_size = input_array_size-1; //new array length
        App.deck_size = input_array_size;
        
        input_array = temp_array;  //copying from temp to deck array in single go

        App.Deck = input_array;  //changing the deck to new value
        
        return removed_one;   //this will give the popped card from deck
    }


    /*Adds a new card to the hand*/
    static cards[] add_to_hand(cards[] input_array, cards input_card, int input_array_size){    
        
        cards[] temp_array = new cards[input_array_size+1]; 
        
        for(int i=0;i<input_array_size;i++){
            temp_array[i] = input_array[i];
        }
        input_array_size = input_array_size+1; //new array size
        
        temp_array[input_array_size-1] = input_card; //appending on last position
        
        input_array = temp_array;  
        
        return input_array;
    
    }

    /*Gives the sum of values of all cards inside a hand*/
    static int sum_of_cards(cards[] hand, int hand_size){
        int sum = 0;
        for(int i = 0;i<hand_size;i++){
            sum+= hand[i].get_value();
            
            if(sum<21 && hand[i].name == "ace"){ //ace default value is 1, so first adding 10 to get value 11
                sum+=10;                                
            }
            if(sum>21 && hand[i].name == "ace"){ //now checking if the value is not over 21 with 11 value
                sum-=10;                         //if its above 21 changing to value 1
            }
        }
        return sum;
    }
    /*Prints all cards inside player hand*/
    static void print_player_cards(cards[] player_hand, int player_hand_size, int player_sum){
        System.out.println(" "); 
        for(int i = 0;i<player_hand_size;i++){  //printing player hand
            System.out.println("Player card " + (i+1));     
            player_hand[i].get_name_of_card();
        }
        System.out.println("Player card sum = " + player_sum);    
    }
    /*Prints all cards inside dealer hand*/
    static void print_dealer_cards(cards[] dealer_hand, int dealer_hand_size, int dealer_sum){
        for(int i = 0;i<dealer_hand_size;i++){  //printing player hand
            System.out.println("Dealer card " + (i+1)); 
            dealer_hand[i].get_name_of_card();
        }
        System.out.println("Dealer card sum = " + dealer_sum);     
    }

}
