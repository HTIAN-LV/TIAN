//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.book.entity;

public class UserDB {
    private String name;
    private String lendtime;
    private String returntime;
    private String state;
    private String people;
    private String account;
    private String password;


    public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserDB() {
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLendtime() {
		return lendtime;
	}


	public void setLendtime(String lendtime) {
		this.lendtime = lendtime;
	}


	public String getReturntime() {
		return returntime;
	}


	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPeople() {
		return people;
	}


	public void setPeople(String people) {
		this.people = people;
	}


	@Override
	public String toString() {
		return "UserDB [name=" + name + ", lendtime=" + lendtime + ", returntime=" + returntime + ", state=" + state
				+ ", people=" + people + "]";
	}
}

   
