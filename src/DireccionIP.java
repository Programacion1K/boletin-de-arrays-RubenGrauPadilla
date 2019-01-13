public class DireccionIP {
    private int[] octetos=new int[4];
    private char categoriaIP;

    public int[] getOctetos(){
        int[] octeto=new int[4];
        String cadenaIntroducida="192.168.0.1";
        int posicionSalida=0;
        int posicionPuntos=0;
        int posicionArray=0;
        for (int i = 0; i < cadenaIntroducida.length(); i++) {

            if(cadenaIntroducida.charAt(i)==('.')){
                int octetoActual=Integer.parseInt(cadenaIntroducida.substring(posicionSalida,posicionPuntos));
                posicionSalida=posicionPuntos;
                octeto[posicionArray]=octetoActual;
                posicionArray++;
            }
            posicionPuntos++;
            int ultimoOcteto=Integer.parseInt(cadenaIntroducida.substring(posicionPuntos,i));
        }
        return octeto;
    }

    public char getCategoriaIP(){
        if(this.octetos[0]==10){
            categoriaIP='A';
        }
        if(this.octetos[0]==172){
            categoriaIP='B';
        }
        if(this.octetos[0]==192) {
            categoriaIP='C';
        }
        return categoriaIP;
    }

    public DireccionIP(String cadena){

    }

    public DireccionIP(int octeto1,int octeto2,int octeto3,int octeto4){
        this.octetos[0]=octeto1;
        this.octetos[1]=octeto2;
        this.octetos[2]=octeto3;
        this.octetos[3]=octeto4;
    }
    int[] ip=new int[4];
    public DireccionIP(int[] direccion){
        this.octetos[0]=direccion[0];
        this.octetos[1]=direccion[1];
        this.octetos[2]=direccion[2];
        this.octetos[3]=direccion[3];
    }



}
