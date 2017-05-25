/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


/**
 *
 * @author tiago.lucas
 */
@FacesValidator("dataValidator")
public class DataValidator implements Validator{
    private String diferenca;
    private String str;
    
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }  
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String strInicio = (String)component.getAttributes().get("inicio");
        String strFim = (String)component.getAttributes().get("fim");
        str=(String)value;
        /*
        Calendar cl;
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("dd.MM.yy");*/
        try{
            Date d,a,a1,d1,b1;
            //DateFormat dt = DateFormat.getDateInstance();
            DateFormat dt2 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
            d1=dt2.parse(strInicio);
            a1=dt2.parse(strFim);
            b1=dt2.parse(str);
            long a3 = a1.getTime() - d1.getTime();
            Calendar cl = Calendar.getInstance();
            cl.setTimeInMillis(a3);
            System.out.println("Result: "+Math.abs(cl.getTimeInMillis()/(60*60*24*1000)));
            diferenca=String.valueOf(Math.abs(cl.getTimeInMillis()/(60*60*24*1000)));
            if(d1.getTime()<=b1.getTime() && b1.getTime()<=a1.getTime()){
                FacesMessage fm = new FacesMessage("Data aceita. Diferença: "+diferenca);
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }else{
                FacesMessage fm = new FacesMessage("Data inválida. Diferença: "+diferenca);
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                //throw new ValidatorException(fm);
            }
            
            
        }catch(Exception ex){
            diferenca="Erro: "+ex;
        }
        //setDiferenca(strFim);
    }

    public String getDiferenca() {
        return diferenca;
    }

    public void setDiferenca(String diferenca) {
        this.diferenca = diferenca;
    }
    
}
