/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_appagenda;

import entities.Provincia;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.stage.Stage;
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
        Map<String,String> emfProperties = new HashMap<String,String>();
        emfProperties.put("javax.persistence.jdbc.user", "APP");
        emfProperties.put("javax.persistence.jdbc.password", "App");
        emfProperties.put("javax.persistence.schemageneration.database.action","create");
        emfProperties.put("javax.persistence.jdbc.url","jdbc:derby:DBAgenda;create=true");
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("DI_AppAgendaPU",emfProperties);
        
        EntityManager em = emf.createEntityManager();
        Provincia provinciaSevilla = new Provincia();
        provinciaSevilla.setNombre("Sevilla");
        
        /*Iniciamos una transacción*/
        em.getTransaction().begin();
        /*Insertamos los datos*/
        em.persist(provinciaSevilla);
        /*Esto es un Commit*/
        em.getTransaction().commit();
        
        //Cerrar la conexion
        em.close();
        emf.close();
        try{
        DriverManager.getConnection("jdbc:derby:DBAgenda;shutdown=true");
        } catch (SQLException ex){/*Siempre salta este error*/}

    }

}
