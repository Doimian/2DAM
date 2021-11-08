#include <stdio.h>
#include <stdlib.h>

/*
 * Un proceso zombi es un proceso que sobrevive a su padre, es decir, el proceso creador termina antes que el hijo.
 * Esto es malo porque el proceso zombi es inaccesible y ocupa memoria inútil, aunque hoy en dia los procesadores tienen mecanismos que se encargan de purgar procesos zombis siempre es mejor evitarlos.
 *
 * Para crear un proceso zombi vamos a crear un proceso hijo y terminar el proceso principal
 *
*/


int main(void)
{
  //dividimos el proceso en padre e hijo
  pid_t id = fork();

  if(id == -1)
    printf("Error al crear el proceso");
  else if(id != 0)
  {
    //Matamos el proceso padre
    return 0;
  }
  else if (id == 0)
  {
    //Este es el proceso hijo
   printf("Im a Zombi!\n");
   printf("    ___  \n");
   printf("  _/ ..\\ \n");
   printf(" ( \\  0/__\n");
   printf("  \\    \\__)\n");
   printf("  /     \\\n");
   printf(" /      _\\ \n");
   printf(" ````````` \n");
  }
}
