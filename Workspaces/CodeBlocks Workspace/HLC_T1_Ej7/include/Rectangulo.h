#include <iostream>
#define MIN_VAL 0
#define MAX_VAL 20
using namespace std;

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
