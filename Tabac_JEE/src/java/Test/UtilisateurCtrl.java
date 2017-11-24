
package Test;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

/**
 * @author M.SERAZIN & A.DAYRE
 */

@SessionScoped
@ManagedBean
public class UtilisateurCtrl implements Serializable {
    
    @EJB 
    private UtilisateurDao dao;
    private Utilisateur uti = new Utilisateur();
    private String idMarqueSelected;
    private LineChartModel animatedModel;
    private LineChartModel progModel;
    
    
    public UtilisateurCtrl(){
        
    }
    
    
    public List<Utilisateur> getUtilisateur(){
        return dao.findAll();
    }
    
    public void getIdMarqueSelected(String marque){
        this .idMarqueSelected=marque;
    }
    
    public String addUtilisateur(){
        if(uti.getAgeU()==null || uti.getPseudoU()==null || uti.getPassword()==null || uti.getConsommationU()==null || uti.getIdMarque()==null){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Remplissez tout les champs."));
            return "inscription";
        }
        initialiserDateInscription();
        dao.addUtilisateur(uti);
        return "mon_programme";
    }
    
    private void initialiserDateInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        this.uti.setDateInscription(date);
    }
    
    public String delUtilisateur(){
        dao.deleteUtilisateur(uti);
        this.uti.setAgeU(0);
        this.uti.setConsommationU(0);
        this.uti.setDateInscription(null);
        this.uti.setIdMarque(null);
        this.uti.setPassword("");
        this.uti.setPhotoU(null);
        this.uti.setProgrammeU(null);
        this.uti.setPseudoU("");
        return "index";
    }
    
   
    public String update(){
        dao.updateUtilisateur(uti);
       
        return "index";
    }

    public Utilisateur getUti() {
        return uti;
    }

    public void setUti(Utilisateur uti) {
        this.uti = uti;
    }
    
    public String deconnexion(){
        uti = new Utilisateur();
        return "index";
    }
    
    public String controlLogin(){
        if(!dao.isInBase(uti.getPseudoU(), uti.getPassword())){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur !", "Pseudo ou mot de passe incorrect"));
            return "connexion";
        }
        else{
            uti = dao.getBypseudoAndPsw(uti.getPseudoU(), uti.getPassword());
            return "mon_programme";
        }
        
    }
    
    public LineChartModel getAnimatedModel() {
        return createAnimatedModels();
    }
    
     public LineChartModel getProgModel() {
        return createProgModels();
    }
     
    public LineChartModel createAnimatedModels() {
        animatedModel = initLinearModel();
        animatedModel.setTitle("Programmes généraux");
        animatedModel.setAnimate(true);
        animatedModel.setLegendPosition("se");
        Axis yAxis = animatedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(40); 
        return animatedModel;
    }
    
     public LineChartModel createProgModels() {
        animatedModel = initProgModel();
        animatedModel.setTitle("Programme choisi");
        animatedModel.setAnimate(true);
        animatedModel.setLegendPosition("se");
        Axis yAxis = animatedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(40); 
        return animatedModel;
    }
     
    private LineChartModel initProgModel() {
        LineChartModel model = new LineChartModel();
        Date d=uti.getDateInscription();
        int reduc = uti.getProgrammeU().getNombrecmoinsP();
        LineChartSeries series = createSerie(d, reduc, "");
        model.addSeries(series);
        return model;
    }
    
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        Date d=uti.getDateInscription();
        LineChartSeries series1 = createSerie(d, 1, "Programme1");
        LineChartSeries series2 = createSerie(d, 2, "Programme2");
        LineChartSeries series3= createSerie(d, 5, "Programme3");
        LineChartSeries series4= createSerie(d, 10, "Programme4");
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
        model.addSeries(series4);
        return model;
    }
    
    
    private LineChartSeries createSerie(Date d, int reduc, String label){
        int date = d.getDate();
        LineChartSeries series = new LineChartSeries();
        series.setLabel(label);
        int i = uti.getConsommationU();
        while(i>=0){
            System.out.println(i);
            series.set(date,i);
            date++;
            if(i>0 && i-reduc<0){
                i=0;
            }
            else{
                i=i-reduc;
            }
        }
    return series;
    }
    
    private Date incrementDate(Date d){
       
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }
    
    
    public String prog1(){
        Programme prog = dao.getProgrammeUti(1);
        uti.setProgrammeU(prog);
        dao.updateUtilisateur(uti);
        return "mon_programme";
    }
    
    public String prog2(){
        Programme prog = dao.getProgrammeUti(2);
        uti.setProgrammeU(prog);
        dao.updateUtilisateur(uti);
        return "mon_programme";
    }
    
    public String prog3(){
        Programme prog = dao.getProgrammeUti(3);
        uti.setProgrammeU(prog);
        dao.updateUtilisateur(uti);
        return "mon_programme";
    }
    
    public String prog4(){
        Programme prog = dao.getProgrammeUti(4);
        uti.setProgrammeU(prog);
        dao.updateUtilisateur(uti);
        return "mon_programme";
    }

    
    
}
