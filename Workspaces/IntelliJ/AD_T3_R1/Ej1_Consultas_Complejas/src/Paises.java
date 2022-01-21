public class Paises {

    private int id;
    private String nombrepais;

    public Paises()
    {
        this.id = 0;
        this.nombrepais = "";
    }

    public Paises(int id, String nombrepais)
    {
        this.id = id;
        this.nombrepais = nombrepais;
    }

    public int getId()
    {
        return id;
    }

    public String getNombrepais()
    {
        return nombrepais;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setNombrepais( String nombrepais)
    {
        this.nombrepais = nombrepais;
    }

}

