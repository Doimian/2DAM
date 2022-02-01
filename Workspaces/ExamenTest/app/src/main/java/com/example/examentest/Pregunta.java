package com.example.examentest;

public class Pregunta {

    //Atributos
    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private int respuesta_correcta;

    public Pregunta(String pregunta, String respuesta1, String respuesta2, int respuesta_correcta) {
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta_correcta = respuesta_correcta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public int getRespuesta_correcta() {
        return respuesta_correcta;
    }
}
