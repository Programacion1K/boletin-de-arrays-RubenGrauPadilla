//public class DireccionesIP {
//    int[] octetos;
//
//    DireccionesIP mascaraRed;
//
//    DireccionesIP idRed;
//
//    DireccionesIP(int octeto1,int octeto2,int octeto3,int octeto4){
//        this.octetos=new int[4];
//        this.octetos[0]=octeto1;
//        this.octetos[1]=octeto2;
//        this.octetos[2]=octeto3;
//        this.octetos[3]=octeto4;
//    }
//
//    public DireccionesIP getIdRed(){
//        return new DireccionesIP(this.octetos[0],this.octetos[1],this.octetos[2],this.octetos[3]);
//    }
//
//    public DireccionesIP getMascaraRed(){
//        return new DireccionesIP(255,255,255,0);
//
//    }
//
//    @Override
//    public String toString(){
//        return this.octetos[0]+"."+this.octetos[0]+"."+this.octetos[0]+"."+this.octetos[0];
//    }
//}
