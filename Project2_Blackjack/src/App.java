import java.util.Scanner;

public class App {


    static int deck_size = 52; //no of cards in deck
    static int player_hand_size = 0; //stores the number of cards in player hand
    static int dealer_hand_size = 0; //stores the number of cards in dealer hand
    static int position; //gives the position to pop according to deck size
    static boolean dealer_win_flag = false;  //true for win, helps to exit main while loop while dealer wins on a hit
    static int player_sum = 0; //stores the current sum of player hand
    static int dealer_sum = 0; //stores the current sum of dealer hand

    
    static int bet_amount = 0;           //stores the bet amount of chips
    static boolean winner_flag = false;     //if player wins false else true

    static cards[] Deck = new cards[52]; /*this is card array*/
     
    public static void main(String[] args) throws Exception {
        
        String[] Suits = new String[]{"Club", "Diamond", "Heart", "Spades"};  
        String[] Ranks = new String[]{"ace", "two", "three", "four", "five", "six", "seven",
                                    "eight", "nine", "ten", "King", "Jack", "Queen"};

        cards[] player_hand = null;// 
        cards[] dealer_hand = null;// 

        chips player_chip = new chips(1000);  //class which holds chips for player
        chips dealer_chip = new chips(1000);  //class which holds chips for dealer

        //Below code is deck creation
        for(int i= 0;i<Suits.length;i++){              
            for(int j= 0;j<Ranks.length;j++){        
            int index = i*(Ranks.length) +j;
            Deck[index] = new cards();     //creating individual card objects
            Deck[index].set_name(Ranks[j]);
            Deck[index].set_suit(Suits[i]);
            Deck[index].set_rank(j+1);
            }
        }
       

        //initialising player hand with 2 cards
        player_hand = array_funcs.add_to_hand(player_hand, array_funcs.deck_card_pop(Deck, position, deck_size), player_hand_size);
        player_hand_size++; //it is increased by 1 adding
        player_hand = array_funcs.add_to_hand(player_hand, array_funcs.deck_card_pop(Deck, position, deck_size), player_hand_size);
        player_hand_size++; //it is increased by 1 adding

        //initialising dealer hand with 2 cards
        dealer_hand = array_funcs.add_to_hand(dealer_hand, array_funcs.deck_card_pop(Deck, position, deck_size), dealer_hand_size);
        dealer_hand_size++; //it is increased by 1 adding
        dealer_hand = array_funcs.add_to_hand(dealer_hand, array_funcs.deck_card_pop(Deck, position, deck_size), dealer_hand_size);
        dealer_hand_size++; //it is increased by 1 adding

    
        player_sum = array_funcs.sum_of_cards(player_hand, player_hand_size); //gives the sum of cards inside a hand
        dealer_sum = array_funcs.sum_of_cards(dealer_hand, dealer_hand_size);
                
        System.out.println("Welcome to Blackjack");        
        System.out.println("Enter number of chips to bet");
     
        Scanner scanner1 = new Scanner(System.in);
        bet_amount = scanner1.nextInt();  //taking bet amount
        scanner1.nextLine();
         
        //printing card values
        for(int i = 0;i<player_hand_size;i++){  //printing player hand
            System.out.println("Player card " + (i+1));            
            player_hand[i].get_name_of_card();
        }        
        System.out.println("Player card sum = " + player_sum);
        //dealer hand with hidden card
        System.out.println("Dealer card 1");
        dealer_hand[0].get_name_of_card();   //dealer hand        
        System.out.println("Dealer card 2");                         
        System.out.println("Hidden card");
        //printing codes upto here

        while(!dealer_win_flag){
            if(player_sum<21){   
                
                System.out.println("Would you like to hit or stay, h for hit and s for stay"); 
                char choice;
                Scanner scanner2 = new Scanner(System.in);
                choice = scanner2.next().charAt(0);
                scanner2.nextLine();                
                if(choice == 'h'){
                    player_hand = array_funcs.add_to_hand(player_hand, array_funcs.deck_card_pop(Deck, position, deck_size), player_hand_size);
                    player_hand_size++; //it is increased by 1 adding
                    player_sum = array_funcs.sum_of_cards(player_hand, player_hand_size);
                    array_funcs.print_player_cards(player_hand, player_hand_size, player_sum);                    
                    System.out.println("Dealer card 1");
                    dealer_hand[0].get_name_of_card();   //dealer hand                    
                    System.out.println("Dealer card 2");                    
                    System.out.println("Hidden card");
                    continue; //this loop continues until the player stop hitting or busting or winning
                }
                else{                    
                    System.out.println("Now dealer hits");
                    if(dealer_sum>player_sum){  //this code works when player directly stay wit 0 hits
                        array_funcs.print_player_cards(player_hand, player_hand_size, player_sum);
                        array_funcs.print_dealer_cards(dealer_hand, dealer_hand_size, dealer_sum);                        
                        System.out.println("Dealer wins");
                        winner_flag = true;  //to give chips to dealer
                        break;
                    }
                    while(true){
                        dealer_hand = array_funcs.add_to_hand(dealer_hand, array_funcs.deck_card_pop(Deck, position, deck_size), dealer_hand_size);
                        dealer_hand_size++; //it is increased by 1 adding
                        dealer_sum = array_funcs.sum_of_cards(dealer_hand, dealer_hand_size);
                        
                        if(dealer_sum>21){                            
                            array_funcs.print_player_cards(player_hand, player_hand_size, player_sum);
                            array_funcs.print_dealer_cards(dealer_hand, dealer_hand_size, dealer_sum);                            
                            System.out.println("Dealer bust Player wins");
                            dealer_win_flag = true; //to exit main while loop
                            break; 
                        }
                        else if(dealer_sum>player_sum){                            
                            array_funcs.print_player_cards(player_hand, player_hand_size, player_sum);
                            array_funcs.print_dealer_cards(dealer_hand, dealer_hand_size, dealer_sum);                            
                            System.out.println("Dealer wins");
                            dealer_win_flag = true; //to exit main while loop
                            winner_flag = true;  //to give chips to dealer
                            break;
                        }
                    }
                }
            }
            else{
                array_funcs.print_player_cards(player_hand, player_hand_size, player_sum);
                array_funcs.print_dealer_cards(dealer_hand, dealer_hand_size, dealer_sum);                            
                System.out.println("Player bust Dealer wins");
                winner_flag = true;  //to give chips to dealer
                break;
            }
            
        }
        if(!winner_flag){
            player_chip.set_change_chip_value(bet_amount);   //when player wins
            System.out.println("Player chips = " + player_chip.get_chip_value());            
            dealer_chip.set_change_chip_value(-bet_amount);
            System.out.println("Dealer chips = " + dealer_chip.get_chip_value());            
        }
        else{
            player_chip.set_change_chip_value(-bet_amount);  //when dealer wins
            System.out.println("Player chips = " + player_chip.get_chip_value()); 
            dealer_chip.set_change_chip_value(bet_amount);
            System.out.println("Dealer chips = " + dealer_chip.get_chip_value());
        }
         scanner1.close();
           
            
        System.out.println("end");
    }
}
