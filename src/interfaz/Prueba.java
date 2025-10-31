
package interfaz;
import dominio.*;
public class Prueba {
   public static void main(String[] args){
       Sistema sistema = new Sistema();
       seleccionSistema s = new seleccionSistema(sistema);
       s.setVisible(true);
   } 
}
