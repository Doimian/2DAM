/*
 * FIFO
 * Tuberia con nombre
*/


#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(void)
{
  int fd;
  int leidos;
  int f;
  char byte;
  /* Crea una tuberia */
  f = mkfifo("fifo", S_IFIFO | 0777);
  if(f < 0)
  {
    printf("Error al crear el FIFO\n");
    return -1;
  }

  /*Fifo Creado*/
  while(!0)
  {
    fd = open("fifo", O_RDONLY);
    if(fd == -1)
    {
        printf("Error al abrir FIFO");
        return -2;
    }
    printf("Leyendo datos del FIFO\n");
     /*Lectura*/
    leidos = read(fd, &byte, sizeof(byte));
    printf("Leido -> %d\n", leidos);
    while(leidos > 0)
    {
      printf("%c", byte);
      leidos = read(fd, &byte, sizeof(byte));
    }
    /*Cierra FIFO*/
    close(fd);
  }
  return 0;
}
