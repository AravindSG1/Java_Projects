public class chips {
    
    int chip_value;

    //constructors
    chips(){}
    chips(int chip_value){
       this.chip_value = chip_value; 
    }
    //setters
    void set_chip_value(int chip_value){
        this.chip_value = chip_value;
    }
    void set_change_chip_value(int chip_value){
        this.chip_value+=chip_value;
    }

    //getters
    int get_chip_value(){
        return chip_value;
    }
}
