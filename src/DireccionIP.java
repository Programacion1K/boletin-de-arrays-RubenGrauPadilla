public class DireccionIP {
    private int[] octetos=new int[4];
    private char categoriaIP;
    private int[] mascaraRed=new int[4];
    private int[] idRed=new int[4];

    private static final int[] MASCARA_TIPO_A={255,0,0,0};
    private static final int[] MASCARA_TIPO_B={255,255,0,0};
    private static final int[] MASCARA_TIPO_C={255,255,255,0};

    public int[] getOctetos(){
        return octetos;
    }

    public char getCategoriaIP(){
        return categoriaIP;
    }

    public int[] getMascaraRed(){
        return mascaraRed;
    }

    public int[] getIdRed(){
        return idRed;
    }

    public void setOctetos(int[] octetos){
        this.octetos=octetos;
    }

    public void setCategoriaIP(char categoriaIP){
        this.categoriaIP=categoriaIP;
    }

    public void setMascaraRed(int[] mascaraRed){
        this.mascaraRed=mascaraRed;
    }

    public void setIdRed(int[] idRed){
        this.idRed=idRed;
    }

    public int[] obtenerOctetos(String direccionIP){
        int[] octeto=new int[4];
        String cadenaIntroducida="";
        int posicionSalida=0;
        int posicionPuntos=0;
        int posicionArray=0;
        for (int i=0;i<cadenaIntroducida.length();i++) {

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

    public char determinarCategoriaIP(DireccionIP direccionIP){
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

    public int[] obtenerMascaraRed(String direccionIP){
        if(categoriaIP=='A'){
            mascaraRed=MASCARA_TIPO_A;
        }
        if(categoriaIP=='B'){
            mascaraRed=MASCARA_TIPO_B;
        }
        if(categoriaIP=='C'){
            mascaraRed=MASCARA_TIPO_C;
        }
        return mascaraRed;
    }

    public int[] obtenerIDRed(DireccionIP direccionIP){
        int[] idRed={0,0,0,0};
        for (int i=0;i<idRed.length;i++) {
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
        this.categoriaIP=determinarCategoriaIP(DireccionIP);
        this.idRed=obtenerIDRed(DireccionIP);
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

    @Override
    public String toString(){
        return this.octetos[0]+"."+this.octetos[1]+"."+this.octetos[2]+"."+this.octetos[3];
    }
}
