
package blackjackfx;


public class Dealer {
    public int chipCount= 100;
    
       private void startNewGame() {
          


}
       public int getChipCount(){
           return chipCount;
       }
       public int afterBet(int betamt){
           chipCount = chipCount - betamt;
           return chipCount;
           
           
       }
}
