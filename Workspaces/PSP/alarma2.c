/*
 *  Ejemplo alarmas/ Temporizadores
 *
*/
#include <stdio.h>
#include <sys/time.h>
#include <unistd.h>
#include <signal.h>

void handler_sigalarm(int sig);

int main(void)
  {
    struct itimerval temporizador, temporizador_old;


    /*Establece el manejador del temporizador */
    signal(SIGALRM, handler_sigalarm);
	
    printf("Alarma en 5 seg...\n");
    alarm(5);
    /*Ciclo de espera de señales */
    for(;;)
    {
      pause();
    }
    
    return 0;
  }

void handler_sigalarm(int sig)
  {
    printf("Alarma ! han pasado 5 segundos\n");
    alarm(5);
  }
