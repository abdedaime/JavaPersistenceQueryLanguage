package com.example.tesUnitaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;

import com.example.dao.DepartementDao;
import com.example.dao.EmployeDao;
import com.hicham.model.Departement;
import com.hicham.model.Employe;

import static org.junit.Assert.*;

public class Test {
	private EmployeDao dao;
	private DepartementDao dao1;

	@Before
	public void setUp() throws Exception {
		dao = new EmployeDao();
		dao1 = new DepartementDao();
	}

	@org.junit.Test
	public void test() throws ParseException {
		//
		// Departement departement = new Departement("Physique");
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// dao.add(new Employe("ahmed", departement,
		// format.parse("2015-10-15")));
		// Employe emp=new Employe();
		// emp.setId(1);
		// Employe empf=dao.retrieve(emp);
		// assertNotNull(empf);

		// dao1.addDeparetement(departement);
		// afficher la liste des employe avec le nom departement
		// System.err.println("---------information -------");
		// List<Employe> emp=dao.getAll();
		// System.out.println("  nom    "+ " date   embauche"+ "departement ");
		// for(Employe e :emp){
		// System.out.println(""+e.getId()+
		// "      "+e.getDepartement().getName());
		// }

		// afficher le nombre des employe par deparetement
		// http://stackoverflow.com/questions/6955993/how-to-get-select-values-and-count-value-with-jpa-group-by
		// System.out.println("afficher le nombre des employe par departement");
		// List<Object[]> maliste = dao.getNumberEmployeBydepartement();
		// System.out.println(" nombre_emp  " + "departemnt"
		// );
		// for (Object[] o : maliste) {
		// Departement d = (Departement) o[1];
		// Long nb = (Long) o[0];
		// System.out.println(" " + nb + "  "
		// + d.getName());
		// }

		// la recherche by date between
		// SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		// @SuppressWarnings("deprecation")
		// List<Employe> emp=dao.getEmployeBetwenTodate(
		// format.parse("2009-11-10"),format.parse("2011-02-30") );
		// for(Employe e: emp){
		//
		// Date dt=e.getDateEmbauche();
		// System.out.println( format.format(dt) +"   " +e.getName());
		//
		// }

		for (Object[] em : new EmployeDao().getSommeSalDepartement()) {
			 Departement d = (Departement)em[0];
			 double nb = (double) em[1];
			 System.out.println(" somme " + nb + "  "
						 + d.getName());
		}

	}
}
