package demo.entity;

public class Acaunt {
	
	private String name;
	
	private String accountNumber;
	
	private String owner;
	
	private String recordType;
	
	private String Site;
	
	private String Fax;
	
	private String Website;
	
	private String Phone;

	public Acaunt(String name) {
		super();
		this.name = name;
	}

	public Acaunt(String name, String accountNumber, String site,
			String fax, String website,  String phone) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		Site = site;
		Fax = fax;
		Website = website;
		Phone = phone;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getSite() {
		return Site;
	}

	public void setSite(String site) {
		Site = site;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	
}
