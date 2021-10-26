#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void)
{
  int global = 0;

  pid_t id = fork();

  if(id == -1)
  {
    printf("Error al crear el proceso hijo");
  }
  else if(id == 0)
  {
    for(int i = 0; i < 100; i++)
    {
      global += 1;
      printf("HIJO: La variable global vale %d\n",global);
    }
  }
  else
  {
    for(int i = 0; i < 100; i++)
    {
      global += 1;
      printf("PADRE: La variable global vale %d\n",global);
    }
  }
  return 0;
}
