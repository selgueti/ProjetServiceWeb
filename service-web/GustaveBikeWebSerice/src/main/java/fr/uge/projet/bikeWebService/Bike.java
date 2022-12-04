package fr.uge.projet.bikeWebService;

import java.io.IOException;
import javax.xml.namespace.QName;

import org.apache.axis.encoding.SerializationContext;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.wsdl.fromJava.Types;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;

public class Bike implements Serializer {
	public int id;
	public String name;
	public boolean available;
	public long price;
	public String[] comments;

	public Bike() {
	}

	public Bike(int id, String name, long price, String[] comments) {
		this.id = id;
		this.name = name;
		this.available = true;
		this.price = price;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isAvailable() {
		return available;
	}

	public long getPrice() {
		return price;
	}

	public String[] getComments() {
		return comments;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public void setComments(String[] comments) {
		this.comments = comments;
	}

	public String getMechanismType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void serialize(QName arg0, Attributes arg1, Object arg2, SerializationContext arg3) throws IOException {
		// TODO Auto-generated method stub

	}

	public Element writeSchema(Class arg0, Types arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
