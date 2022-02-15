import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import config.HibernateUtil;
import entities.Departamento;
import entities.Empleado;
import jakarta.persistence.NoResultException;

/**
 * Hello world!
 *
 */
public class Main 
{
    //Iniciamos la sesión hibernate
    private static Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();
    private static Scanner sc = new Scanner(System.in);

    public static void main( String[] args )
    {

        //datosIniciales();

        menu();
        
        sesionHibernate.close();
    }

    public static void menu()
    {
        int index = 0;
        while(index <8)
        {
            System.out.println("\nElija una opción del menu (otro numero para salir):");
            System.out.println("1. Listar todos los empleados");
            System.out.println("2. Listar todos los departamentos");
            System.out.println("3. Mostrar un empleado por código");
            System.out.println("4. Mostrar los empleados que pertenezcan a un departamento (por codigo)");
            System.out.println("5. Mostrar los empleados que pertenezcan a un departamento (por nombre)");
            System.out.println("6. Mostrar para cada departamento: codigo, nombre, nº empleados y media del sueldo");
            index = sc.nextInt();
            String flush = sc.nextLine();
            switch(index)
            {
                case 1: listarEmpleados(); break;
                case 2: listarDepartamentos(); break;
                case 3: listarEmpleadoCod(); break;
                case 4: listarEmpleadoDepCod(); break;
                case 5: listarEmpleadoDepNombre(); break;
                case 6: listarDatosDep(); break;
                default: System.out.println("Bye..."); return;
            }
        }
    }

    public static void datosIniciales()
    {
        Departamento dep1 = new Departamento(1, "informatica");
        Departamento dep2 = new Departamento(2, "biologia");
        Departamento dep3 = new Departamento(3, "marketing");
        Departamento dep4 = new Departamento(4, "direccion");

        Empleado emp1 = new Empleado(1, "Juan", "Jimenez", 1200, dep1);
        Empleado emp2 = new Empleado(2, "Maria", "Perez", 2300, dep4);
        Empleado emp3 = new Empleado(3, "Pedro", "Garcia", 1290, dep2);
        Empleado emp4 = new Empleado(4, "Silvia", "Caceres", 4300, dep1);
        Empleado emp5 = new Empleado(5, "Diego", "Sanchez", 1300, dep2);
        Empleado emp6 = new Empleado(6, "Antonio", "Jerez", 2300, dep3);

        Transaction tx = sesionHibernate.beginTransaction();
        sesionHibernate.save(dep1);
        sesionHibernate.save(dep2);
        sesionHibernate.save(dep3);
        sesionHibernate.save(dep4);
        sesionHibernate.save(emp1);
        sesionHibernate.save(emp2);
        sesionHibernate.save(emp3);
        sesionHibernate.save(emp4);
        sesionHibernate.save(emp5);
        sesionHibernate.save(emp6);
        tx.commit();
    }
    public static void listarEmpleados()
    {
        //Sacamos datos
        Query queryEmp = sesionHibernate.createQuery("from Empleado");
        List<Empleado> empleados = queryEmp.list();
        Iterator<Empleado> iterEmp = empleados.iterator();
        
        //Mostramos la información en pantalla
        while(iterEmp.hasNext())
        {
            Empleado empleado = iterEmp.next();
            System.out.println(empleado.getNombre() + " " + empleado.getApellidos() + " " + empleado.getSalario() + "€ (Dep: " +empleado.getDpto().getNombre() + " Nº: " + empleado.getDpto().getCodept() + ") ");
        }

    }
    public static void listarDepartamentos()
    {
        //Sacamos datos
        Query queryDep = sesionHibernate.createQuery("from Departamento");
        List<Departamento> departamentos = queryDep.list();
        Iterator<Departamento> iterDep = departamentos.iterator();

        //Mostramos la información en pantalla
        while(iterDep.hasNext())
        {
            Departamento departamento = iterDep.next();
            System.out.println(departamento.getCodept() + " " + departamento.getNombre());
        }

    }
    public static void listarEmpleadoCod()
    {
        //Pedimos el codigo
        System.out.println("Escribe el código del empleado");
        int cod = sc.nextInt();
        String flush = sc.nextLine();

        //Sacamos el dato
        Query queryEmp = sesionHibernate.createQuery("from Empleado where codemple = :cod");
        queryEmp.setParameter("cod", cod);
        try
        {
            Empleado empleado = (Empleado) queryEmp.getSingleResult();
            System.out.println(empleado.getNombre() + " " + empleado.getApellidos() + " " + empleado.getSalario() + "€ (Dep: " +empleado.getDpto().getNombre() + " Nº: " + empleado.getDpto().getCodept() + ") ");
        } catch(NoResultException e)
        {
            System.out.println("No existe ningún empleado con ese código");
        }
    }
    public static void listarEmpleadoDepCod()
    {
        //Pedimos el codigo
        System.out.println("Escribe el código del departamento");
        int cod = sc.nextInt();
        String flush = sc.nextLine();

        //Sacamos los datos
        /*
        Query queryEmp = sesionHibernate.createQuery("from Empleado where dpto.codept = :cod");
        queryEmp.setParameter("cod", cod);
        List<Empleado> empleados = queryEmp.list();
        if(empleados.isEmpty()){
            System.out.println("No existe el departamento o está vacío");
        }
        for(Empleado empleado : empleados)
        {
            System.out.println(empleado.getNombre() + " " + empleado.getApellidos() + " " + empleado.getSalario() + "€ (Dep: " +empleado.getDpto().getNombre() + " Nº: " + empleado.getDpto().getCodept() + ") ");
        }
        */
        Query query = sesionHibernate.createQuery("from Departamento where codept = :pinga");
        query.setParameter("pinga", cod);
        Departamento dep = (Departamento) query.getSingleResult();
        
        for (Empleado empleado : dep.getEmpleados()) {
            System.out.println("El empleado se llama " + empleado.getNombre());
            
        }
    }
    public static void listarEmpleadoDepNombre()
    {
        //Pedimos el codigo
        System.out.println("Escribe el nombre del departamento");
        String nombre = sc.nextLine().trim();

        //Sacamos los datos
        Query queryEmp = sesionHibernate.createQuery("from Empleado where dpto.nombre = :nom");
        queryEmp.setParameter("nom", nombre);
        List<Empleado> empleados = queryEmp.list();
        if(empleados.isEmpty()){
            System.out.println("No existe el departamento o está vacío");
        }
        for(Empleado empleado : empleados)
        {
            System.out.println(empleado.getNombre() + " " + empleado.getApellidos() + " " + empleado.getSalario() + "€ (Dep: " +empleado.getDpto().getNombre() + " Nº: " + empleado.getDpto().getCodept() + ") ");
        }
    }
    public static void listarDatosDep()
    {
        //Sacamos datos
        /* Formato con doble consulta
        Query queryDep = sesionHibernate.createQuery("from Departamento");
        Query queryEmp = sesionHibernate.createQuery("from Empleado where dpto.codept = :cod");
        List<Departamento> departamentos = queryDep.list();
        for(Departamento dep : departamentos)
        {
        
            double avgSalario = 0;
            queryEmp.setParameter("cod", dep.getCodept());
            List<Empleado> empleados = queryEmp.list();
            for(Empleado empleado : empleados)
            {
                avgSalario += empleado.getSalario();
            }
            avgSalario /= empleados.size();
            System.out.println("El Departamento " + dep.getNombre() + ", con codigo " + dep.getCodept() + " tiene " + empleados.size() + " empleados, con salario medio " + avgSalario + "€");
        }
        */
        //Formato con una consulta
        Query query = sesionHibernate.createQuery("from Departamento");
        List<Departamento> departamentos = query.list();
        for(Departamento departamento : departamentos)
        {
            List<Empleado> empleados = departamento.getEmpleados();
            int avgSalario = 0;
            
            for(Empleado empleado : empleados)
            {
                avgSalario += empleado.getSalario();
            }
                System.out.println("El Departamento " + departamento.getNombre() + ", con codigo " + departamento.getCodept() + " tiene " + empleados.size() + " empleados, con salario medio " + (avgSalario / empleados.size()) + "€");
        }
    }
}