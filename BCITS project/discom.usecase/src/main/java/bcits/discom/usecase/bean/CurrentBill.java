package bcits.discom.usecase.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="current_bill")
public class CurrentBill implements Serializable{
	@Id
	@Column(name="rr_number")
	private String rrNumber;
	@Column(name="due_date")
	private Date dueDate;
	@Column(name="prev_reading")
	private long previousReading;
	@Column(name="pres_reading")
	private long presenceReading;
	@Column
	private long consumption;
	@Column(name="bill_amount")
	private double billAmount;
	
}
