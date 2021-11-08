#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(int argc,char* argv[])
{
   char* nularg[] = {"",NULL};
  //Comprobamos que el comando tiene 2 atributos: la ruta del archivo que queremos ejecutar
  //y la forma de ejecucion
  if (argc!=3)
  {
    printf("El comando requiere 2 atributos ==> ./ej1 /ruta/programa -x\n");
  }
  else
  {
    if(argv[2][0] == '-' && argv[2][1] == 'l')
      execl(argv[1],"",NULL);
    else if(argv[2][0] == '-' && argv[2][1] == 'v')
      execv(argv[1],nularg);
    else
       printf("Prueba utilizando el segundo atributo -l o -v (no tengo mas)\n");
  }
   return 0;
}
