/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_appagenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author damian
 */
public class DI_AppAgenda
{
    public static void main(String[] args) 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DI_AppAgendaPU");
        EntityManager em = emf.createEntityManager();
        //Conexion

    }
}
