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

    /* Establece el valor de los campos  */
    temporizador.it_value.tv_sec = 5;
    temporizador.it_value.tv_usec = 0;
    temporizador.it_interval.tv_sec = 5;
    temporizador.it_interval.tv_usec = 0;

    /*Establece el manejador del temporizador */
    signal(SIGALRM, handler_sigalarm);

    /* Establece  */
    setitimer(ITIMER_REAL, &temporizador, &temporizador_old);

    /*Ciclo de espera de señales */
    for(;;)
    {
      pause();
    }
    
    return 0;
  }

void handler_sigalarm(int sig)
  {
    printf("Alarma!! -> Han pasado 3 segundos");
  }
