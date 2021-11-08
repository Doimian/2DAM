#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  //El pid asignado a este proceso:
  pid_t pid = getpid();
  printf("The pid of this process is %d\n", pid);

  //El pid padre de este proceso:
  pid_t ppid = getppid();
  printf("The pid of the parent of this process is %d\n", ppid);

  //El propietario de este proceso:
  pid_t prop = getuid();
  printf("The user id of the owner of this process is %d\n",prop);
}
