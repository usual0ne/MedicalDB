package clinic.classes;

import Interfaces.BeingDiagnosed;
import Interfaces.ShowDiagnoses;

public class Patient implements BeingDiagnosed, ShowDiagnoses
{
    private String name;
    private String sex;
    private int hemoglobin;
    private String oculistDiagnosis;
    private String surgeonDiagnosis;
    private String therapistDiagnosis;
    private String labDiagnosis;

    public Patient(String name, String sex, int hemoglobin)
    {
        this.setName(name);
        this.setSex(sex);
        this.setHemoglobin(hemoglobin);
    }


    //set methods
    private void setName(String name) {this.name = name;}

    private void setSex(String sex) {this.sex = sex;}

    private void setHemoglobin(int hemoglobin) {this.hemoglobin = hemoglobin;}

    //public setters only for med staff
    @Override
    public void setOculistDiagnosis(Oculist oc) { this.oculistDiagnosis = oc.examine(); }

    @Override
    public void setSurgeonDiagnosis(Surgeon su) { this.surgeonDiagnosis = su.examine(); }

    @Override
    public void setTherapistDiagnosis(Therapist th) { this.therapistDiagnosis = th.examine(); }

    @Override
    public void setLabDiagnosis(Labaratory lab) { this.labDiagnosis = lab.getAnalysis(this); }

    //get methods
    public String getName() { return name; }

    public String getSex() { return this.sex; }

    public int getHemoglobin() { return this.hemoglobin; }

    @Override
    public String getOculistDiagnosis() { return this.oculistDiagnosis; }

    @Override
    public String getSurgeonDiagnosis() { return this.surgeonDiagnosis; }

    @Override
    public String getTherapistDiagnosis() { return this.therapistDiagnosis; }

    @Override
    public String getLabDiagnosis() { return this.labDiagnosis; }
}
