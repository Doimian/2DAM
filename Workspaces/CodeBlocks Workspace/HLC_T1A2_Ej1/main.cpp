#include "Complejo.h"

using namespace std;

int main(void)
{

    cout << "Hello world!" << endl;
    Complejo a = Complejo(15,15);
    Complejo b = Complejo(5,5);

    cout << "Complejo a = "; a.toString(); cout << endl;
    cout << "Complejo b = "; b.toString(); cout << endl;
    cout << "a + b = "; (a+b).toString(); cout << endl;


    return 0;
}
