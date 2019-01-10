public class Metodos {

    public static void getOctetos(){
        String cadenaIntroducida="192.168.0.1";
        int posicionSalida=0;
        int posicionPuntos=0;
        for (int i = 0; i < cadenaIntroducida.length(); i++) {

            if(cadenaIntroducida.charAt(i)==('.')){
                int octetoActual=Integer.parseInt(cadenaIntroducida.substring(posicionSalida,posicionPuntos));
                posicionSalida=posicionPuntos;

            }
            posicionPuntos++;
        }
        return ;
    }

}
