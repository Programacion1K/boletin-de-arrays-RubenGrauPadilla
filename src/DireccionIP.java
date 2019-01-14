public class DireccionIP {
    private int[] octetos=new int[4];
    private char categoriaIP;
    private int[] mascaraRed=new int[4];
    private int[] idRed=new int[4];

    public int[] obtenerOctetos(String direccionIP){
        int[] octeto=new int[4];
        String cadenaIntroducida="";
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

    public char determinarCategoriaIP(int[] octetos){
        if(this.octetos[0]<128){
            categoriaIP='A';
        }
        if(this.octetos[0]>=128 && this.octetos[0]<192){
            categoriaIP='B';
        }
        if(this.octetos[0]>=192 && this.octetos[0]<224) {
            categoriaIP='C';
        }
        return categoriaIP;
    }

    public int[] obtenerMascaraRed(String ip){
        if(categoriaIP=='A'){
            int[] mascaraRed={255,0,0,0};
        }
        if(categoriaIP=='B'){
            int[] mascaraRed={255,255,0,0};
        }
        if(categoriaIP=='C'){
            int[] mascaraRed={255,255,255,0};
        }
        return mascaraRed;
    }

    public int[] obtenerIDRed(DireccionIP ip){
        int[] idRed={0,0,0,0};
        for (int i = 0; i < idRed.length; i++) {
            if(this.mascaraRed[i]!=0){
                this.idRed[i]=this.octetos[i];
            }else{
                this.idRed[i]=0;
            }
        }
        return idRed;
    }

    public DireccionIP(String direccionIP){
        this.octetos=obtenerOctetos(direccionIP);
        this.mascaraRed=obtenerMascaraRed(direccionIP);
        this.categoriaIP=determinarCategoriaIP();
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
