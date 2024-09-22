public class cards {
    
    String name;
    String suit;
    int rank;

    cards(){}

    //setters
    void set_name(String name){
        this.name = name;
    }

    void set_suit(String suit){
        this.suit = suit;
    }

    void set_rank(int rank){
        if(rank>10){
           this.rank = 10; 
        }
        else{
            this.rank = rank;
        }            
    }
    
    //getters
    void get_name_of_card(){        
        System.out.println(name + " of " + suit);
    }
    int get_value(){
        return rank;
    }
    String get_name(){
        return name;
    }
}
