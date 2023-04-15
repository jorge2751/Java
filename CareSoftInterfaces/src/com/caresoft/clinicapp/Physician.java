package com.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {

	private ArrayList<String> patientNotes;
	
	public Physician(Integer id) {
		super(id);
	}

	@Override
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() == 4) {
			this.setPin(pin);
			return true;
		}else return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID.equals(this.id)) {
			return true;
		} else return false;
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
	
}
