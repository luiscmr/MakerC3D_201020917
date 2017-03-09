package org.compi2.codigo3d.parser;

/**
 *
 * @author esvux
 */
public class ControlC3D {
    
    private static int temp = 0;
    private static String c3d = "";
    private static int etq = 0;
    private static String etqsV = "";
    private static String etqsF = "";
    
    /**
     * Reinicia las variables estáticas relacionadas con la generación del
     * código de tres direcciones.
     */
    public static void reiniciar(){
        temp = 0;
        c3d = "";
        etq = 0;
        etqsV = "";
        etqsF = "";
    }
    
    /**
     * Genera el siguiente temporal.
     * @return El siguiente temporal (t$#)
     */
    public static String generaTemp(){
        return "t$"+temp++;
    }
    
    public static String generarEtiqueta(){
        return "L"+etq++;
    }
    
    /**
     * Agrega la sentencia que recibe como parámetro a la cadena de código
     * de tres direcciones que se va generando hasta ese momento.
     * @param sentencia Código 3D a agregar
     */
    public static void agregarC3D(String sentencia){
        c3d += sentencia;
    }
    public static void agregarEtqV(String etiqueta){
        if(etqsV.equals("")){
            etqsV = etiqueta;
        }else{
            etqsV += ","+etiqueta;
        }
    }
    public static void agregarEtqF(String etiqueta){
        if(etqsF.equals("")){
            etqsF = etiqueta;
        }else{
            etqsF += ","+etiqueta;
        }
    }
    
    /**
     * Devuelve el código 3D generao hasta el momento de su invocación.
     * @return Código 3D generado
     */
    public static String getC3D(){
        if(etqsV.equals("")||etqsF.equals("")){
            c3d += "////Último valor: t"+(temp-1);
            return c3d;
        }else{
            c3d += "//Etiqueta(s) de Verdadero: " + etqsV +"\n";
            c3d += "//Etiqueta(s) de Falso: " + etqsF +"\n";
            return c3d;
        }
    }
    
}
