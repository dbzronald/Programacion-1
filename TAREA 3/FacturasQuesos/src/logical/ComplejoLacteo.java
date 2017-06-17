package logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ComplejoLacteo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Factura> Facturas;
	private ArrayList<Quesos> InventarioQuesos;
	private static ComplejoLacteo miComplejo;
	private Factura fact;
	private Clientes client;
	private int ID = 1;
	private int ID2 = 1;
	public ComplejoLacteo()
	{
		super();
		this.Facturas = new ArrayList<Factura>();
		this.InventarioQuesos = new ArrayList<Quesos>();
		
	}
	
	public static ComplejoLacteo getInstance()
	{
		if(miComplejo == null){
			miComplejo = new ComplejoLacteo();
		}
		
		return miComplejo;
	}
	public static void setComplejoLacteo(ComplejoLacteo miComp){
		ComplejoLacteo.miComplejo = miComp;
	}
	
	public ArrayList<Quesos> getInventarioQuesos() {
		return InventarioQuesos;
	}

	public void setInventarioQuesos(ArrayList<Quesos> InventarioQuesos) {
		this.InventarioQuesos = InventarioQuesos;
	}
	
	public ArrayList<Factura> getListaFacturas() {
		return Facturas;
	}

	public void setListaFacturas(ArrayList<Factura> Facturas) {
		this.Facturas = Facturas;
	}

	public void addFactura(Factura fact){
		this.Facturas.add(fact);
	}
	
	public void addInventario(Quesos ques){
		InventarioQuesos.add(ques);
	}
	public void deleteQueso(Factura  delFact){
		this.InventarioQuesos.remove(delFact);
	}
	public Quesos buscarQueso(int id){
		Quesos ques = null;
		
		for(int i = 0; i<InventarioQuesos.size(); i++){
			if(InventarioQuesos.get(i).getId()==id){
				ques = InventarioQuesos.get(i);
			}
		}
		return ques;
		
	}
		public int getID() {
			return ID;
		}

		public void setID(int ID) {
			this.ID = ID;
		}

		public int getID2() {
			return ID2;
		}

		public void setID2(int ID2) {
			this.ID2 = ID2;
		}
		
					
		public void loadComp(ComplejoLacteo comp) {
			 try {
				    FileInputStream f = new FileInputStream("Datos.dat");
					ObjectInputStream ob = new ObjectInputStream(f);
					ComplejoLacteo  com = (ComplejoLacteo)ob.readObject();
					ComplejoLacteo.setComplejoLacteo(com);
					ob.close();
				 
				} catch (Exception e) {	
					e.printStackTrace();
				}
			
		}
		public void saveComp(ComplejoLacteo comp){
		  	 File f = new File("Datos.dat");
			 FileOutputStream fo = null;
			 ObjectOutputStream ob = null;
			try {
				 fo = new FileOutputStream(f);
				 ob = new  ObjectOutputStream (fo);
				 ob.writeObject(comp);
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try{
					if(ob!= null){
						ob.close();
					}
						
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
	}
	
			
		
			
		}
		

		


