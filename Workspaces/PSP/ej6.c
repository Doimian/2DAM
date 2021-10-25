#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  int contador = 0;
  for(int i = 0; i < 5; i++)
  {
    pid_t id = fork();
  }
  contador += 1;
  printf("hola%d\n",contador);
  return 0;
}
