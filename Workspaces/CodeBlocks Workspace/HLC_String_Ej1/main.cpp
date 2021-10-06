#include <iostream>

using namespace std;

string SubCadena(string, int, int);
int main()
{
    string s1 = "1234567890";
    string result;



    cout << s1;

    return 0;
}
string SubCadena(string s1, int lon, int start)
{
    char buffer[lon+1];

    buffer.replace(start, lon, s1);

}
