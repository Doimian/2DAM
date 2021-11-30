/*
 * Damian
 * PSP 1.2.8 
 * Funcionamiento de las funciones ctime() y stime()
 * Explicación de las funciones:
 * CTIME
   Descripción: 
    - ctime - transform date and time to broken-down time or ASCII
  
   Librería: 
    - time.h
   
   Sinopsis:
    - char *ctime(const time_t *timep);

   Funcionamiento:
    - The ctime() function takes an argument of data type time_t, 
       which represents calendar time.

    - When interpreted as an absolute time value, it represents the
       number of seconds elapsed since the Epoch, 1970-01-01 00:00:00 +0000 (UTC).

   Ejemplo:
    - The call ctime(t) is equivalent to asctime(localtime(t)).  
       
    - It converts the calendar time t into a null-terminated string of the form: "Wed Jun 30 21:49:08 1993\n"

   Valor de retorno:
    - On success, ctime() returns a pointer to a string.

   Errores:
    - The result cannot be represented: EOVERFLOW

 * STIME
   Descripción: 
   - stime - set time
  
   Librería: 
   - time.h
   
   Sinopsis:
   - int stime(const time_t *t);

   Funcionamiento:
   - stime() sets the system's idea of the time and date.

   - The time, pointed to by t, is measured in seconds since the Epoch,
       1970-01-01 00:00:00 +0000 (UTC).  

   - stime() may be executed only by the superuser. 

   Valor de retorno:
   - On success, zero is returned.  

   - On error, -1 is returned, and errno is set to indicate the error.

   Errores:
   - EFAULT Error in getting information from user space.

   - EPERM  The calling process has insufficient privilege.  Under
              Linux, the CAP_SYS_TIME privilege is required.

 * */

#include <stdio.h>

int main(void)
{


    return 0;
}
