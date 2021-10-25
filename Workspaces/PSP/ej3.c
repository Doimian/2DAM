#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  int v = 0;
  pid_t id = fork();
  if(id==-1)
    printf("Error al crear el proceso hijo");
  else if(id==0)
  {
    for(int i = 0;i < 100; i++)
    {
      printf("HIJO: mensaje numero %d, valor de la variable comun: %d\n",i,v);
      v++;
    }
  }
  else
  {
    for(int i = 0; i < 100; i++)
    {
      printf("PADRE: mensaje numero %d, valor de la variable comun: %d\n",i,v);
      v++;
    }
  }
}
