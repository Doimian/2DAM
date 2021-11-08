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
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author damian
 */
public class ConsultaProvincias 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Map<String,String> emfProperties = new HashMap<String,String>();
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("DI_AppAgendaPU",emfProperties);
        EntityManager em = emf.createEntityManager();
        
        //SELECT
    /*
        Query queryProvincias = em.createNamedQuery("Provincia.findAll");
        List<Provincia> listProvincias = queryProvincias.getResultList();
        for(Provincia provincia : listProvincias)
        {
            System.out.println(provincia.getNombre() + "    \t" + provincia.getCodigo());
        }
    */
        //UPDATE
    /*
        Query queryProvinciaSevilla = em.createNamedQuery("Provincia.findByNombre");
        queryProvinciaSevilla.setParameter("nombre", "Sevilla");
        List<Provincia> listProvinciasCadiz =queryProvinciaSevilla.getResultList();
        em.getTransaction().begin();
        
        for(Provincia provinciaCadiz : listProvinciasCadiz)
        {
            provinciaCadiz.setCodigo("SE");
            em.merge(provinciaCadiz);
        }
        em.getTransaction().commit();
    */    
        //DELETE
        int codDel = 15;
        Provincia provinciaDel = em.find(Provincia.class, codDel);
        em.getTransaction().begin();
        if (provinciaDel != null)
        {
            em.remove(provinciaDel);
        }
        else
        {
            System.out.println("No hay ninguna provincia con ID=" + codDel);
        }
        em.getTransaction().commit();
        
        
        
        //Cerrar la conexion
        em.close();
        emf.close();
        try{
        DriverManager.getConnection("jdbc:derby:DBAgenda;shutdown=true");
        } catch (SQLException ex){/*Siempre salta este error*/}

    }
    
}
