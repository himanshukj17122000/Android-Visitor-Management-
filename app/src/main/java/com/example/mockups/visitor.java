package com.example.mockups;



import java.io.Serializable;

public class visitor implements Serializable {
    private String id = "";
    private String phoneem = "";
    private String email = "";
    private String name = "";
    private byte[] photo;
    private String type = "";
    private String address ="";
    private String companyname ="";
    private String addphone ="";
    private String addname ="";
    private String addrel ="";
    private String purpose ="";
    private String whom ="";
    private String outtime ="";




    public String getId() {
        if(id==null){
            return ""; } else{
                return id;
            }

    }

    public String getPhoneem() {
        if(phoneem==null){
            return ""; } else{
            return phoneem;
        }
    }

    public String getName() {
        if(name==null){
            return ""; } else{
            return name;
        }
    }

    public byte[] getPhoto() {
        if(photo==null){
            return null; } else{
            return photo;
        }
    }

    public String getType() {
        if(type==null){
            return ""; } else{
            return type;
        }

    }

    public String getAddress() {
        if(address==null){
            return ""; } else{
            return address;
        }
    }

    public String getCompanyname() {
        if(companyname==null){
            return ""; } else{
            return companyname;
        }
    }

    public String getPurpose() {
        if(purpose==null){
            return ""; } else{
            return purpose;
        }
    }

    public String getWhom() {
        if(whom==null){
            return ""; } else{
            return whom;
        }
    }

    public String getOuttime() {
        if(outtime==null){
            return ""; } else{
            return outtime;
        }
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setPhoneem(String phoneem) {
        this.phoneem = phoneem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setWhom(String whom) {
        this.whom = whom;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }


    public String getEmail() {
        if(email==null){
            return ""; } else{
            return email;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddphone() {
        if(addphone==null){
            return ""; } else{
            return addphone;
        }
    }

    public void setAddphone(String addphone) {
        this.addphone = addphone;
    }

    public String getAddname() {
        if(addname==null){
            return ""; } else{
            return addname;
        }
    }

    public void setAddname(String addname) {
        this.addname = addname;
    }

    public String getAddrel() {
        if(addrel==null){
            return ""; } else{
            return addrel;
        }
    }

    public void setAddrel(String addrel) {
        this.addrel = addrel;
    }
}



