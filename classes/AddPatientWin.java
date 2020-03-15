package clinic.classes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AddPatientWin
{
    @FXML
    private CheckBox maleField;
    @FXML
    private TextField nameField;
    @FXML
    private CheckBox femaleField;
    @FXML
    private TextField hemoglobinField;
    @FXML
    private Button addAndCloseButton;
    @FXML
    private void handleMaleField()
    {
        if(maleField.isSelected())
        {
            femaleField.setSelected(false);
        }
    }

    @FXML
    private void handleFemaleField()
    {
        if(femaleField.isSelected())
        {
            maleField.setSelected(false);
        }
    }


    @FXML
    void initialize()
    {
        addAndCloseButton.setOnAction(event ->
        {
            String name = nameField.getText().trim();
            int hemo = Integer.parseInt(hemoglobinField.getText().trim());
            boolean validPatient = !(name.isEmpty() || (hemo > 180 || hemo < 100) || (!femaleField.isSelected() && !maleField.isSelected()));
            if (validPatient == false)
            {
                Shake patientName = new Shake(nameField);
                Shake patientHemo = new Shake(hemoglobinField);
                Shake checkboxMale = new Shake(maleField);
                Shake checkboxFemale = new Shake(femaleField);

                patientName.showAnim();
                patientHemo.showAnim();
                checkboxMale.showAnim();
                checkboxFemale.showAnim();
            }
            else
            {
                if (maleField.isSelected())
                {
                    DatabaseHandler.patientToDb(name, "M", hemo);

                    Patient patient = new Patient(name, "M", hemo);
                    Surgeon su = new Surgeon();
                    Therapist th = new Therapist();
                    Oculist oc = new Oculist();
                    Labaratory lab = new Labaratory();
                    patient.setOculistDiagnosis(oc);
                    patient.setSurgeonDiagnosis(su);
                    patient.setTherapistDiagnosis(th);
                    patient.setLabDiagnosis(lab);

                    DatabaseHandler.diagnosesToDb(patient.getTherapistDiagnosis(), patient.getOculistDiagnosis(),
                            patient.getSurgeonDiagnosis(), patient.getLabDiagnosis());
                }
                else
                {
                    DatabaseHandler.patientToDb(name, "F", hemo);

                    Patient patient = new Patient(name, "F", hemo);
                    Surgeon su = new Surgeon();
                    Therapist th = new Therapist();
                    Oculist oc = new Oculist();
                    Labaratory lab = new Labaratory();
                    patient.setOculistDiagnosis(oc);
                    patient.setSurgeonDiagnosis(su);
                    patient.setTherapistDiagnosis(th);
                    patient.setLabDiagnosis(lab);

                    DatabaseHandler.diagnosesToDb(patient.getTherapistDiagnosis(), patient.getOculistDiagnosis(),
                            patient.getSurgeonDiagnosis(), patient.getLabDiagnosis());
                }

                SceneHandler.close();
            }
        });
    }
}

