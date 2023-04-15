package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<>();
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		ArrayList<String> output = new ArrayList<>();
		for (String incident: securityIncidents) {
			output.add(incident); 
		}
		return output;
	}

	@Override
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() >= 6) {
			this.setPin(pin);
			return true;
		}else return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID.equals(this.pin)) {
			return true;
		} else {
			authIncident();
			return false;
		}
	}
	
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

}
