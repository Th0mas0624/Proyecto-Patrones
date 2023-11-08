package model.entitys;

public class Background {
    Player player= Player.getInstance(0,0);
    public static int  x=0;
    public static int  y=0;

    public  void refreshBackground(){
        // 470  - 570
        if (player.xPosition>= 570){
            int aux = player.xPosition - 570;
            x = -1*aux;
        }
    }




}
