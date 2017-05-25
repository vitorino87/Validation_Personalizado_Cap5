/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author tiago.lucas
 */
@ManagedBean
@RequestScoped
public class ExemploMB{

    /**
     * Creates a new instance of ExemploMB
     */
    public ExemploMB() {
    }
    
    private String dias;

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
    private DataValidator data = new DataValidator();

    public DataValidator getData() {
        return data;
    }

    public void setData(DataValidator data) {
        this.data = data;
    }

   

    
    
}
