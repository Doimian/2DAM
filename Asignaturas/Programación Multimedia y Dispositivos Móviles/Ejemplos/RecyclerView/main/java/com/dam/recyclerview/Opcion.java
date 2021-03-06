package com.dam.recyclerview;

public class Opcion
{
    // Cada opción tiene un título, un subtítulo y un icono
    private String titulo;
    private String subtitulo;
    private int icono;

    public Opcion(String titulo, String subtitulo,  int icono)
    {
        this.setTitulo(titulo);
        this.setSubtitulo(subtitulo);
        this.setIcono(icono);
    }

    // Definimos los getters y setters de la clase
    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getSubtitulo()
    {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo)
    {
        this.subtitulo = subtitulo;
    }

    public int getIcono()
    {
        return icono;
    }

    public void setIcono(int icono)
    {
        this.icono = icono;
    }
}
