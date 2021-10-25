#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>

/* Manejadores de señales*/
void sigusr1_handler(int s);
void sigterm_handler(int s);




int main(void)
{
  /* Registrar los manejadores de señales propios */
  signal(SIGALRM, SIG_IGN);

  /**
    codigo
   asdf
  asdf
 asdf */


  return 0;
}
