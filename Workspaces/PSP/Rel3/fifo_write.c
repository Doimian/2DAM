/*
 * FIFO
 * Tuberia con nombre
 * write
*/


#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>

int main(void)
{
  int fd;
  char msg[] = "Saludos desde otro proceso\n";

  /* Abre FIFO */
  fd = open("fifo", O_WRONLY);
  if(fd < 0)
    {
      printf("Error, no puedo abrir FIFO");
      return -1;
    }

  /*Como esta abierto -> envia mensaje */
  if(write(fd, msg, strlen(msg)) < 0)
      printf("Error, hay problemas a escribir en el FIFO");

  /*Close*/
  close(fd);
  return 0;
}
