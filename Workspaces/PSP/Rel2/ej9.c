/*
 * Ejercicio 1.2.9
 * Tiempos
*/

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/time.h>
#include <math.h>
#include <time.h>

#define MICROSEGUNDOS 1000000

/* Prototipos */
void run_time(struct timeval, struct timeval, struct timeval *);
int main(void)
  {
    struct timeval tiempo_inicial;
    struct timeval tiempo_final;
    struct timeval tiempo_total;
    struct timezone tz;
    int i, j;

    /* Semilla */
    srand(time(NULL));

    /* Lee el tiempo actual */
    gettimeofday(&tiempo_inicial, &tz);

    /*Cualquier fragmento de codigo que quiera cronometrar */
    for(i = 0; i < 10000 ; i++)
      for(j = 0; j < 10000 ; j++)
        sqrt((double) rand());

    /*Punto 2 -> Lee el tiempo actual */
    gettimeofday(&tiempo_final, &tz);

    /* Calcula el tiempo consumido entre punto 1 y punto 2 */
    run_time(tiempo_inicial, tiempo_final, &tiempo_total);

    /*Muestra el tiempo consumido */
    printf("runtime -> [%lus:%luus]\n", tiempo_total.tv_sec, tiempo_total.tv_usec);
    return 0;
  }

void run_time(struct timeval tv1, struct timeval tv2, struct timeval *tvt)
  {
    /* Convierte a microsegundos */
    suseconds_t ti = tv1.tv_sec * MICROSEGUNDOS + tv1.tv_usec;
    suseconds_t tf = tv2.tv_sec * MICROSEGUNDOS + tv2.tv_usec;

    /*Diferencia de tiemop */
    suseconds_t ms_total = tf - ti;

    /*Resorna el tiempo en tvt*/
    tvt->tv_sec = ms_total / MICROSEGUNDOS;
    tvt->tv_usec = ms_total % MICROSEGUNDOS;

  }
