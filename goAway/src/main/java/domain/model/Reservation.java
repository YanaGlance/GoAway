package domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@NamedQueries({
       
       @NamedQuery(name = "reservation.all", query = "SELECT r FROM Reservation r"),
       @NamedQuery(name = "reservation.id", query = "SELECT r FROM Reservation r WHERE r.id=:reservationId")
    
})

public class Reservation implements IHaveId{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String recomendation;
    private String meal;
    @OneToOne
    private Client client;
    @OneToOne
    private Tour tour;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecomendation() {
		return recomendation;
	}
	public void setRecomendation(String recomendation) {
		this.recomendation = recomendation;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
    
}

