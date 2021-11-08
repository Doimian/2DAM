#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void)
{
  int gi = 0;
  for(int j = 0; j < 5; j++)
  {
    pid_t id = fork();
    if(id == 0)
      {

        printf("Hijo con codigo identificador %d\n", j);
        for(int i = 0; i < 10; i++)
        {
          printf("Hijo %d, Local i: %d, Global gi: %d\n", j, i, gi);
          gi++;
        }
        exit(0);
      }
      if(id > 0)
      {
        for(int i = 0; i<5;i++)
          wait(NULL);
        return 0;
      }
  }
}
