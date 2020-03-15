package Interfaces;

import clinic.classes.Labaratory;
import clinic.classes.Oculist;
import clinic.classes.Surgeon;
import clinic.classes.Therapist;

public interface BeingDiagnosed {
    void setOculistDiagnosis(Oculist oc);

    void setSurgeonDiagnosis(Surgeon su);

    void setTherapistDiagnosis(Therapist th);

    void setLabDiagnosis(Labaratory lab);
}
