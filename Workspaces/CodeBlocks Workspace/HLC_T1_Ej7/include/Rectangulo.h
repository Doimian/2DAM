
class Rectangulo
{
    public:
        Rectangulo();
        virtual ~Rectangulo();
        void setLon(int);
        void setAn(int);
        int getLon();
        int getAn();
    private:
        int longitud;
        int ancho;
};
